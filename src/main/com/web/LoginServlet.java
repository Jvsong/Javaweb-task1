package com.web;

import com.song.mapper.UserMapper;
import com.song.pojo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession()) {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 查询用户信息
            User user = userMapper.select(username, password);

            if (user != null) {
                // 登录成功，将用户信息保存到 Session
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getUsername()); // 存储数据

                // 跳转到登录成功页面
                response.sendRedirect(request.getContextPath() + "/Success.jsp");
            } else {
                // 登录失败，设置错误信息并跳转回登录页面
                request.setAttribute("errorMessage", "用户名或密码无效！");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Fail.jsp");
        }
    }
}
