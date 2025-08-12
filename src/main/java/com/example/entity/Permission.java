package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 权限
 *
 * @author zengyanyu
 * @since 2025-08-12
 */
@Getter
@Setter
@Entity
@TableName("permission")
@ApiModel(value = "权限", description = "权限")
public class Permission implements Serializable {

    @Id
    @ApiModelProperty("主键ID")
    private Long id;

    @Comment("api操作名称")
    @ApiModelProperty("api操作名称")
    private String apiOperationName;

    @Comment("方法名称")
    @ApiModelProperty("方法名称")
    private String methodName;

    @Comment("路径")
    @ApiModelProperty("路径")
    private String path;

    @Comment("请求方法")
    @ApiModelProperty("请求方法")
    private String requestMethod;

}
