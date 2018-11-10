package com.neuedu.servlet;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/register"})
public class registerServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname=req.getParameter("uname");
        String uemail=req.getParameter("email");
        String upws=req.getParameter("password");
        String uphone=req.getParameter("phone");
        UserService userService=new UserServiceImpl();
        User user=userService.checkUname(uname);
        PrintWriter out=resp.getWriter();
        if (user!=null){
            //账号已存在
            out.print(false);
        }else {
            //账号不存在
            out.print(true);
            int i=userService.register(uname,upws,uemail,uphone);
            if (i!=-1){
                //注册成功
                resp.sendRedirect("login.jsp");
            }else {
                resp.sendRedirect("login.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
