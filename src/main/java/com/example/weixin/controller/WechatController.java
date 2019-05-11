package com.example.weixin.controller;

import com.example.weixin.config.WechatAccountConfig;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private WechatAccountConfig wechatAccountConfig;
    /**
     * 微信将请求这个地址来验证接口信息（就是上图中的地址）
     * 这个方法的五个参数作用分别是：
     * response 将echostr原样写回微信告诉它通过验证；
     * 微信端验证时传过来的参数—时间戳；
     * 微信端验证时传过来的参数—随机数；
     * 微信端验证时传过来的参数—签名；
     * 这里checkSignature（）方法会具体去检验是否合法。
     * 通过后返回echostr;验证通过。(我们的token呢？？？？ 别急 后面会出现的)
     *
     * 这个sdk的使用在mp模块主要有两个类（不清楚的可以上github看文档）
     * WxMpService；WxMpConfigStorage；
     * 下面是在springboot里的配置
     * @param response
     * @param timestamp
     * @param nonce
     * @param signature
     * @param echostr
     * 代码setToken实际上是去做了我们第一步的checkSignature（）；
     */
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public void check(ServletResponse response, String timestamp, String nonce, String signature, String echostr) throws Exception {
        if (! wxMpService.checkSignature(timestamp, nonce, signature)) {
            log.error("不合法");
            //throw new SellException(ResultEnum.WECHAT_ERROR);
            throw new Exception("微信公众号验证不合法");
        }
        PrintWriter o = null;
        try {
            o = new PrintWriter(response.getWriter());
            o.print(echostr);
        } catch (IOException e) {
            log.error("写回微信端错误{}", e.getMessage());
        } finally {
            o.close();
        }
    }

    /**
     * 当我们通过验证后
     * 就编写对应的controller就好了
     * 看看我们的代码
     * @param returnUrl
     * @return
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {

        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(wechatAccountConfig.getReturnUrl(), WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        log.info("获得code redirectUrl{}", redirectUrl);

        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code, @RequestParam("state") String returnUrl) throws Exception {
        log.info("redirect code{}  state{}", code, returnUrl);
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("wechat  error{}", e.getError().getErrorMsg());
            throw new Exception(e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        log.info("openid{}", openId);
        log.info("enter");
        log.info("return url{}", returnUrl);
        return "redirect:" + "https://www.imooc.com/" + "?openid=" + openId;
    }
}