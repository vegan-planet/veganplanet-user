package com.veganplanet.user.controller;

import com.veganplanet.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/sysUser")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getUserInfo")
    public Integer getUserInfo() {
        return userService.getUserInfo(8888);
    }
}
