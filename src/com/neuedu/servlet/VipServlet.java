package com.neuedu.servlet;

import com.neuedu.dao.AuthorityDao;
import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.AuthorityDaoImpl;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.entity.Authority;
import com.neuedu.entity.User;
import com.neuedu.page.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/vip")
public class VipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n=req.getParameter("n");//显示那一页
        int pagen=-1;//第几页
        if (n==null){
            pagen=1;
        }else {
            pagen=Integer.valueOf(n);
        }
        Page page=new Page();
        UserDao userDao=new UserDaoImpl();
        page.setCount(userDao.sumCount(1));
        page.setContent(userDao.listUser(1,(pagen-1)*page.getPageCount(),page.getPageCount()));
        page.setCurrentpage(pagen);
        req.setAttribute("page", page);
        req.getRequestDispatcher("vip.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
