package com.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@ApiModel(value = "用户信息Dto对象", description = "用户信息Dto对象描述")
public class UserInfoDto implements Serializable {

    @ApiModelProperty("用户名称")
    private String username;

    @ApiModelProperty("密码")
    private String password;
}
