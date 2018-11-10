package com.neuedu.servlet;

import com.neuedu.dao.TypeDao;
import com.neuedu.dao.impl.TypeDaoImpl;
import com.neuedu.entity.Goods;
import com.neuedu.entity.Type;
import com.neuedu.entity.User;
import com.neuedu.service.GoodsService;
import com.neuedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updategoodsview")
public class UpdateGoodsViewServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsService goodsService=new GoodsServiceImpl();
        Integer gid=Integer.valueOf(req.getParameter("gid"));
        Goods goods =goodsService.findByGid(gid);
        TypeDao typeDao=new TypeDaoImpl();
        List<Type> typeList=typeDao.listType();
        req.setAttribute("type",typeList);
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("updategoods.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
