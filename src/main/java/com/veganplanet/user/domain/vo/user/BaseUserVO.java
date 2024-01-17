package com.veganplanet.user.domain.vo.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 素食星球用户登录基础公共信息
 *
 * @date 2024/1/15 22:50
 */
@Data
public class BaseUserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *idfv
     */
    private String idfv;
    /**
     *app来源类型  APP客户端 app  小程序  mini
     */
    private String fromAppType;
}
