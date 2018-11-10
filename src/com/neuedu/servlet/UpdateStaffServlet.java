package com.neuedu.servlet;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.entity.User;
import com.neuedu.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatestaff")
public class UpdateStaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uname=req.getParameter("uname");
        String usex=req.getParameter("usex");
        String ubirthday=req.getParameter("ubirthday");
        String receiver=req.getParameter("receiver");
        String raddress=req.getParameter("raddress");
        String rtelephone=req.getParameter("rtelephone");
        System.out.println(ubirthday);
        User user=new User();
        user.setRtelephone(rtelephone);
        user.setRaddress(raddress);
        user.setReceiver(receiver);
        user.setUbirthday(DateUtil.getDate(ubirthday));
        user.setUname(uname);
        user.setUsex(usex);
        UserDao userDao=new UserDaoImpl();
        int i=userDao.updateUser(user);
        if (i==-1){
            System.out.println("删除失败");
        }else {

            resp.setCharacterEncoding("utf-8");
            resp.sendRedirect("staff");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
