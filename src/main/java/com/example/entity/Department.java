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
 * 部门管理
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Getter
@Setter
@Entity
@TableName("department")
@ApiModel(value = "部门", description = "部门")
public class Department implements Serializable {

    @Id
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("部门名称")
    private String deptName;

}
