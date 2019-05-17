package com.example.weixin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/free/audition")
@RequiredArgsConstructor
@Slf4j
public class FreeAuditionController {

    @GetMapping("/main")
    public String getMainPage() {
        return "freeAudition.html";
    }
 }
