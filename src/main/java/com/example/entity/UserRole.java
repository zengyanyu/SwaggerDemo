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
 * 用户关联的角色
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Getter
@Setter
@Entity
@TableName("user_role")
@ApiModel(value = "用户关联的角色", description = "用户关联的角色")
public class UserRole implements Serializable {

    @Id
    private String id;

    @ApiModelProperty("用户ID")
    private String userId;

    private String roleCode;

    private String roleName;

}
