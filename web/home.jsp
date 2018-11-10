<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>宇科技后台管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="images/logo.jpg" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .uname{
            color: #985f0d;
            font-size: 20px;
            width: 100%;
            height: 100px;
            padding: 20px;
        }
        .but{
            position: absolute;
            right: 1px;

        }
    </style>
</head>
<body>
<div class="body">
    <div class="nav">
        <div class="null"></div>
        <div class="h3"><p class="text-center"><i class="glyphicon glyphicon-piggy-bank"></i>宇科技后台管理</p></div>
        <div class="text-center uname">
            <c:if test="${sessionScope.user==null}">
                对不起,您未登录
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                你好! ${sessionScope.user.uname}
            </c:if>
        </div>
        <div class="navcontent">
            <ul class="drop nav-pills nav-stacked">
                <c:forEach items="${auth}" var="auth">
                    <li class="text-center button"><a href="${auth.url}"><i class="${auth.aphone}"></i>${auth.acontent}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="content">
        <input type="button" class="btn btn-default col-lg-1 but" value="退出" onclick="location.href='login.jsp'">
        <div class="head">
            <h2 class="text-center">欢迎来到宇科技</h2><h3 class="text-center">后台管理系统</h3>
        </div>
        <div class="hbody">
            <div class="img">
                <div class="leftbutton"><i><</i></div>
                <div class="rightbutton"><i>></i></div>
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
    $(function () {
        var set;
        var i=2;
        $(".leftbutton").click(function () {
            clearInterval(set);
            $(".img").css("background-image","url(images/ad"+i+".jpg)");
            i++;
            if (i>8){
                i=1;
            }
        })
        $(".rightbutton").click(function () {
            clearInterval(set);

            $(".img").css("background-image","url(images/ad"+i+".jpg)");
            i--;
            if (i<1){
                i=8;
            }
        })
        $(".img").mouseover(function () {
            set=setInterval(function () {
                $(".img").css("background-image","url(images/ad"+i+".jpg)");
                i++;
                if (i>8){
                    i=1;
                }
            },1000)
        })
        $(".img").mouseout(function () {
            clearInterval(set);
        })
        $(".leftbutton").mouseover(function () {
            clearInterval(set);
        })
        $(".rightbutton").mouseover(function () {
            clearInterval(set);
        })
    })
</script>
