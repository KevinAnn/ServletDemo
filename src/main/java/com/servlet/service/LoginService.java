package com.servlet.service;

import com.servlet.pojo.UserPO;

/**
* @Description: 登录Service接口
* @Author: 安琪
* @Date: 2018/9/26 23:11
*/
public interface LoginService {

    /**
     * @description: 校验用户名和密码是否匹配
     * @params: [username]
     * @return: java.lang.Boolean
     * @author: 安琪
     * @date: 2018/9/26 23:13
     */
    Boolean loginCheck(UserPO userPO);
}
