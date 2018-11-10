<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改商品信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="images/logo.jpg" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="body">
    <div class="background"></div>
    <div class="content">
        <div class="head">
            <h2 class="text-center">欢迎来到宇科技</h2>
            <h3 class="text-center">修改商品信息</h3>
        </div>
        <div class="hbody">
            <div class="container">
                <div class="row head"></div>
                <div class="row">
                    <form class="form-horizontal" action="updategoods" method="post" enctype="multipart/form-data">
                        <div class="form-group has-success has-feedback">
                            <label class="control-label col-sm-2" for="gname">商品名称</label>
                            <div class=" form-group col-sm-6">
                                <input type="hidden" name="gid" value="${goods.gid}">
                                <input type="text" name="gname" class="form-control" id="gname" value="${goods.gname}">
                                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                <span id="inputSuccess3Statu" class="sr-only">(success)</span>
                            </div>
                        </div>

                        <div class="form-group has-success has-feedback">
                            <label class="control-label col-sm-2" for="cid">类型</label>
                            <div class=" form-group col-sm-6">
                                <select class="form-control" name="tname" id="cid">
                                   <c:forEach items="${type}" var="type">
                                       <option value="${type.tname}" <c:if test="${goods.cid==type.tid}">selected</c:if>>${type.tname}</option>
                                   </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group has-success has-feedback">
                            <label class="control-label col-sm-2" for="gprice">商品单价</label>
                            <div class="form-group col-sm-6">
                                <label class="sr-only" for="gprice">Amount (in dollars)</label>
                                <div class="input-group">
                                    <div class="input-group-addon">$</div>
                                    <input type="text" class="form-control" name="gprice" id="gprice" value="${goods.gprice}">
                                    <div class="input-group-addon">.00</div>
                                </div>
                            </div>
                        </div>


                        <div class="form-group has-success has-feedback">
                            <label class="control-label col-sm-2" for="gsalesvolume">销售量</label>
                            <div class=" form-group col-sm-6">
                                <input type="text" class="form-control" id="gsalesvolume" name="gsalesvolume" value="${goods.gsalesvolume}">
                                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                <span id="inputSuccess3Stat" class="sr-only">(success)</span>
                            </div>
                        </div>


                        <div class="form-group has-success has-feedback">
                            <label class="control-label col-sm-2" for="grepertory">商品库存</label>
                            <div class=" form-group col-sm-6">
                                <input type="text" class="form-control" id="grepertory" name="grepertory" aria-describedby="inputSuccess3Status" value="${goods.grepertory}">
                                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                                <span id="inputSuccess3Status" class="sr-only">(success)</span>
                            </div>
                        </div>


                        <div class="form-group has-success has-feedback">
                            <label class="control-label col-sm-2" for="gstandard">商品规格</label>
                            <div class=" form-group col-sm-6">
                                        <textarea rows="5" cols="5" class="form-control" name="gstandard" id="gstandard" >${goods.gstandard}
                                        </textarea>
                            </div>
                        </div>

                        <div class="form-group has-success has-feedback">
                            <label class="control-label col-sm-2" for="gremarks">备注</label>
                            <div class=" form-group col-sm-6">
                                        <textarea rows="5" cols="5" class="form-control" name="gremarks" id="gremarks" aria-describedby="inputSuccess3Status">${goods.gremarks}
                                        </textarea>
                            </div>
                        </div>

                        <div class="form-group has-success has-feedback">
                            <label class="control-label col-sm-2" for="gimg">文件上传</label>
                            <div class=" form-group col-sm-6">
                                <input name="gimg" type="file" id="gimg" class="btn-primary pos" value="${goods.gimg}">
                                <button type="button" class="btn btn-primary pos wen">文件上传</button>

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">提交</button>
                            </div>
                        </div>
                    </form>
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
    $(function () {
        $(".wen").click(function () {
            $("#gimg").click();
        })
    })
</script>
