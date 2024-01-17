package com.veganplanet.user.controller;

import com.veganplanet.common.core.response.Res;
import com.veganplanet.user.domain.vo.user.login.UserPasswordLoginVO;
import com.veganplanet.user.domain.vo.user.login.UserSmsCodeLoginVO;
import com.veganplanet.user.domain.vo.user.login.UserWechatLoginBidingVO;
import com.veganplanet.user.domain.vo.user.login.UserWechatLoginVO;
import com.veganplanet.user.service.application.UserLoginService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 素食星球用户登录
 *
 * @date 2024/1/15 22:41
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserLoginController {

    @Resource
    private UserLoginService userLoginService;

    /**
     * <p>手机号密码登录</p>
     * @date 2024/1/15 22:45
     * @param
     * @return
     */
    @PostMapping(value = "/passwordLogin")
    public Res passwordLogin(@Valid @RequestBody UserPasswordLoginVO userPasswordLoginVO) {
        return userLoginService.passwordLogin(userPasswordLoginVO);
    }

    /**
    * <p>短信验证码登录</p>
    * @date 2024/1/15 23:06
    * @param
    * @return
    */
    @PostMapping(value = "/smsLogin")
    public Res smsLogin(@Valid @RequestBody UserSmsCodeLoginVO userSmsCodeLoginVO) {
        return userLoginService.smsLogin(userSmsCodeLoginVO);
    }

    /**
    * <p>微信登录</p>
    * @date 2024/1/15 23:08
    * @param
    * @return
    */
    @PostMapping(value = "/wechatLogin")
    public Res wechatLogin(@Valid @RequestBody UserWechatLoginVO userWechatLoginVO) {
        return userLoginService.wechatLogin(userWechatLoginVO);
    }

    /**
    * <p>微信登录绑定手机号</p>
    * @date 2024/1/15 23:10
    * @param
    * @return
    */
    @PostMapping(value = "/wechatLoginBindPhone")
    public Res wechatLoginBindPhone(@Valid @RequestBody UserWechatLoginBidingVO userWechatLoginBidingVO) {
        return userLoginService.wechatLoginBindPhone(userWechatLoginBidingVO);
    }
}
