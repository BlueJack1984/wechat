package com.example.weixin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    @GetMapping("/get")
    public String get() {
        System.out.println("the get method");
        return "redirect:/student/save";
    }

    @GetMapping("/save")
    @ResponseBody
    public String save() {
        return "the save method";
    }
}
