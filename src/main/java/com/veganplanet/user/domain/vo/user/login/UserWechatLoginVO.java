package com.veganplanet.user.domain.vo.user.login;

import com.veganplanet.user.domain.vo.user.BaseUserVO;
import jakarta.validation.constraints.NotEmpty;

/**
 * 用户微信登录
 *
 * @date 2024/1/15 23:03
 */
public class UserWechatLoginVO extends BaseUserVO {
    private static final long serialVersionUID = 1L;

    /**
     *微信code
     */
    @NotEmpty(message = "微信code不能为空")
    private String wxCode;
}
