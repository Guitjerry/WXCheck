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
<div class="header">学生作业上传</div>
<div class="weui-cell">
    <div class="weui-cell__hd"><label class="weui-label">班级</label></div>
    <div class="weui-cell__bd">
        <input class="weui-input"   value="${zuoyeVo.banjiname}" disabled>
    </div>
</div>
<div class="weui-cell">
    <div class="weui-cell__hd"><label class="weui-label">科目</label></div>
    <div class="weui-cell__bd">
        <input class="weui-input"   value="${zuoyeVo.kemuname}" disabled>
    </div>
</div>
<div class="weui-cells__title" style="color: #666;font-weight:bold">作业</div>
<div class="weui-cell">
    <div class="weui-cell__bd">
        <textarea class="weui-textarea" placeholder="请输入文本" rows="3" >${zuoyeVo.task}</textarea>
        <%--<div class="weui-textarea-counter"><span>0</span>/1000</div>--%>
    </div>
</div>
<div class="weui-btn-area">
    <a class="weui-btn weui-btn_primary" href="uploadtask" style="display: none" >上传作业</a>
    <%--<a class="weui-btn weui-btn_primary" href="checkZuoyeList" id="showTooltips">成绩查询</a>--%>
</div>
</body>
</html>
