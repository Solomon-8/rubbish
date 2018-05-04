package com.exercise.exercise.service;

import com.exercise.exercise.model.LoginModel;
import com.exercise.exercise.model.RegisterModel;

/**
 * @author Solomon
 * @date 2018/4/29
 */
public interface LoginService {


    /**
     * 登录
     * @param loginModel 登录信息
     * @return 返回登录结果
     */
    String login(LoginModel loginModel);


    /**
     * 注册
     * @param registerModel 注册信息
     * @return 返回注册结果
     */
    String register(RegisterModel registerModel);

}
