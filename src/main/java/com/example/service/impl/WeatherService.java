package com.example.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.appId}")
    String appid;
    @Value("${weather.appSecret}")
    String appsecret;

    private final RestTemplate restTemplate = new RestTemplate();
    // 建议使用单例模式管理 ObjectMapper
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode getWeatherByCity(String city) throws Exception {
        String url = String.format("http://v1.yiketianqi.com/api?unescape=1&version=v91&appid=%s&appsecret=%s&city=%s", appid, appsecret, city);
        // 获取原始 JSON 数据（外层是一个 JSON 对象，但 "data" 字段依然是一个字符串）
        String response = restTemplate.getForObject(url, String.class);
        // 将外层 JSON 字符串转换为 JsonNode
        JsonNode rootNode = objectMapper.readTree(response);

        // 检查 "data" 字段是否为字符串且内容不为空
        if (rootNode.has("data") && rootNode.get("data").isTextual()) {
            String dataString = rootNode.get("data").asText();
            // 再次解析 "data" 字段，使其成为一个 JSON 对象
            JsonNode dataNode = objectMapper.readTree(dataString);
            // 将解析后的 dataNode 设置回 rootNode 中，需要强制转换为 ObjectNode
            if (rootNode instanceof ObjectNode) {
                ((ObjectNode) rootNode).set("data", dataNode);
            }
        }
        // 返回的 JsonNode 经过 Jackson 自动转换为格式化后的 JSON 字符串（前提是你已经在配置中启用了 Pretty Print，
        // 或者调用 writerWithDefaultPrettyPrinter() 进行格式化）
        return rootNode;
    }
}


