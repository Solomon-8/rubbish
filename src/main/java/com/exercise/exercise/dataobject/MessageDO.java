package com.exercise.exercise.dataobject;

import java.util.Date;

public class MessageDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.time
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    private Date time;

    public MessageDO() {
    }

    public MessageDO(Date time, String activityId, String messageId, String userId, String content) {

        this.time = time;
        this.activityId = activityId;
        this.messageId = messageId;
        this.userId = userId;
        this.content = content;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.activity_id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */

    private String activityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.message_id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    private String messageId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.user_id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.content
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.id
     *
     * @return the value of message.id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.id
     *
     * @param id the value for message.id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.time
     *
     * @return the value of message.time
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.time
     *
     * @param time the value for message.time
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.activity_id
     *
     * @return the value of message.activity_id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.activity_id
     *
     * @param activityId the value for message.activity_id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.message_id
     *
     * @return the value of message.message_id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.message_id
     *
     * @param messageId the value for message.message_id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.user_id
     *
     * @return the value of message.user_id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.user_id
     *
     * @param userId the value for message.user_id
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.content
     *
     * @return the value of message.content
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.content
     *
     * @param content the value for message.content
     *
     * @mbg.generated Sun Apr 29 19:53:04 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}