package com.veganplanet.user.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
/**
 * <p>素食星球用户</p>
 *
 * @date 2024/1/15 17:42
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *编号
     */
    @TableId(value = "user_no", type = IdType.ASSIGN_ID)
    private Long userNO;
    /**
     *用户名
     */
    private String userName;
    /**
     *密码
     */
    private String password;
    /**
     *手机号
     */
    private String phone;
    /**
     *头像
     */
    private String avatar;
    /**
     *昵称
     */
    private String nickName;
    /**
     *锁定标记，0未锁定，1已锁定
     */
    private Integer lockFlag;
    /**
     *删除标记，0未删除，1已删除
     */
    private Integer delFlag;
    /**
     *微信openid
     */
    private String wxOpenid;
    /**
     *小程序openid
     */
    private String miniOpenid;
    /**
     *创建时间
     */
    private String createTime;
    /**
     *更新时间
     */
    private String updateTime;

}
