package com.exercise.exercise.service;

import com.exercise.exercise.dataobject.UserActivityDO;
import com.exercise.exercise.model.ActivityModel;
import com.exercise.exercise.model.UserInfo;

import java.util.List;

/**
 * @author Solomon
 * @date 2018/4/29
 */
public interface ActivityService {

    /**
     * 发布活动
     * @param userInfo 用户信息
     * @param activityModel 发布的活动信息
     * @return 插入结果
     */
    ActivityModel postActivities(UserInfo userInfo,ActivityModel activityModel);

    /**
     * 获得活动列表
     * @param userInfo 用户信息
     * @return 返回活动列表
     */
    List<ActivityModel> getActivities(UserInfo userInfo);

    /**
     * 参加活动
     * @param userInfo 用户信息
     * @param activityId 活动ID
     * @return 是否成功
     */
    boolean joinActivity(UserInfo userInfo,String activityId);

    /**
     * 获取参加活动的人员
     * @param userInfo 用户信息
     * @param activityId 活动Id
     * @return 返回参加活动的人员
     */
    List<UserActivityDO> getJoinPeople(UserInfo userInfo, String activityId);
}
