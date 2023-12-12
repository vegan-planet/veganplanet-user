package com.veganplanet.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.veganplanet.user.domain.entity.User;
import com.veganplanet.user.mapper.UserMapper;
import com.veganplanet.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public Integer getUserInfo(Integer userId) {

        return userId;
    }

    @Override
    public User userInsert(User user) {
        if (!this.save(user)) {
            log.atError().log("用户信息插入失败");
        }
        return user;
    }
}
