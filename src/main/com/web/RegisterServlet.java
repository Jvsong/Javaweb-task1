package com.web;

import com.song.pojo.User;
import com.song.mapper.UserMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession()) {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 验证用户名是否已经存在
            if (userMapper.validateUser(username, password)) {
                // 用户名已存在，反馈失败消息
                request.setAttribute("errorMessage", "用户名已存在，请选择其他用户名！");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } else {
                // 用户名不存在，插入新用户到数据库
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);

                userMapper.insertUser(user);
                sqlSession.commit();

                // 注册成功，反馈成功消息
                request.setAttribute("successMessage", "注册成功！请登录您的账号。");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 出现异常，反馈失败消息
            request.setAttribute("errorMessage", "注册失败，请稍后重试！");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
    }
}

