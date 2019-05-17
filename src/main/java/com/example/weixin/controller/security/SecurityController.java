package com.example.weixin.controller.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.weixin.entity.User;
import com.example.weixin.io.request.LoginInput;
import com.example.weixin.utils.HttpClientUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/security")
@RequiredArgsConstructor
@Slf4j
public class SecurityController {

    /**
     * 注入http调用工具
     */
    private final HttpClientUtil httpClientUtils;
    /**
     * 设置后台登录url
     */
    private static final String LOGIN_URL = "http://localhost:80/order/login";

    @GetMapping("/page")
    public String getLoginPage() {
        return "/less/index.html";
    }

    /**
     * 用户登录
     * @param loginInput
     * @return
     */
    @PostMapping("/login")
    @CrossOrigin
    public String login(@RequestBody @Valid LoginInput loginInput, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();
        map.put("account", loginInput.getAccount());
        map.put("password", loginInput.getPassword());
        HttpClientUtil.HttpResponse httpResponse = null;
        try {
            httpResponse = httpClientUtils.doPost(LOGIN_URL, map);
        } catch (Exception e) {
            request.setAttribute("message", "后台登录服务无法使用");
            return "/login.html";
        }
        String result = null;
        if (200 == httpResponse.getCode()) {
            result = httpResponse.getBody();
            if (null != result) {
                JSONObject userJson = JSONObject.parseObject(result);
                User user = JSON.toJavaObject(userJson, User.class);
                if(null == user) {
                    request.setAttribute("message", "账户或者密码错误");
                    return "/login.html";
                }
                //登录成功
                request.getSession().setAttribute("USER_IN_SESSION", user);
                return "redirect:" + loginInput.getDestinationUrl();
            }
        }
        request.setAttribute("message", "后台登录服务请求状态值code不正确");
        return "/login.html";
    }

    /**
     *用户注销
     *用户注销功能的主要作用是保护用户的账户安全,在用户点击安全退出的时候,我们需要将本次会话相关的session信息删除
     *删除的方式有下面两种:
     *1.删除当前登录的用户信息
     *存在问题:本次会话的其他信息还是保存在内存中,没有及时清理
     */
//    @PostMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        request.getSession().removeAttribute("USER_IN_SESSION");
//        return "redirect:/login.html";
//    }

    /**
     * 销毁整个session(推荐)
     */
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return "redirect:/login.html";
    }
}





