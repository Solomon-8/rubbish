package com.exercise.exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Solomon
 * @date 2018/4/29
 */
@RestController
public class CheckController {


    @GetMapping("/check")
    public String check(){
        return "Success";
    }

    @GetMapping("/exception")
    public void exception() throws Exception {
        throw new Exception("text");
    }

}
