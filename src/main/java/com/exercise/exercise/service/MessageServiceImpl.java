package com.exercise.exercise.service;

import com.exercise.exercise.dataobject.MessageDO;
import com.exercise.exercise.mapper.MessageDOMapper;
import com.exercise.exercise.model.MessageModel;
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
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageDOMapper messageDOMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MessageModel postMessage(UserInfo userInfo, MessageModel messageModel) {
        String activityId = messageModel.getActivityId();
        String content = messageModel.getContent();
        String messageId = messageModel.getMessageId();
        MessageDO messageDO = new MessageDO(new Date(),activityId,messageId,userInfo.getUserId(),content);
        messageDOMapper.insert(messageDO);
        return messageModel;
    }

    @Override
    public List<MessageModel> getMessageList(UserInfo userInfo, String activityId) {
        List<MessageDO> messageDOS = messageDOMapper.selectByActivityId(activityId);
        List<MessageModel> messageModels = new ArrayList<>();
        for (MessageDO i : messageDOS){
            messageModels.add(new MessageModel(i.getContent(),i.getTime(),i.getActivityId(),i.getMessageId()));
        }
        return messageModels;
    }
}
