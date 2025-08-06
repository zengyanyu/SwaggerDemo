package com.example.query;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@ApiModel("部门查询对象")
public class DepartmentQueryObject extends QueryObject {
}
