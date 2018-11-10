package com.neuedu.servlet;

import com.neuedu.entity.Goods;
import com.neuedu.page.Page;
import com.neuedu.service.GoodsService;
import com.neuedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectByGname")
public class SelectGoodsByGnameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String gname=req.getParameter("selectgname");
        GoodsService goodsService=new GoodsServiceImpl();
        List<Goods> goodsList=goodsService.SelectGoodsByGname(gname);
        Page page=new Page();
        page.setContent(goodsList);
        req.setAttribute("page",page);
        req.getRequestDispatcher("goods.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
