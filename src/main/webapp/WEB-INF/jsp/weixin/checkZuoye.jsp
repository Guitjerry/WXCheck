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
    <title>学生作业查询</title>
    <c:import url="../../../common/wxinclude.jsp"></c:import>
    <!-- 引入 WeUI -->
    <%--<link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/0.4.0/weui.min.css">--%>
    <style>
        .header{
            padding: 1.5rem;
            background:orange ;
            color: #fff;
        }
    </style>
</head>
<body >
<div class="header">学生作业查询</div>
<div class="weui-cell">
    <div class="weui-cell__hd"><label class="weui-label">学生编号</label></div>
    <div class="weui-cell__bd">
        <input class="weui-input" type="number" pattern="[0-9]*" placeholder="请输入学生编号" id="usercode">
    </div>
</div>
<div class="weui-btn-area">
    <a class="weui-btn weui-btn_primary" onclick="checkZuoyeList()"  id="showTooltips">查询</a>
</div>
</body>
</html>
<script>
    function checkZuoyeList(){
        location.href = "checkZuoyeList?usercode="+$('#usercode').val();
    }
</script>