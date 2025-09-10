package com.example.query;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@ApiModel("权限查询对象")
public class PermissionQueryObject extends QueryObject{
}
