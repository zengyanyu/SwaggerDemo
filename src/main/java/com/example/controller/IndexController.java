package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "首页控制器")
public class IndexController {

    @ApiOperation("跳转首页")
    @GetMapping("/toIndex")
    public String toIndex() {
        return "toIndex";
    }

    @ApiOperation("测试路径访问")
    @GetMapping("/get/{id}")
    public String testPathVar(@PathVariable String id) {
        return "hello: " + id;
    }

}
