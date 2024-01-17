package com.veganplanet.user.domain.vo.user.login;

import com.veganplanet.user.domain.vo.user.BaseUserVO;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户手机号密码登录
 *
 * @date 2024/1/15 22:54
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordLoginVO extends BaseUserVO {
    private static final long serialVersionUID = 1L;


    /**
     *手机号
     */
    @NotEmpty(message = "手机号不能为空")
    private String phone;

    /**
     *密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;
}
