package com.wnb.web;

import com.google.common.base.Strings;
import com.wnb.web.db.DataBaseDao;
import com.wnb.web.model.Msg;
import com.wnb.web.util.PropertiesUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangnianbao2 on 2016/7/26.
 */
public class LoginServlet2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        req.getRequestDispatcher("/WEB-INF/pages/login2.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        String username = req.getParameter("username2");
        String password = req.getParameter("password2");
        String phone=req.getParameter("phone");
        Msg msg = new Msg();
        if (Strings.isNullOrEmpty(username)){
            msg.setMsg("用户名为空！");
            msg.setStatus(-1);
        }
        if (Strings.isNullOrEmpty(password)){
            msg.setMsg("密码不能为空！");
            msg.setStatus(-1);
        }
        if(Strings.isNullOrEmpty(phone))
        {
            msg.setMsg("号码不能为空！");
            msg.setStatus(-1);
        }
        if (!Strings.isNullOrEmpty(username) && !Strings.isNullOrEmpty(password)){
            boolean flag = DataBaseDao.isLogin(username, password);
            if (flag){
                msg.setMsg("登录成功！");
                msg.setStatus(1);
                req.setAttribute("username2",username);
            }
        }
        if (msg.getStatus() == 0){
            msg.setMsg("登录失败，请检查用户名或密码！");
            msg.setStatus(-2);
        }
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("/WEB-INF/pages/index2.jsp").forward(req, resp);
    }



}
