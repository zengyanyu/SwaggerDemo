package com.example.controller;

import com.example.commons.ResponseData;
import com.example.entity.CategoryDetail;
import com.example.util.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@Api(tags = "解析JSON控制器")
public class JsonParseController {

    @javax.annotation.Resource
    private ResourceLoader resourceLoader;

    @ApiOperation("解析JSON")
    @GetMapping("/jsonParse")
    public ResponseData jsonParse() throws IOException {
        // 创建Resource对象
        Resource resource = resourceLoader.getResource("classpath:jsonFile.json");
        // 读取资源内容到字符串
        byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        String jsonContent = new String(bytes, StandardCharsets.UTF_8);

        // 解析JSON对象
        JSONObject jsonObject = new JSONObject(jsonContent);
        // 获取键值对
        JSONArray data = jsonObject.getJSONArray("Data");
        // 使用数组的方式转JSON对象数组
        CategoryDetail[] categoryDetails = JsonUtils.fromJsonArr(data.toString(), CategoryDetail[].class);
        for (CategoryDetail detail : categoryDetails) {
            // 保存
            // categoryDetailService.save(detail);
        }
        return new ResponseData("解析JSON成功", categoryDetails);
    }
}
