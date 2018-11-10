package com.neuedu.servlet;

import com.neuedu.entity.Order;
import com.neuedu.page.Page;
import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService=new OrderServiceImpl();
        String n= req.getParameter("n");
        int pagen=-1;
        if (n==null){
            pagen=1;
        }else {
            pagen= Integer.valueOf(n);
        }
        Page page=new Page();
        page.setCurrentpage(pagen);
        page.setCount(orderService.orderCount());
        page.setContent(orderService.listOrder((pagen-1)*page.getPageCount(),page.getPageCount()));
        req.setAttribute("page",page);
        req.getRequestDispatcher("order.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
