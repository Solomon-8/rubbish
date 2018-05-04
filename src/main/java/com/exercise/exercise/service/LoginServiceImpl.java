package com.exercise.exercise.service;

import com.exercise.exercise.dataobject.UserInfoDO;
import com.exercise.exercise.exception.CustomError;
import com.exercise.exercise.exception.LocalRuntimeException;
import com.exercise.exercise.mapper.UserInfoDOMapper;
import com.exercise.exercise.model.LoginModel;
import com.exercise.exercise.model.RegisterModel;
import com.exercise.exercise.model.UserInfo;
import com.exercise.exercise.util.RedisService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Solomon
 * @date 2018/4/29
 */
@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private UserInfoDOMapper userInfoDOMapper;

    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");

    @Override
    public String login(LoginModel loginModel) {
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();
        UserInfoDO userInfoDO = userInfoDOMapper.selectByUsername(username);
        if (userInfoDO == null){
            throw new LocalRuntimeException(CustomError.USER_NOT_EXIST);
        }else{
            String hashed = userInfoDO.getPassword();
            if (BCrypt.checkpw(password,hashed)){
                String sessionId = UUID.randomUUID().toString().replace("-","");
                UserInfo userInfo = new UserInfo(userInfoDO.getUserId(),userInfoDO.getNick(),userInfoDO.getEmail()
                        ,userInfoDO.getAvatar(),null,userInfoDO.getGender());
                redisService.setToCacheAsync(sessionId,userInfo,180,TimeUnit.DAYS);
                return sessionId;
            }else{
                throw new LocalRuntimeException(CustomError.PASSWORD_ERROR);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String register(RegisterModel registerModel) {
        String email = registerModel.getEmail();
        Integer gender = registerModel.getGender();
        String password = registerModel.getPassword();
        String username = registerModel.getUsername();
        String userId = UUID.randomUUID().toString();
        String sessionId = UUID.randomUUID().toString().replace("-","");
        UserInfoDO userInfoDO = userInfoDOMapper.selectByUsername(username);
        UserInfo userInfo = new UserInfo(userId,username,email,"",password,gender);
        if (userInfoDO != null){
            throw new LocalRuntimeException(CustomError.USERNAME_EXIST);
        }
        Matcher matcher = EMAIL.matcher(email);
        if (!matcher.matches()){
            throw new LocalRuntimeException(CustomError.EMAIL_ILLEGAL);
        }
        if (!(gender >=0 && gender < 2)){
            throw new LocalRuntimeException(CustomError.GENDER_ILLEGAL);
        }
        if (password.length() < 5){
            throw new LocalRuntimeException(CustomError.PASSWORD_ILLEGAL);
        }
        userInfoDO = new UserInfoDO(userId,username,"",BCrypt.hashpw(password,BCrypt.gensalt()),gender,1,email,username);
        userInfoDOMapper.insert(userInfoDO);
        redisService.setToCacheAsync(sessionId,userInfo,180,TimeUnit.DAYS);
        return sessionId;
    }
}
