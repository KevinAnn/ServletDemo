package com.servlet.servlet;

import com.servlet.pojo.UserPO;
import com.servlet.service.LoginService;
import com.servlet.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 主页Servlet
 * @author: 安琪
 * @create: 2018-10-06 20:50
 */
public class IndexServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获取cookie
        Cookie[] requestCookies = request.getCookies();
        UserPO userPO = new UserPO();
        if (null != requestCookies) {
            for (Cookie cookie : requestCookies) {
                if ("username".equals(cookie.getName())) {
                    userPO.setUsername(cookie.getValue());
                }
                if ("password".equals(cookie.getName())) {
                    userPO.setPassword(cookie.getValue());
                }
            }
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        // 校验用户名密码
        LoginService loginService = new LoginServiceImpl();
        Boolean loginCheck = loginService.loginCheck(userPO);
        // 校验成功跳转主页，失败则跳转登录页面
        if (loginCheck) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }




    }


}
