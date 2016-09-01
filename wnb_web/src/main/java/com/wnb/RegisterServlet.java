package com.wnb;

import com.wnb.db.DataBaseDao;
import com.wnb.model.Msg;
import com.wnb.model.UserInfo1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by wangnianbao on 2016/8/30.
 */
public class RegisterServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    @Override
    protected  void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        String username =req.getParameter("userName");
        String password =req.getParameter("passWord");
        String method =req.getParameter("method");
        String xueli=req.getParameter("xueli");
        String sex=req.getParameter("sex");
        if ("query".equals(method)){
            List<UserInfo1> userInfos =  DataBaseDao.query(username);
            req.setAttribute("userinfos", userInfos);
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
        }else {
            Msg msg = new Msg();
            boolean flag = DataBaseDao.insert(username,password,xueli,sex);
            if (flag) {
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
            } else {
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
            }
        }
    }
        //return super.getLastModified(req);
    }
