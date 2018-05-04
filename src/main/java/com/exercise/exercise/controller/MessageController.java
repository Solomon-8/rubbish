package com.exercise.exercise.controller;

import com.exercise.exercise.model.MessageModel;
import com.exercise.exercise.model.UserInfo;
import com.exercise.exercise.service.MessageService;
import com.exercise.exercise.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Solomon
 * @date 2018/4/29
 */
@RestController
public class MessageController {

    private MessageService messageService;

    private RedisService redisService;

    @Autowired
    public MessageController(MessageService messageService, RedisService redisService) {
        this.messageService = messageService;
        this.redisService = redisService;
    }

    @GetMapping("/messageList")
    public List<MessageModel> getMessageList(UserInfo userInfo,@RequestParam("activityId")String activityId){
        return messageService.getMessageList(userInfo,activityId);
    }


    @PostMapping("/addMessage")
    public MessageModel addMessage(UserInfo userInfo, @RequestBody MessageModel messageModel){
        return messageService.postMessage(userInfo,messageModel);
    }


}
