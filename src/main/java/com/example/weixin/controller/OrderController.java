package com.example.weixin.controller;

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

    @PostMapping("/save/{name}")
    public String save(@PathVariable("name") String name) {
        return "the post order " + name;
    }
}
