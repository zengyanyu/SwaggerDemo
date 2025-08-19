package com.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "Person对象", description = "Person对象")
//@JacksonXmlRootElement // 可以写出为xml文档
public class Person {

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("用户名称")
    private String username;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("年龄")
    private Integer age;

}
