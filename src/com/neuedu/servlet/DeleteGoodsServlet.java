package com.neuedu.servlet;

import com.neuedu.service.GoodsService;
import com.neuedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deletegoods")
public class DeleteGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsService goodsService=new GoodsServiceImpl();
        Integer gid=Integer.valueOf(req.getParameter("gid"));
        int i=goodsService.deletegoods(gid);
        if (i!=-1){
            resp.sendRedirect("goods");
        }else {
            System.out.println("删除失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
