package com.example.weixin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.weixin.entity.Item;
import com.example.weixin.entity.Order;
import com.example.weixin.utils.HttpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {


    @GetMapping("/get/{name}")
    public String get(@PathVariable("name") String name) {
        return "hello order " + name;
    }

    @GetMapping("/save/{name}")
    public Order save(@PathVariable("name") String name) {
        Item item = new Item(1L, "book", 25.5, "java");
        Order order = new Order(10000L, name, item);
        return order;
    }

    @GetMapping("/http")
    public String check() {
        return HttpUtil.get("https://www.baidu.com");
    }
    @PostMapping("/post")
    public String httpcheck() {
        String orderStr = "{\"id\":1,\"name\":\"lz\"}";
        JSONObject orderJson = JSONObject.parseObject(orderStr);
        Order order = JSON.toJavaObject(orderJson, Order.class);
        System.out.println(order.getItem());
        return JSONObject.toJSONString(order);
    }
}
