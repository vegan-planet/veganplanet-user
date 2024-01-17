package com.veganplanet.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.veganplanet.user.domain.entity.Users;
import com.veganplanet.user.mapper.UserMapper;
import com.veganplanet.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {


    /**
    * <p>根据手机号查询用户信息</p>
    * @date 2024/1/16 21:57
    * @param phone 手机号
    * @return Users 用户信息
    */
    @Override
    public Users getUsersByPhone(String phone) {
        LambdaQueryWrapper<Users> usersLambdaQueryWrapper = new LambdaQueryWrapper<>();
        usersLambdaQueryWrapper.eq(Users::getPhone,phone);
        Users users = this.getOne(usersLambdaQueryWrapper);
        return users;
    }

    @Override
    public Users userInsert(Users user) {
        if (!this.save(user)) {
            log.atError().log("用户信息插入失败");
        }
        return user;
    }
}
