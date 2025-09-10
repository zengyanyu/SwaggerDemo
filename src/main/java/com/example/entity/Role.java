package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 角色
 *
 * @author zengyanyu
 * @since 2025-09-10
 */
@Getter
@Setter
@Entity
@TableName("role")
@ApiModel(value = "Role对象", description = "角色")
public class Role extends BaseEntity {

    @Id
    private String id;

    @ApiModelProperty("角色编码")
    private String roleCode;

    @ApiModelProperty("角色名称")
    private String roleName;

}
