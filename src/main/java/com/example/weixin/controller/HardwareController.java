package com.example.weixin.controller;

import com.example.weixin.entity.Hardware;
import com.example.weixin.io.response.OutputResult;
import com.example.weixin.service.base.IHardwareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hardware")
@RequiredArgsConstructor
@Slf4j
public class HardwareController {

    private final IHardwareService hardwareService;

    /**
     *
     */
    //@GetMapping("/get")
    //@CrossOrigin
    //public OutputResult<Hardware> getByUserId(Long )
}
