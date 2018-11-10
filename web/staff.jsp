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
        .authority{
            width: 300px;
            height: 200px;
            margin: 0px auto;
            border: 1px solid crimson;
            border-radius: 8px;
            font-size: 18px;
            color: #ac2925;
            display: none;
        }
        .butt{
            width: 100%;
        }
        .n{
            width: 100%;
            height: 140px;
        }
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
            <h3 class="text-center">管理员信息</h3>
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
                            <th class="text-center">#</th>
                            <th class="text-center">账户</th>
                            <th class="text-center">密码</th>
                            <th class="text-center">性别</th>
                            <th class="text-center">收货人</th>
                            <th class="text-center">收货地址</th>
                            <th class="text-center">收货电话</th>
                            <th class="text-center">等级</th>
                            <th class="text-center">权限分配</th>
                            <th class="text-center">操作</th>
                        </tr>

                        <c:forEach items="${page.content}" var="page" varStatus="i">
                            <tr>
                                <td class="text-center"><input type="checkbox"></td>
                                <td class="text-center">${i.index+1}</td>
                                <td class="text-center">${page.uname}</td>
                                <td class="text-center">${page.upwd}</td>
                                <td class="text-center">${page.usex}</td>
                                <td class="text-center">${page.receiver}</td>
                                <td class="text-center">${page.raddress}</td>
                                <td class="text-center">${page.rtelephone}</td>
                                <td class="text-center"><c:if test="${page.rlevel==2}">
                                    <%out.print("管理员用户");%>
                                </c:if></td>
                                <td class="text-center"><button type="button" name="auth" class="btn btn-primary auth" value="${page.uname}">分配</button> </td>
                                <td class="text-center"> <button type="button" class="btn btn-info" onclick="location.href='updatestaffview?uname=${page.uname}'">修改</button>
                                    <button type="button" class="btn btn-danger" onclick="location.href='deletestaff?uname=${page.uname}'">删除</button>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
                <form action="distribution" method="post">
                    <div class="authority ">
                        <div class="form-group has-feedback">
                            <label class="control-label col-sm-12 text-center" for="authority">权限分配</label>
                            <div class=" form-group col-sm-12">
                                <select class="form-control" name="authority" id="authority" multiple="multiple" size="3">

                                    <c:forEach items="${auth}" var="auth">
                                        <option class="text-center" value="${auth.aid}">${auth.acontent}</option>
                                    </c:forEach>

                                </select>
                            </div>
                        </div>
                        <div class="n"></div>
                        <input id="uname" name="authname" type="hidden">
                        <div class="butt text-center"><button type="submit" class="text-center btn btn-success" id="bt">提交权限</button></div>
                    </div>
                </form>
                <div class="row">
                    <div class="col-sm-9">
                        <button type="button" class="btn btn-primary" onclick="last(${page.currentpage})">上一页</button>
                        <button type="button" class="btn btn-primary" onclick="next(${page.currentpage},${page.pageNumber})">下一页</button>
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
            window.location.href="staff?n="+current;
            return
        }
        window.location.href="staff?n="+(current-1);
    }
    function next(current,pageNumber) {
        if (current==pageNumber){
            window.location.href="staff?n="+current;
            return
        }
        window.location.href="staff?n="+(current+1);
    }
    $(function () {
        $(".auth").click(function (e) {
            $(".authority").css("display","block");
            var target=e.target;
            $("#uname").val($(target).val());
        })

    })
</script>
