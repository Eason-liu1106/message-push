package com.login.web;

import com.login.model.dto.*;
import common.argument.result.ResultEnity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JialinLiu
 * @date 2019/5/27 0027 13:48
 */
@RestController("api/login")
@Validated
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping
    public ResultEnity login(@RequestBody @Validated UserDto userDto) {

        return new ResultEnity();
    }

}
