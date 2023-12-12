package com.veganplanet.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.veganplanet.user.domain.entity.User;

public interface UserService extends IService<User> {

    Integer getUserInfo(Integer userId);

    User userInsert(User user);
}
