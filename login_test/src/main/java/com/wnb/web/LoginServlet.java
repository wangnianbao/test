package com.wnb.web;

import com.google.common.base.Strings;
import com.wnb.web.model.Msg;
import com.wnb.web.util.PropertiesUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangnianbao on 2016/7/23.
 */

public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Msg msg = new Msg();
        if (Strings.isNullOrEmpty(username)){
            msg.setMsg("用户名为空！");
            msg.setStatus(-1);
        }
        if (Strings.isNullOrEmpty(password)){
            msg.setMsg("密码不能为空！");
            msg.setStatus(-1);
        }
        if (!Strings.isNullOrEmpty(username) && !Strings.isNullOrEmpty(password)){
            String propUserName = PropertiesUtil.getProperty("username");
            String propPassword = PropertiesUtil.getProperty("password");

            if (username.equals(propUserName) && password.equals(propPassword)){
                msg.setMsg("登录成功！");
                msg.setStatus(1);
                request.setAttribute("username",propUserName);
            }
        }
        if (msg.getStatus() == 0){
            msg.setMsg("登录失败，请检查用户名或密码！");
            msg.setStatus(-2);
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
    }
}
