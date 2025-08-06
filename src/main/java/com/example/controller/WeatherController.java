package com.example.controller;

import com.example.commons.ResponseData;
import com.example.service.impl.WeatherService;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "天气预报控制器对象")
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /**
     * 根据城市获取天气
     *
     * @param city
     * @return
     */
    // 文档：
    // https://blog.csdn.net/2301_80165178/article/details/147192936
    @ApiOperation("根据城市获取天气")
    @GetMapping("/getWeather")
    public ResponseData<JsonNode> getWeather(@RequestParam String city) throws Exception {
        return new ResponseData<>("根据城市获取天气成功", weatherService.getWeatherByCity(city));
    }
    /**
     * 账号：1194314874@qq.com
     * 密码：zeng123456
     * 地址：http://www.tianqiapi.com/user/index
     */
}
