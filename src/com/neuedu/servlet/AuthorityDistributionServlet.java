package com.neuedu.servlet;

import com.neuedu.dao.AuthorityDao;
import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.AuthorityDaoImpl;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.entity.Authority;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/distribution")
public class AuthorityDistributionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uname=req.getParameter("authname");
        String aid[]=req.getParameterValues("authority");
        String raids="";
        for (int i = 0; i < aid.length; i++) {
            raids+=aid[i]+",";
        }
        UserDao userDao=new UserDaoImpl();
        int i=userDao.distribution(uname,raids);
        PrintWriter out=resp.getWriter();
        if (i!=-1){
            //分配成功
            resp.sendRedirect("staff");
        }
        else {
            //分配失败
           out.print(2);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
