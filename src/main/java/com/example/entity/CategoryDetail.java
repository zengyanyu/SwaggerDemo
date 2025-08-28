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
 * 产品品类明细
 */
@Getter
@Setter
@Entity
@TableName("category_detail")
@ApiModel(value = "产品品类明细", description = "产品品类明细")
public class CategoryDetail implements Serializable {

    @Id
    @ApiModelProperty("主键ID")
    private String id;

    @ApiModelProperty("分类key")
    private String categoryKey;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("父ID")
    private String parentId;

    @ApiModelProperty("分类排序")
    private Long listOrder;

    @ApiModelProperty("分类图标")
    private String iconUrl;

    @ApiModelProperty("物模型")
    private String modelTemplate;

}
