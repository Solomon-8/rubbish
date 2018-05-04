package com.exercise.exercise.service;

import com.exercise.exercise.dataobject.ActivityDO;
import com.exercise.exercise.dataobject.UserActivityDO;
import com.exercise.exercise.exception.CustomError;
import com.exercise.exercise.exception.LocalRuntimeException;
import com.exercise.exercise.mapper.ActivityDOMapper;
import com.exercise.exercise.mapper.UserActivityDOMapper;
import com.exercise.exercise.model.ActivityModel;
import com.exercise.exercise.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Solomon
 * @date 2018/4/29
 */
@Component
public class ActivityServiceImpl implements ActivityService {



    @Autowired
    private ActivityDOMapper activityDOMapper;
    @Autowired
    private UserActivityDOMapper userActivityDOMapper;
    private static final String LOCK = "LOCK";

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ActivityModel postActivities(UserInfo userInfo, ActivityModel activityModel) {
        String activityId = activityModel.getActivityId();
        Date date = activityModel.getDate();
        String name = activityModel.getName();
        int peopleNum = activityModel.getPeopleNum();
        String place = activityModel.getPlace();
        ActivityDO activityDO = new ActivityDO(name,date,place,peopleNum,userInfo.getUserId(),activityId);
        activityDOMapper.insert(activityDO);
        return activityModel;
    }

    @Override
    public List<ActivityModel> getActivities(UserInfo userInfo) {
        List<ActivityDO> activityDOS = activityDOMapper.getActivities();
        List<ActivityModel> activityModels = new ArrayList<>();
        for (ActivityDO i : activityDOS){
            activityModels.add(new ActivityModel(i.getActivityId(),i.getName(),i.getDate(),i.getPlace(),i.getPeoplenum()));
        }
        return activityModels;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean joinActivity(UserInfo userInfo, String activityId) {
        synchronized (LOCK){
            int allowPeople = activityDOMapper.getPeopleNum(activityId);
            int currentPeople = userActivityDOMapper.getJoinNum(activityId);
            boolean flag = checkIsJoin(userInfo.getUserId(),activityId);
            if (currentPeople < allowPeople && !flag){
                UserActivityDO userActivityDO = new UserActivityDO(activityId,userInfo.getUserId(),userInfo.getNick());
                userActivityDOMapper.insert(userActivityDO);
                return true;
            }else if (currentPeople < allowPeople){
                throw new LocalRuntimeException(CustomError.JOIN_ALREADY);
            }else {
                throw new LocalRuntimeException(CustomError.PEOPLE_ILLEGAL);
            }
        }
    }

    @Override
    public List<UserActivityDO> getJoinPeople(UserInfo userInfo, String activityId) {
        return userActivityDOMapper.getJoinPeople(activityId);
    }


    private boolean checkIsJoin(String userId,String activityId){
        return userActivityDOMapper.getUserInfoByActivity(userId, activityId) != null;
    }
}
