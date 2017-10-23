<%--
  Created by IntelliJ IDEA.
  User: dnys
  Date: 2017/10/17
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>微信作业查询</title>
    <c:import url="../../../common/wxinclude.jsp"></c:import>
    <!-- 引入 WeUI -->
    <%--<link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/0.4.0/weui.min.css">--%>
    <style>
        .header{
            padding: 1.5rem;
            background:orange ;
            color: #fff;
        }
        .title{
            padding: 0.5rem;
            background: #2882ff;
            color: #fff;
        }
        .no_undeline:hover{
            text-underline: none;
        }
    </style>
</head>
<body >
<div class="header">作业列表</div>
<div class="weui-panel__bd">
    <c:forEach items="${zuoyeVoList}" var="zuoye">
    <a class="weui-media-box weui-media-box_appmsg no_undeline"  href= "zuoyeListUpload?zuoyeid=${zuoye.zuoyeid}">

            <div class="weui-media-box__hd">
                <div class="title">${zuoye.banjiname}</div>
            </div>
            <div class="weui-media-box__bd">
                <h4 class="weui-media-box__title">${zuoye.kemuname}</h4>
                <p class="weui-media-box__desc">${zuoye.task}</p>
            </div>


    </a>
    </c:forEach>
</div>

</body>
</html>
<script>
</script>
