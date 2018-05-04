package com.exercise.exercise.service;

import com.exercise.exercise.model.MessageModel;
import com.exercise.exercise.model.UserInfo;

import java.util.List;

/**
 * @author Solomon
 * @date 2018/4/29
 */

public interface MessageService {

    /**
     * 添加留言
     * @param userInfo 用户信息
     * @param messageModel 消息
     * @return 返回添加的留言
     */
    MessageModel postMessage(UserInfo userInfo,MessageModel messageModel);

    /**
     * 返回活动结束后的留言
     * @param userInfo 用户信息
     * @param activityId 活动Id
     * @return 返回消息
     */
    List<MessageModel> getMessageList(UserInfo userInfo,String activityId);
}
