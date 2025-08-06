package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户信息
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Getter
@Setter
@Entity
@TableName("user_info")
@ApiModel(value = "用户信息", description = "用户信息")
public class UserInfo implements Serializable {

    @Id
    private String id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("状态（0：正常，1：锁定，2：预删）")
    private String status;

    @ApiModelProperty("状态名称（0：正常，1：锁定，2：预删）")
    private String statusName;

    @ApiModelProperty("企业ID")
    private String compId;

    private String isRegister;

}
