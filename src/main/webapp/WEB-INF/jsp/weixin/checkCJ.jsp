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
<div class="header">学生成绩查询</div>
<div class="weui-cell">
    <div class="weui-cell__hd"><label class="weui-label">学生编号</label></div>
    <div class="weui-cell__bd">
        <input class="weui-input"  placeholder="请输入学生编号或者名称" id="usercode">
    </div>


</div>
<div class="weui-cell">
    <div class="weui-cell__hd"><label class="weui-label">登录密码</label></div>
    <div class="weui-cell__bd">
        <input class="weui-input"  placeholder="请输入密码" id="password" type="password">
    </div>
</div>
<div class="weui-btn-area">
    <a class="weui-btn weui-btn_primary" onclick="checkZuoyeList()"  id="showTooltips">查询</a>
</div>
</body>
</html>
<script>
    function checkZuoyeList(){
        if($('#usercode').val()==""||$('#usercode').val()==null){
            toastrErrorMessage("学生编号或者姓名不能为空");
            return;
        }
        if($('#password').val()==""||$('#password').val()==null){
            toastrErrorMessage("密码不能为空");
            return;
        }
        $.ajax({
            "url":"checkLogin",
            data:{"usercode":$('#usercode').val(),"password":$('#password').val()},
            success:function (data) {
                if(data.successmsg!=undefined&&data.successmsg!=''){
                    toastrSuccessMessage(data.successmsg);
                    setTimeout(function () {
                        location.href = "checkCJList?usercode="+$('#usercode').val();
                    },2000)

                }else{
                    toastrErrorMessage(data.errormsg);
                }

            }
        })

    }
</script>