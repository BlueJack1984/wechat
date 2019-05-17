package com.example.weixin.io.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class OutputResult<T> implements Serializable {
    /**
     * 返回的状态码
     */
    private Integer code;
    /**
     * 返回的信息
     */
    private String message;
    /**
     * 返回的数据
     */
    private T data;

    /**
     * 请求成功，无数据返回
     */
    public OutputResult() {
        this.code = 200;
        this.message = "SUCCESS";
    }
    /**
     * 请求成功，有数据返回
     */
    public OutputResult(T data) {
        this.code = 200;
        this.message = "SUCCESS";
        this.data = data;
    }
    /**
     * 请求失败，返回失败信息
     */
    public OutputResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}