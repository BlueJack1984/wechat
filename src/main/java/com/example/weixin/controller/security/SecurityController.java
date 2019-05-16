package com.example.weixin.controller.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/security")
@RequiredArgsConstructor
@Slf4j
public class SecurityController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "/less/index.html";
    }
}
