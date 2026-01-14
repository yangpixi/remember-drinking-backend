package com.yangpixi.rememberdrinkingbackend.vo;

import lombok.Data;

/**
 * @author yangpixi
 * @date 2026/1/14 11:41
 * @description 返回的用户数据类
 */

@Data
public class UserDetailsVO {
    private String username;
    private String phone;
    private String avatar;
}
