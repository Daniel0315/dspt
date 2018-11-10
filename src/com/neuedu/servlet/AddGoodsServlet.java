package com.neuedu.servlet;

import com.neuedu.dao.GoodsDao;
import com.neuedu.dao.TypeDao;
import com.neuedu.dao.impl.GoodsDaoImpl;
import com.neuedu.dao.impl.TypeDaoImpl;
import com.neuedu.entity.Goods;
import com.neuedu.utils.ImgUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
@WebServlet("/addgoods")
@MultipartConfig
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
        /**
         * 获取前台传入的数据
         */
        String gname=req.getParameter("gname");
        String gprice=req.getParameter("gprice");
        String grepertory=req.getParameter("grepertory");
        String gstandard=req.getParameter("gstandard");
        String gremarks=req.getParameter("gremarks");
        String tname=req.getParameter("tname");
        String gsalesvolume=req.getParameter("gsalesvolume");
        TypeDao typeDao=new TypeDaoImpl();
        String cid= String.valueOf(typeDao.listTypeByTname(tname).getTid());
        //取前台传过来的图片
        Part part=req.getPart("gimg");
        //服务器的路径
        String servletPath=req.getServletContext().getRealPath("/")+"onload\\";
        //将图片读写到文件夹中
        String gimg=ImgUtils.imgHandle(part,servletPath);

        /**
         * 将数据放到实体类中
         */
        Goods goods=new Goods();
        GoodsDao goodsDao=new GoodsDaoImpl();
        goods.setCid(Integer.valueOf(cid));
        goods.setGimg(gimg);
        goods.setGname(gname);
        goods.setGprice(Double.valueOf(gprice));
        goods.setGremarks(gremarks);
        goods.setGrepertory(Integer.valueOf(grepertory));
        goods.setGstandard(gstandard);
        goods.setGsalesvolume(Integer.valueOf(gsalesvolume));
         int i=goodsDao.insertGoods(goods);
         if (i!=-1){
             resp.sendRedirect("goods");
         }else {
             resp.sendRedirect("addgoodsview");
         }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
