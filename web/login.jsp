
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录表单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="icon" href="images/logo.jpg" type="image/x-icon">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"  media="all">
    <style>
        .codetime{
            color: #b2dba1;
        }
    </style>
</head>
<body>

<h1>宇科技</h1>

<div class="container w3layouts agileits">

    <div class="login w3layouts agileits">
        <h2>登 录</h2>
        <form action="login" method="post">
            <input type="text" name="username" placeholder="用户名" value="${sessionScope.user.uname}" required="">
            <input type="password" name="password" placeholder="密码" value="${sessionScope.user.upwd}" required="">
            <i class="codetime"></i>
        <div class="send-button w3layouts agileits">
            <form>
                <input type="submit" value="登 录">
            </form>
        </div>

        </form>
        <div class="clear"></div>
    </div>
    <div class="register w3layouts agileits">
        <h2>注 册</h2>
        <form action="register" method="post">
            <input type="text" class="name" name="uname" placeholder="用户名">
            <span id="checkname"></span>
            <input type="text" name="email" placeholder="邮箱">
            <input type="password" name="password" placeholder="密码">
            <input type="text" name="phone" placeholder="手机号码">
            <div class="send-button w3layouts agileits">
                <input type="submit" value="免费注册">
            </form>
        </div>
        <div class="clear"></div>
    </div>

    <div class="clear"></div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

</body>
<!-- //Body -->
</html>
<script>
    $(function () {
        $(".name").blur(function () {
            var name=$(this).val();
            //校验用户名是否正确
                //校验正确
                $.ajax({
                    url:"register?uname="+name,
                    type:"post",
                    success:function(data) {
                        if (data=="true"){
                            $("#checkname").innerHTML="用户名可用"
                        }else {
                            alert("用户名已存在")
                        }
                    },
                    error:function () {
                        alert("服务器忙");
                    }

                })

        })
        var ifflush=true;
        var time=10;
        $(".flushcode").click(function () {
            if (ifflush) {
                ifflush=false;
                $(this).attr("src", "createcode?id=" + Math.random());
                var img = setInterval(function () {
                    $(".codetime").html(time--);
                    if (time == -1) {
                        ifflush=true;
                        clearInterval(img);
                        time = 10;
                        $(".codetime").html("");
                    }
                }, 1000);
            }
        })

        $("#code").blur(function (code) {
            code=$(this).val();
            //使用ajax去取值
            $.ajax({
                type:"post",
                url:"createcode?code="+code,
                success:function (data) {
                    if (data=="true"){
                        alert("验证码输入正确")
                    }else {
                        alert("验证码输入有误，请重新输入")
                    }
                }
            })
        })
    })
</script>