package com.wnb.web;

import com.wnb.web.db.DataBaseDao;
import com.wnb.web.model.Msg;
import com.wnb.web.model.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by wangnianbao on 2016/7/28.
 */
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        req.getRequestDispatcher("/WEB-INF/pages/zhuce_index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String username = req.getParameter("userName");
        String password = req.getParameter("userPassWord");
        String method = req.getParameter("method");
        String xueli = req.getParameter("xueli");
        String sex = req.getParameter("sex");
        if ("query".equals(method)){
            List<UserInfo> userInfos =  DataBaseDao.query(username);
            req.setAttribute("userinfos", userInfos);
            req.getRequestDispatcher("/WEB-INF/pages/index2.jsp").forward(req, resp);
        }else {
            Msg msg = new Msg();
            boolean flag = DataBaseDao.insert(username,password,xueli,sex);
            if (flag) {
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
            } else {
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("/WEB-INF/pages/zhuce_index.jsp").forward(req, resp);
            }
        }
    }
}