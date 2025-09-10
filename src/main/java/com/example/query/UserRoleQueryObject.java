package com.example.query;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@ApiModel("用户角色查询对象")
public class UserRoleQueryObject extends QueryObject {
}
