package com.exercise.exercise.controller;

import com.exercise.exercise.model.LoginModel;
import com.exercise.exercise.model.RegisterModel;
import com.exercise.exercise.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Solomon
 * @date 2018/4/29
 */
@RestController
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginModel loginModel){
        return loginService.login(loginModel);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterModel registerModel){
        return loginService.register(registerModel);
    }
}
