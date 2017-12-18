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

       <table class="table table-bordered">
           <thead>
                <th>名称</th>
                <th>语文</th>
                <th>数学</th>
                <th>外语</th>
                <th>物理</th>
                <th>化学</th>
                <th>历史</th>
                <th>生物</th>
                <th>地理</th>
                <th>思想</th>
                <th>班排名</th>
                <th>年级排名</th>
           </thead>
           <tbody>
           <c:forEach items="${tmUserScores}" var="score">
                <tr>
                    <td>
                       ${score.schoolTest}
                    </td>
                    <td>${score.yuwen}</td>
                    <td> ${score.shuxue}</td>
                    <td>${score.waiyu}</td>
                    <td> ${score.wuli}</td>
                    <td>  ${score.huaxue}</td>
                    <td>  ${score.lishi}</td>
                    <td>   ${score.shengwu}</td>
                    <td>  ${score.dili}</td>
                    <td>  ${score.shixiang}</td>
                    <td>  ${score.banjiindex}</td>
                    <td>   ${score.nianjiindex}</td>
                </tr>
           </c:forEach>
           </tbody>

       </table>

</div>

</body>
</html>
<script>
</script>
