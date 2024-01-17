package com.veganplanet.user.service.application;

import com.alibaba.fastjson.JSON;
import com.veganplanet.common.core.exception.VeganplanetException;
import com.veganplanet.common.core.response.Res;
import com.veganplanet.common.core.response.ServiceStatus;
import com.veganplanet.user.domain.entity.Users;
import com.veganplanet.user.domain.vo.user.login.UserPasswordLoginVO;
import com.veganplanet.user.domain.vo.user.login.UserSmsCodeLoginVO;
import com.veganplanet.user.domain.vo.user.login.UserWechatLoginBidingVO;
import com.veganplanet.user.domain.vo.user.login.UserWechatLoginVO;
import com.veganplanet.user.enums.UserExceptionStatusEnum;
import com.veganplanet.user.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>素食星球用户登录</p>
 *
 * @date 2024/1/15 22:42
 */
@Slf4j
@Service
public class UserLoginService {

    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Resource
    private UserService userService; ;

    /**
    * <p>手机号密码登录</p>
    * @date 2024/1/15 22:45
    * @param
    * @return
    */
    public Res passwordLogin(UserPasswordLoginVO userPasswordLoginVO) {
        Users users = this.userService.getUsersByPhone(userPasswordLoginVO.getPhone());
        if (Objects.isNull(users)) {
            return Res.get(ServiceStatus.GET.NOT_FOUND, "未找到该用户");
        }
        final String password = DigestUtils.md5Hex(userPasswordLoginVO.getPassword());
        if (Objects.isNull(users.getPassword()) || !users.getPassword().equals(password)) {
            return Res.get(ServiceStatus.GET.NOT_FOUND, "您输入的手机号或密码不正确");
        } else {
            //生成token
            String token = this.saveToken(users);
            return Res.ok(token);
        }
    }

    /**
    * <p>短信验证码登录</p>
    * @date 2024/1/15 23:00
    * @param
    * @return
    */
    public Res smsLogin(UserSmsCodeLoginVO userSmsCodeLoginVO) {
        //验证用户输入手机号和验证码是否匹配
        this.checkSmsCode(userSmsCodeLoginVO.getPhone(),
                userSmsCodeLoginVO.getSmsCode(), "LOGIN_SMS");
        //查询用户信息
        Users users = this.userService.getUsersByPhone(userSmsCodeLoginVO.getPhone());
        if (Objects.isNull(users)) {
           //注册新用户
            users= this.saveUser(Users.builder().phone(userSmsCodeLoginVO.getPhone()).build());
        }
        //生成token
        String token = this.saveToken(users);
        return Res.ok(token);
    }

    /**
    * <p>微信登录</p>
    * @date 2024/1/15 23:09
    * @param
    * @return
    */
    public Res wechatLogin(UserWechatLoginVO userWechatLoginVO) {
        return null;
    }

    /**
    * <p>微信登录绑定手机号</p>
    * @date 2024/1/15 23:11
    * @param
    * @return
    */
    public Res wechatLoginBindPhone(UserWechatLoginBidingVO userWechatLoginBidingVO) {
        return null;
    }
    /**
     * <p>验证用户输入手机号和验证码是否匹配</p>
     * @author wxh_work@163.com
     * @date 2022/11/7 10:04
     * @param
     * @return
     */
    private void checkSmsCode (String mobile, String code, String smsType) {
        final String loginSmsRedisKey = smsType+"_"+mobile;
        final Boolean hasKey = this.redisTemplate.hasKey(loginSmsRedisKey);
        if (Boolean.TRUE.equals(hasKey)) {
            final String redisSmsCode = this.redisTemplate.boundValueOps(loginSmsRedisKey).get();
            //如果手机号和验证码匹配，清空当前手机号下发送的验证码
            if (code.equals(redisSmsCode)) {
                this.redisTemplate.delete(loginSmsRedisKey);
            } else {
                throw new VeganplanetException(UserExceptionStatusEnum.CHECK_CODE_ERROR);
            }
        } else {
            throw new VeganplanetException(UserExceptionStatusEnum.CHECK_CODE_ERROR);
        }
    }

    /**
    * <p>生成用户 token 并把用户信息保存在 Redis</p>
    * @date 2024/1/16 23:13
    * @param users 用户信息
    * @return token令牌
    */
    private String saveToken(Users users) {
        //生成token
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        //把用户信息放到redis里面
        redisTemplate.opsForValue().set("user:veganplanet:" + token,
                JSON.toJSONString(users),
                30, TimeUnit.DAYS);
        return token;
    }

    /**
    * <p>新增用户</p>
    * @date 2024/1/17 15:22
    * @param
    * @return
    */
    private Users saveUser(Users users) {
        users.setDelFlag(0);
        users.setLockFlag(0);
        users =this.userService.userInsert(users);
        return users;
    }

}
