<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>员工管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="images/logo.jpg" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .back{
            background: url("images/logo2.jpg");
            width: 572px;
            height: 412px;
            background-size: 100% auto;
            background-repeat: no-repeat;
            position: fixed;
            left: 850px;
            top: 125px;
        }
    </style>
</head>
<body>
<div class="body">
    <div class="content">
        <div class="head">
            <div class="back"></div>
            <h2 class="text-center">欢迎来到宇科技</h2>
            <h3 class="text-center">修改管理员信息</h3>
        </div>
        <div class="hbody">
            <div class="container">
                <div class="null"></div>
                <div class="null"></div>
                <div class="null"></div>
                <div class="null"></div>
                <form class="form-horizontal" action="updatestaff" method="post">
                    <div class="form-group">

                        <label for="receiver" class="col-sm-2 control-label">收货人姓名</label>
                        <div class="col-sm-6">
                            <input type="hidden" name="uname" value="${user[0].uname}">
                            <input type="text" class="form-control" id="receiver" name="receiver" placeholder="收货人姓名" value="${user[0].receiver}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="raddress" class="col-sm-2 control-label">收货地址</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="raddress" name="raddress" placeholder="收货地址" value="${user[0].raddress}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="rtelephone" class="col-sm-2 control-label">收货电话</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="rtelephone" name="rtelephone" placeholder="收货电话" value="${user[0].rtelephone}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="ubirthday" class="col-sm-2 control-label">生日</label>
                        <div class="col-sm-6">
                            <input type="date" class="form-control" id="ubirthday" name="ubirthday" value="${user[0].ubirthday}">
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-6">
                            <label class="radio-inline">
                                <input type="radio" name="usex" id="inlineRadio1" value="男"<c:if test="${user[0].usex=='男'}">checked</c:if>>> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="usex" id="inlineRadio2" value="女"<c:if test="${user[0].usex=='女'}">checked</c:if>>> 女
                            </label>

                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Sign in</button>
                        </div>
                    </div>
                </form>
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