package com.veganplanet.user.domain.vo.user.login;

import com.veganplanet.user.domain.vo.user.BaseUserVO;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>用户微信登录绑定手机号</p>
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserWechatLoginBidingVO extends BaseUserVO {
    private static final long serialVersionUID = 1L;

    /**
     *微信unionId
     */
    @NotEmpty(message = "微信unionId不能为空")
    private String unionId;
    /**
     *手机号
     */
    @NotEmpty(message = "手机号不能为空")
    private String phone;

    /**
     *短信验证吗
     */
    @NotEmpty(message = "短信验证码不能为空")
    private String smsCode;
}
