package com.exercise.exercise.controller;

import com.exercise.exercise.dataobject.UserActivityDO;
import com.exercise.exercise.model.ActivityModel;
import com.exercise.exercise.model.UserInfo;
import com.exercise.exercise.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Solomon
 * @date 2018/4/29
 */
@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/getActivitiesList")
    public List<ActivityModel> getActivities(UserInfo userInfo){
        return activityService.getActivities(userInfo);
    }

    @PostMapping("/postActivity")
    public ActivityModel addActivity(UserInfo userInfo, @RequestBody ActivityModel activityModel){
        return activityService.postActivities(userInfo,activityModel);
    }

    @GetMapping("/joinActivity")
    public boolean joinActivity(UserInfo userInfo,@RequestParam String activityId){
        return activityService.joinActivity(userInfo,activityId);
    }

    @GetMapping("/getJoinPeople")
    public List<UserActivityDO> getJoinPeople(UserInfo userInfo, @RequestParam String activityId){
        return activityService.getJoinPeople(userInfo,activityId);
    }


}
