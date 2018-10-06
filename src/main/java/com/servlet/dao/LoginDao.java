package com.servlet.dao;

import com.servlet.pojo.UserPO;

/**
 * @Description: 登录Dao层接口
 * @Author: 安琪
 * @Date: 2018/9/26 21:17
 */
public interface LoginDao {


    /**
     * @description: 通过用户名查询密码
     * @params: [username]
     * @return: java.lang.String
     * @author: 安琪
     * @date: 2018/9/27 07:31
     */
    String getPasswordByUsername(String username);
}
