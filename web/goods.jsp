<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品展示</title>
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
            <h3 class="text-center">商品展示</h3>
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
                <form action="SelectByGname" method="post">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="input-group">
                                <input type="text" class="form-control" name="selectgname" placeholder="请输入商品名称......">
                                <span class="input-group-btn">
        <button class="btn btn-default" type="submit">Go!</button>
      </span>
                            </div><!-- /input-group -->
                        </div><!-- /.col-lg-6 -->
                    </div>
                </form>
                <div class="row">
                    <table class="table">

                        <tr>
                            <th class="text-center"><input type="checkbox"></th>
                            <th class="text-center">#</th>
                            <th class="text-center">图片</th>
                            <th class="text-center">商品名称</th>
                            <th>商品详情</th>
                            <th class="text-center">价格</th>
                            <th class="text-center">类型</th>
                            <th class="text-center">库存</th>
                            <th class="text-center">销售量</th>
                            <th class="text-center">操作</th>
                        </tr>

                        <c:forEach items="${page.content}" var="goods" varStatus="i">
                            <tr>
                                <input type="hidden" value="${goods.gid}">
                                <td class="text-center"><input type="checkbox"></td>
                                <td class="text-center">${i.index+1}</td>
                                <td class="text-center"><img src="onload/${goods.gimg}" class="gimg"></td>
                                <td class="text-center">${goods.gname}</td>
                                <td><div class="over"><div class="gstandard">${goods.gstandard}</div></div></td>
                                <td class="text-center">${goods.gprice}</td>
                                <td class="text-center">${goods.type.tname}</td>
                                <td class="text-center">${goods.grepertory}</td>
                                <td class="text-center">${goods.gsalesvolume}</td>
                                <td class="text-center"> <button type="button" class="btn btn-info" onclick="location.href='updategoodsview?gid=${goods.gid}'">修改</button>
                                    <button type="button" class="btn btn-danger" onclick="location.href='deletegoods?gid=${goods.gid}'">删除</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="row">
                    <div class="col-sm-11">
                        <button type="button" class="btn btn-primary col-sm-1" onclick=last(${page.currentpage})>上一页</button>
                        <div class="col-sm-1"></div>
                        <button type="button" class="btn btn-primary col-sm-1" onclick=next(${page.currentpage},${page.pageNumber})>下一页</button>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="location.href='addgoodsview'">添加商品</button>
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
    if (current==1) {
        window.location.href = "goods?n=" +current;
        return;
    }
    window.location.href = "goods?n=" +(current-1);
}
function next(current,pageNumber) {
    if (current==pageNumber) {
        window.location.href = "goods?n=" +current;
        return;
    }
    window.location.href = "goods?n=" +(current+1);
}
</script>
