package com.veganplanet.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.veganplanet.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/sysUser")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getUserInfo")
    @SentinelResource(value = "getUserInfo")
    public Integer getUserInfo() {
        return userService.getUserInfo(8888);
    }
}
