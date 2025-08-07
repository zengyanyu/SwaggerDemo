package com.example.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "web包-首页控制器")
@RequestMapping("/web")
public class WebController {

    @ApiOperation("返回toIndex")
    @GetMapping("/toIndex")
    public String toIndex() {
        return "hello toIndex";
    }
}
