package com.servlet.dao.impl;

import com.servlet.dao.LoginDao;
import com.servlet.pojo.UserPO;

import java.sql.*;

/**
 * @Description: 登录dao层实现类
 * @Author: 安琪
 * @Date: 2018/9/26 21:16
 */
public class LoginDaoImpl implements LoginDao {


    /**
     * @description: 通过用户名查询密码
     * @params: [userPO]
     * @return: java.lang.String
     * @author: 安琪
     * @date: 2018/9/26 23:09
     */
    @Override
    public String getPasswordByUsername(String username) {

        // 设置sql语句
        String sql = "SELECT * FROM servlet.user WHERE username = ?";
        // 初始化密码为null，如果查不到密码则返回null
        String password = null;
        try {
            // 获取jdbc连接对象
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置占位符的值
            pstmt.setString(1, username);
            // 执行sql
            ResultSet rs = pstmt.executeQuery();
            // 处理查询结果（判断rs的第一行值并取出第三列的内容）
            if (rs.next()) {
                password = rs.getString(3);
            }
            // 关闭jdbc对象
            closeObject(rs,pstmt,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }














    /**
     * @description: 关闭ResultSet、PrepareStatement、Connection对象
     * @params: [rs, pstmt, conn]
     * @return: void
     * @author: 安琪
     * @date: 2018/9/27 07:22
     */
    private static void closeObject(ResultSet rs, PreparedStatement pstmt, Connection conn) throws SQLException{
        if (null != rs) {
            rs.close();
        }
        if (null != pstmt) {
            pstmt.close();
        }
        if (null != conn) {
            conn.close();
        }
    }

    /**
     * @description: 加载jdbc驱动，获取连接对象
     * @params: []
     * @return: java.sql.Connection
     * @author: 安琪
     * @date: 2018/9/26 22:44
     */
    private static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "root123456";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
