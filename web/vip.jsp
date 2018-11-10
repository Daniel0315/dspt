<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>用户管理</title>
  <link rel="icon" href="images/logo.jpg" type="image/x-icon">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
      <h3 class="text-center">用户信息</h3>
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
        <form action="SelectByName" method="post">
            <div class="row">
                <div class="col-lg-6">
                    <div class="input-group">
                        <input type="text" class="form-control" name="selectUname" placeholder="请输入账号......">
                        <span class="input-group-btn">
        <button class="btn btn-default" type="submit">Go!</button>
      </span>
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
            </div>
        </form>
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
               <td class="text-center"><c:if test="${page.rlevel==1}">
                 <%out.print("vip用户");%>
               </c:if></td>
               <td class="text-center"> <button type="button" class="btn btn-primary" onclick="location.href='updatevipview?uname=${page.uname}'">修改</button>
                 <button type="button" class="btn btn-danger" onclick="location.href='deletevip?uname=${page.uname}'">删除</button>
               </td>
             </tr>
           </c:forEach>

          </table>
        <div class="row">
          <div class="col-sm-9">
            <button type="button" class="btn btn-primary" onclick="last(${page.currentpage})">上一页</button>
            <button type="button" class="btn btn-primary" onclick="next(${page.currentpage},${page.pageNumber})">下一页</button>
          </div>
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
            window.location.href="vip?n="+current;
            return
        }
        window.location.href="vip?n="+(current-1);
}
function next(current,pageNumber) {
    if (current==pageNumber){
        window.location.href="vip?n="+current;
        return
    }
    window.location.href="vip?n="+(current+1);
}


</script>


