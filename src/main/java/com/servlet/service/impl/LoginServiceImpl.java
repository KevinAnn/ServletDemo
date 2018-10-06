package com.servlet.service.impl;

import com.servlet.dao.LoginDao;
import com.servlet.dao.impl.LoginDaoImpl;
import com.servlet.pojo.UserPO;
import com.servlet.service.LoginService;

/**
 * @description: 登录Service实现类
 * @author: 安琪
 * @create: 2018-09-26 23:10
 */
public class LoginServiceImpl implements LoginService {


    /**
     * @description: 校验用户名密码是否匹配
     * @params: [userPO]
     * @return: java.lang.Boolean
     * @author: 安琪
     * @date: 2018/9/26 23:19
     */
    @Override
    public Boolean loginCheck(UserPO userPO) {

        // 创建dao层对象
        LoginDao loginDao = new LoginDaoImpl();
        // 获取密码
        if (null != userPO.getUsername()) {
            String password = loginDao.getPasswordByUsername(userPO.getUsername());
            // 校验密码
            if (userPO.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }



    }
}
