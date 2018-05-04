package com.exercise.exercise.model;

import java.util.Date;

/**
 * @author Solomon
 * @date 2018/4/29
 */
public class MessageModel {

    private String content;

    private Date time;

    private String activityId;

    private String messageId;

    public MessageModel(String content, Date time, String activityId, String messageId) {
        this.content = content;
        this.time = time;
        this.activityId = activityId;
        this.messageId = messageId;
    }

    public MessageModel() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
