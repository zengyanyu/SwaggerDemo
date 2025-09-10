package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * 菜单
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Getter
@Setter
@Entity
@TableName("menu")
@ApiModel(value = "菜单", description = "菜单")
public class Menu extends BaseEntity {

    @TableId(type = IdType.ASSIGN_ID)// 默认雪花算法（分布式ID）
    @Id
    @ApiModelProperty("主键ID")
    private Long id;

    @Comment("菜单名称")
    @ApiModelProperty("菜单名称")
    private String name;

    @Comment("菜单路径")
    @ApiModelProperty("菜单路径")
    private String path;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

}
