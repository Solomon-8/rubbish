package com.exercise.exercise.model;

/**
 * @author Solomon
 * @date 2018/4/29
 */
public class RegisterModel {
    private String email;

    private String username;

    private String password;

    private Integer gender;

    public RegisterModel(String email, String username, String password, Integer gender) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public RegisterModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
