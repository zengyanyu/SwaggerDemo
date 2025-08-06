package com.example.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 部门管理
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Getter
@Setter
@Entity
@TableName("department")
@ApiModel(value = "Department对象", description = "部门管理")
public class Department implements Serializable {

    @Id
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("部门名称")
    private String deptName;

}
