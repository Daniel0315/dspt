package com.neuedu.filter;


import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class LoginFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String uri=request.getRequestURI();
        String path=uri.substring(uri.lastIndexOf("/")+1);
        String hou=uri.substring(uri.lastIndexOf(".")+1);
        if ("login.jsp".equals(path)||"login".equals(path)||"register".equals(path)||"createcode".equals(path)){
            filterChain.doFilter(request,response);
        }
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("user");
        if (user!=null){
            //登录成功
            filterChain.doFilter(request,response);
        }else {
            Cookie[] cookies=request.getCookies();
            if (cookies!=null){
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")){
                        String username=cookie.getValue();
                        UserDao userDao=new UserDaoImpl();
                        User user1=userDao.checkUname(username);
                        session.setAttribute("user",user1);
                        filterChain.doFilter(request,response);
                    }
                }
            }
        }
        if ("css".equals(hou)||"js".equals(hou)||"jpg".equals(hou)||"png".equals(hou)){
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
