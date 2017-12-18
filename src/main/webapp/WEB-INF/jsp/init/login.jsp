<%--
  Created by IntelliJ IDEA.
  User: jerry
  Date: 2017/3/1
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<%=request.getContextPath()%>/css/oa.css" rel="stylesheet">

<html>
<head>
    <c:import url="../../../common/include.jsp"></c:import>
    <title>校园易购</title>

</head>
<body>
<input type="hidden" value="<%=request.getContextPath() %>" id="baseuri">
<div class="top-content backimg">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>学校成绩作业考勤微信接入系统</strong></h1>

                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>系统登录</h3>
                            <p>请输入账号与密码:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form"  method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">账户名:</label>
                                <input type="text" name="account" placeholder=账户名 class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">密码:</label>
                                <input type="password" name="password" placeholder="密码" class="form-password form-control" id="form-password">
                            </div>
                            <button type="button" class="btn" onclick="login()">登录</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
</body>
</html>
<script>
    function login() {
        var account = $("input[name='account']").val();
        var password = $("input[name='password']").val();

        var param = {"account":account,"password":password}
        if(account==null){
            toastrErrorMessage("账户不能为空",'信息提示');
            return;
        }else if(password==null){
            toastrErrorMessage("密码不能为空",'信息提示');
            return;
        }
        $.ajax({
            type: "POST",
            url: "loginsure",
            data: param,
            success: function(data){
                var obj = eval("("+data+")");
                if(obj.status=='fail'){
                    toastrErrorMessage(obj.msg,'信息提示');
                }else if(obj.status=='success'){
                    toastrSuccessMessage(obj.msg,'信息提示');

                    location.href = $('#baseuri').val()+"/user/userList?msg=user";

                }
            }
        });
    }
</script>