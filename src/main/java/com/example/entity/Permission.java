package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 权限
 *
 * @author zengyanyu
 * @since 2025-09-10
 */
@Getter
@Setter
@Entity
@TableName("permission")
@ApiModel(value = "Permission对象", description = "权限")
public class Permission extends BaseEntity {

    @Id
    private Long id;

    @ApiModelProperty("api操作名称")
    private String apiOperationName;

    @ApiModelProperty("方法名称")
    private String methodName;

    @ApiModelProperty("路径")
    private String path;

    @ApiModelProperty("请求方法")
    private String requestMethod;

}
