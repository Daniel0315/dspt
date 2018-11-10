<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="images/logo.jpg" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .uname{
            color: #985f0d;
            font-size: 30px;
            width: 20%;
            height: 100px;
            padding: 20px;
            position: absolute;
            top: 30px;
            left: 1px;

        }
    </style>
</head>
<body>
<div class="body">
    <div class="content">
        <div class="head">
            <h2 class="text-center">欢迎来到宇科技</h2>
            <h3 class="text-center">订单管理</h3>
            <div class="text-center uname"><c:if test="${sessionScope.user==null}">
                对不起,您未登录
            </c:if>
                <c:if test="${sessionScope.user!=null}">
                    你好! ${sessionScope.user.uname}
                </c:if></div>
        </div>
        <div class="hbody">
            <div class="container">

                <div class="row head"></div>
                <div class="row">
                    <table class="table">

                        <tr>
                            <th class="text-center"><input type="checkbox"></th>
                            <th class="text-center">订单号</th>
                            <th class="text-center">商品名称</th>
                            <th class="text-center">购买数量</th>
                            <th class="text-center">订单创建时间</th>
                            <th class="text-center">发货时间</th>
                            <th class="text-center">用户账户</th>
                        </tr>
                        <c:forEach items="${page.content}" var="order">
                        <tr>
                            <td class="text-center"><input type="checkbox"></td>
                            <td class="text-center">${order.onum}</td>
                            <td class="text-center">${order.goods.gname}</td>
                            <td class="text-center">${order.gnum}</td>
                            <td class="text-center">${order.ocreatedate}</td>
                            <td class="text-center">${order.deliverydate}</td>
                            <td class="text-center">${order.user.uname}</td>

                        </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="row">
                    <div class="col-sm-11">
                        <button type="button" class="btn btn-primary col-sm-1" onclick="last(${page.currentpage})">上一页</button>
                        <div class="col-sm-1"></div>
                        <button type="button" class="btn btn-primary col-sm-1" onclick="next(${page.currentpage},${page.pageNumber})">下一页</button>
                    </div>
                </div>
                <div class="row foot"></div>
            </div>
        </div>
    </div>
    <div class="foot">
        <p class="text-center">Copyright © 2018. 宇科技 All rights reserved</p>
    </div>
</div>



<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
<script>
    function last(current) {
        if (current==1){
            //第一页
            window.location.href='order?n='+current;
            return;
        } else {
            window.location.href='order?n='+(current-1);
        }
    }

    function next(current,pageNumber) {
        if (current==pageNumber){
            //第一页
            window.location.href='order?n='+current;
            return;
        } else {
            window.location.href='order?n='+(current+1);
        }
    }
</script>
