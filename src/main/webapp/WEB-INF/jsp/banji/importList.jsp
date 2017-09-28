<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--<c:import url="../../common/pc/include.jsp"></c:import>--%>
    <title>校园易购</title>
</head>
<body>

<div class="container-fluid">
    <c:import url="../../../common/include.jsp"></c:import>
    <div class="row">
        <c:import url="../../../common/header.jsp"></c:import>
    </div>
    <div class="row">
        <div class="col-md-2 leftdiv">
        </div>

        <!--右侧内容-->
        <div class="col-md-10" style="background: #fffcfa">
            <div class="row">
                <div class="col-md-4">
                    <table class="table table-bordered  table-hover f-mt10">
                        <thead>
                            <th colspan="3" class="info">成功导入的数据【${insertcount}】</th>
                        </thead>
                        <thead class="success">
                            <th>学生名称</th>
                            <th>学生编码</th>
                            <th>学生班级</th>
                        </thead>
                        <tbody>

                        <c:forEach items="${insertStudents}" var="insertstudent">
                            <tr>
                                <td>${insertstudent.name}</td>
                                <td>${insertstudent.usercode}</td>
                                <td>${insertstudent.banjiname}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-4">
                    <table class="table table-bordered  table-hover f-mt10">
                        <thead class="info">
                        <th colspan="3" class="info">已经存在的数据【${samecount}】</th>
                        </thead>
                        <thead>
                        <th class="success">学生名称</th>
                        <th class="success">学生编码</th>
                        <th class="success">学生班级</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${sameStudents}" var="sameStudent">
                            <tr>
                                <td>${sameStudent.name}</td>
                                <td>${sameStudent.usercode}</td>
                                <td>${sameStudent.banjiname}</td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
                <div class="col-md-4">
                    <table class="table table-bordered  table-hover f-mt10">
                        <thead>
                        <th colspan="2" class="info">错误数据【${errorcount}】</th>
                        </thead>
                        <thead class="success">
                        <th>学生名称</th>
                        <th>学生编码</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${errorStudents}" var="errorStudent">
                            <tr>
                                <td>${errorStudent.name}</td>
                                <td>${errorStudent.usercode}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</div>