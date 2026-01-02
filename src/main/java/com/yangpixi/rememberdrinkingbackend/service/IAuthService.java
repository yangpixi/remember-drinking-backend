package com.yangpixi.rememberdrinkingbackend.service;

/**
 * @author yangpixi
 * @date 2026/1/1 16:42
 * @description 登录服务接口
 */

public interface IAuthService {

    String login(String username, String password);

    // 思考：如果参数较多，应该封装成一个dto对象进行参数传递
    void register(String username, String password, String phone);
}
