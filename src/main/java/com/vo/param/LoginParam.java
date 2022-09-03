package com.vo.param;

import lombok.Data;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年09月02日 10:53
 */
@Data
public class LoginParam {
    private String phone;
    private String pwd;
    private String captcha;
}
