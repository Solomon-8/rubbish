package com.exercise.exercise.model;

import java.util.Date;

/**
 * @author Solomon
 * @date 2018/4/29
 */
public class ActivityModel {

    private String activityId;

    private String name;

    private Date date;

    private String place;

    private int peopleNum;

    public ActivityModel(String activityId, String name, Date date, String place, int peopleNum) {
        this.activityId = activityId;
        this.name = name;
        this.date = date;
        this.place = place;
        this.peopleNum = peopleNum;
    }

    public ActivityModel() {
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }
}
