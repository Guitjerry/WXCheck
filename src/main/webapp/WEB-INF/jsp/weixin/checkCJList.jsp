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
    <title>微信成绩查询</title>
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
<div class="header">成绩列表</div>
<div class="weui-panel__bd">
    <c:forEach items="${tmUserScores}" var="score">
        <div class="weui-media-box weui-media-box_appmsg no_undeline" >

            <div class="weui-media-box__hd" style="width: auto!important;">
                <div class="title" >${score.schooltest}</div>
            </div>
            <div class="weui-media-box__bd" style="float: left">
                <p class="weui-media-box__desc" style="float: left;padding-left: 2rem">科目:${score.kemu}</p>
                <p class="weui-media-box__desc" style="padding-left: 2rem">班级:${score.schoolclass}</p>
                <p class="weui-media-box__desc" style="float: left;padding-left: 2rem">成绩:${score.schoolscore}</p>
                <p class="weui-media-box__desc" style="padding-left: 2rem">老师:${score.schoolteacher}</p>
            </div>
            <div style="border: 1px solid">
                <p  style="padding: 0.5rem">${score.scoretype}</p>
            </div>

        </div>
    </c:forEach>
</div>

</body>
</html>
<script>
</script>
