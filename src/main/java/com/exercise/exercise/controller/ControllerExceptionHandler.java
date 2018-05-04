package com.exercise.exercise.controller;

import com.exercise.exercise.ExerciseApplication;
import com.exercise.exercise.exception.LocalRuntimeException;
import com.exercise.exercise.model.UserInfo;
import com.exercise.exercise.util.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Solomon
 * @date 2018/4/29
 */

@ControllerAdvice
@Controller
public class ControllerExceptionHandler implements ErrorController {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @ResponseStatus(code = HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @RequestMapping("/error")
    @ResponseBody
    public HttpResponse<Void> handleException(Exception uncaughtException) {
        UserInfo currentUserInfo = ExerciseApplication.UserInfoValidationConfigurer.userInfoHolder.get();
        logger.warn("Uncaught exception by User {}: ", currentUserInfo, uncaughtException);
        if (uncaughtException == null) {
            return HttpResponse.failure("No exception found.", null);
        }
        if (uncaughtException instanceof LocalRuntimeException) {
            // 自定义异常
            LocalRuntimeException localException = (LocalRuntimeException) uncaughtException;
            return HttpResponse.failure(localException.getMessage(), localException.getError().getCode());
        } else {
            return HttpResponse.failure(uncaughtException.getMessage(), null);
        }
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
