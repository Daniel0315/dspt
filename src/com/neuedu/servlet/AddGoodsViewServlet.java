package com.neuedu.servlet;

import com.neuedu.dao.TypeDao;
import com.neuedu.dao.impl.TypeDaoImpl;
import com.neuedu.entity.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/addgoodsview")
public class AddGoodsViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TypeDao typeDao=new TypeDaoImpl();
        List<Type> typeList=typeDao.listType();
        req.setAttribute("type",typeList);
        req.getRequestDispatcher("addgoods.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
