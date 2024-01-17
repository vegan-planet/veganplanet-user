package com.veganplanet.user.enums;

import com.veganplanet.common.core.response.ServiceStatus;
import lombok.Getter;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2023/2/2 18:18
 */
@Getter
public enum UserExceptionStatusEnum implements ServiceStatus {
    /**
     * 系统服务异常，请稍后重试
     */
    USER_SERVICE_ERROR(0, 100000, "服务异常，请稍后重试"),
    /**
     * 修改手机号超时,请从新获取旧手机号验证码
     */
    CHECK_CODE_OVERTIME_ERROR(0, 10000, "修改手机号超时,请从新获取旧手机号验证码"),
    /**
     * 请输入正确的验证码
     */
    CHECK_CODE_ERROR(0, 10000, "请输入正确的验证码");
    /**
     * 服务状态
     */
    private final int status;
    /**
     * 状态码
     */
    private final int code;
    /**
     * 信息
     */
    private final String message;

    UserExceptionStatusEnum(int status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
