<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .actived{
        background: orange;
        color: #fff!important;
    }
    .actived a{
        color: #fff!important;

    }
    .actived a:hover{
        cursor: pointer;
    }
</style>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- 导航头部 -->
        <div class="navbar-header">
            <!-- 品牌名称或logo -->
            <a class="navbar-brand">校园学生成绩作业考勤系统【欢迎你,<%=session.getAttribute("username")%>】</a>
        </div>
        <!-- 导航项目 -->
        <div class="collapse navbar-collapse navbar-collapse-example">
            <!-- 一般导航项目 -->
            <ul class="nav navbar-nav headernav">
                   <li style="margin-left:1000px"><a href="<%=request.getContextPath()%>/init/logout" class="logout">退出系统</a></li>
                   <li ><a  data-toggle="modal" data-target="#headerModal" href="<%=request.getContextPath()%>/init/resetPassword" class="resetPassword">修改密码</a></li>
                    <!--<li><a href="#">需求</a></li>-->
                    <!--<li><a href="#">需求</a></li>-->
                    <!--<li><a href="#">需求</a></li>-->
            </ul>
        </div><!-- END .navbar-collapse -->
    </div>
</nav>
<!-- Modal -->
<div class="modal fade" id="headerModal" class="headerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>
<script>
    $(function () {
        $('.logout').attr('href',rootPath+"/init/logout");
        $('.resetPassword').attr('href',rootPath+"/init/resetPassword");
    })
    $('.headernav li').on('click',function () {
            $(this).addClass('actived').siblings().removeClass('actived');
    })
</script>