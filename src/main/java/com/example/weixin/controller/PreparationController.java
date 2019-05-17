package com.example.weixin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/preparation")
@RequiredArgsConstructor
@Slf4j
public class PreparationController {

    @CrossOrigin
    @GetMapping("/main")
    public String getMainPage() {
        return "preparation.html";
    }
}
