package com.neuedu.servlet;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.entity.User;
import com.neuedu.page.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/SelectByName")
public class SelectVipByNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao=new UserDaoImpl();
        String uname=req.getParameter("selectUname");
        List<User> userList =userDao.listUserByUname(uname);
        Page page=new Page();
        page.setContent(userList);
        req.setAttribute("page",page);
        req.getRequestDispatcher("vip.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
