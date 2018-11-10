package com.neuedu.servlet;

import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteOrder")
public class deleteOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String onum=req.getParameter("onum");
        System.out.println(onum);
        OrderService orderService=new OrderServiceImpl();
        int i=orderService.deleteOrder(onum);
        if (i!=-1){
            System.out.println("删除失败");
        }else {
            resp.sendRedirect("order");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
