package com.servlet.servlet;

import com.servlet.pojo.UserPO;
import com.servlet.service.LoginService;
import com.servlet.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Expression;
import java.io.IOException;

/**
* @Description: 登录Servlet
* @Author: 安琪
* @Date: 2018/9/27 07:37
*/
public class LoginServlet extends HttpServlet {


    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 设置请求和相应的编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获取表单信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 设置cookie
        Cookie usernameCookie = new Cookie("username", username);
        Cookie passwordCookie = new Cookie("password", password);
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);

        // 打印用户名、密码
        System.out.println("username:" + username);
        System.out.println("password:" + password);

        // 校验用户名、密码
        UserPO userPO = new UserPO();
        userPO.setUsername(username);
        userPO.setPassword(password);
        LoginService loginService = new LoginServiceImpl();
        Boolean result = loginService.loginCheck(userPO);

        // 打印结果
        System.out.println(result);

        // 跳转
        if (result) {
            //response.getWriter().write("登录成功");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            response.getWriter().write("用户名密码不正确");
        }




    }
}

