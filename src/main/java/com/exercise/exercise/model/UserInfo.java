package com.exercise.exercise.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author Solomon
 * @date 2018/4/29
 */
public class UserInfo {


    private String userId;

    private String nick;

    private String email;

    private String avatar;

    private String password;

    private Integer gender;

    private boolean enable = false;


    public UserInfo(String userId, String nick, String email, String avatar, String password, Integer gender) {
        this.userId = userId;
        this.nick = nick;
        this.email = email;
        this.avatar = avatar;
        this.password = password;
        this.gender = gender;
    }

    public UserInfo(boolean enable) {
        this.enable = enable;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}

