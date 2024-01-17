package com.veganplanet.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.veganplanet.user.domain.entity.Users;

public interface UserService extends IService<Users> {

    /**
    * <p>根据手机号查询用户信息</p>
    * @date 2024/1/16 21:55
    * @param phone 手机号
    * @return Users 用户信息
    */
    Users getUsersByPhone(String phone);

    /**
    * <p></p>
    * @date 2024/1/17 15:20
    * @param users 用户信息
    * @return Users 用户信息
    */
    Users userInsert(Users users);
}
