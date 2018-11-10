package com.neuedu.servlet;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deletevip")
public class DeleteVipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao=new UserDaoImpl();
        String uname=req.getParameter("uname");
        int i=userDao.deleteUser(uname);
        if (i==-1){
            System.out.println("删除失败");
        }else {
            resp.sendRedirect("vip");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
