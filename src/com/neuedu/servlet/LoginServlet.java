package com.neuedu.servlet;

import com.neuedu.dao.AuthorityDao;
import com.neuedu.dao.impl.AuthorityDaoImpl;
import com.neuedu.entity.Authority;
import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取前台传过来的账号和密码
        String uname=req.getParameter("username");
        String upwd=req.getParameter("password");

        //到数据库查询是否有这个记录
        UserService userService=new UserServiceImpl();
        AuthorityDao authorityDao=new AuthorityDaoImpl();
        User user=userService.login(uname,upwd);
        if (user!=null){
            //登录成功

            //设置session的值
            HttpSession session=req.getSession();
            session.setAttribute("user",user);

            //把用户名和密码放在cookies中
            Cookie username=new Cookie("username",user.getUname());
            Cookie password=new Cookie("password",user.getUpwd());
            username.setMaxAge(60*60*24*7);
            password.setMaxAge(60*60*24*7);
            resp.addCookie(username);
            resp.addCookie(password);
            if (user.getRlevel()==2){
                String radis=user.getRaids();
                String raidss[]=radis.split(",");
                List<String> list=Arrays.asList(raidss);
                List<Authority> authorityList=authorityDao.listAuthority(list);
                req.setAttribute("auth",authorityList);
                req.getRequestDispatcher("home.jsp").forward(req,resp);
            }
        }else {
            //登录失败
            System.out.println("登录失败");
        }
    }



}
