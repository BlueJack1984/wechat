package com.example.weixin.io.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInput {

    /**
     * 用户输入账号
     */
    @NotBlank(message = "用户账号不能为空")
    @Length(min = 1, max = 20)
    private String account;
    /**
     * 用户输入密码
     */
    @NotBlank(message = "用户密码不能为空")
    @Length(min = 1, max = 20)
    private String password;
}
