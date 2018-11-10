package com.neuedu.servlet;

import com.neuedu.dao.GoodsDao;
import com.neuedu.dao.TypeDao;
import com.neuedu.dao.impl.GoodsDaoImpl;
import com.neuedu.dao.impl.TypeDaoImpl;
import com.neuedu.entity.Goods;
import com.neuedu.entity.Type;
import com.neuedu.page.Page;
import com.neuedu.service.GoodsService;
import com.neuedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsService goodsService=new GoodsServiceImpl();
        Page page=new Page();
        String n=req.getParameter("n");
        int pagen=0;
        if (n==null){
            pagen=1;
        }else {
            pagen=Integer.valueOf(n);
        }
        page.setCount(goodsService.sumCount());
        page.setCurrentpage(pagen);
        page.setContent(goodsService.listGoods((pagen-1)*page.getPageCount(),page.getPageCount()));
        req.setAttribute("page",page);
        req.getRequestDispatcher("goods.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
