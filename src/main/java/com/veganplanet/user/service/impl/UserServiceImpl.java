package com.veganplanet.user.service.impl;

import com.veganplanet.user.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Override
    public Integer getUserInfo(Integer userId) {
        System.out.println("userId");
        return userId;
    }
}
