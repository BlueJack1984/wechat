package com.example.weixin.controller;

import com.example.weixin.entity.Item;
import com.example.weixin.entity.Order;
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
}
