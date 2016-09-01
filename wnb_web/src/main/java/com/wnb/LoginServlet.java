package com.wnb;

import com.google.common.base.Strings;
import com.wnb.model.Msg;
import com.wnb.util.PropertiesUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangnianbao on 2016/9/1.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  super.doGet(req, resp);
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        Msg msg=new Msg();
        if(Strings.isNullOrEmpty(username)){
            msg.setMsg("用户名为空");
            msg.setStatus(-1);
        }
        if(Strings.isNullOrEmpty(password)){
            msg.setMsg("密码为空");
            msg.setStatus(-2);
        }
        if(!Strings.isNullOrEmpty(password)&&Strings.isNullOrEmpty(username)){
            String propUserName= PropertiesUtil.getProperty("username");
            String propPassWord=PropertiesUtil.getProperty("password");
            if(username.equals(propUserName)&&password.equals(propPassWord)){
                msg.setMsg("登录成功！");
                msg.setStatus(1);
                req.setAttribute("username",propUserName);
            }
        }
        if(msg.getStatus()==0){
            msg.setMsg("登入失败，请检查密码或用户名");
            msg.setStatus(-2);
        }
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").
                forward(req, resp);
    }

}
