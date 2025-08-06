package com.example.controller;

import com.example.dto.UserInfoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("创建用户")
    @PostMapping("/api/createUserInfo")
    public ResponseEntity<UserInfoDto> createUserInfoDto(@RequestBody UserInfoDto model) {
        // 方法逻辑
        return null;
    }
}
