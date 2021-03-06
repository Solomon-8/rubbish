package com.exercise.exercise.dataobject;

public class UserActivityDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_activity.id
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_activity.activity_id
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    private String activityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_activity.user_id
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_activity.username
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    private String username;


    public UserActivityDO(String activityId, String userId, String username) {
        this.activityId = activityId;
        this.userId = userId;
        this.username = username;
    }

    public UserActivityDO() {
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_activity.id
     *
     * @return the value of user_activity.id
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_activity.id
     *
     * @param id the value for user_activity.id
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_activity.activity_id
     *
     * @return the value of user_activity.activity_id
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_activity.activity_id
     *
     * @param activityId the value for user_activity.activity_id
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_activity.user_id
     *
     * @return the value of user_activity.user_id
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_activity.user_id
     *
     * @param userId the value for user_activity.user_id
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_activity.username
     *
     * @return the value of user_activity.username
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_activity.username
     *
     * @param username the value for user_activity.username
     *
     * @mbg.generated Sat May 05 04:38:08 CST 2018
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}