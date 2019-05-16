package com.example.weixin.io;

import lombok.Data;

@Data
public class HttpResult<T> {

    /**
     * 返回的状态码
     */
    private Integer code;​​​​​​​
    /**
     * 返回的信息
     */
    private String message;
    /**
     * 返回的数据
     */
    private T data;

    public HttpResult() {
        this.code = 200;
        this.message = "SUCCESS";
    }

    public HttpResult(T data) {
        this.code = 200;
        this.message = "SUCCESS";
        this.data = data;
    }

    public HttpResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}