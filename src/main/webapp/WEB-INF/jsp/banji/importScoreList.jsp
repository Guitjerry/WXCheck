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
            <!--右侧内容-->
            <div style="background: #fffcfa">
                <table class="table table-bordered  table-hover f-mt10">
                    <thead>
                    <th colspan="6" class="info">导入结果反馈</th>
                    </thead>
                    <thead class="success">
                    <th>学生名称</th>
                    <%--<th>学生编码</th>--%>
                    <th>学生班级</th>
                    <th>学生分数</th>
                    <th>学生科目</th>
                    <th>导入结果</th>
                    </thead>
                    <tbody>

                    <c:forEach items="${ttScorceImportVos}" var="scoreImport">
                        <tr>
                            <td>${scoreImport.name}</td>
                            <%--<td>${scoreImport.studentcode}</td>--%>
                            <td>${scoreImport.schoolclass}</td>
                            <td>${scoreImport.score}</td>
                            <td>${scoreImport.kemu}</td>
                            <td>${scoreImport.note}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>


</div>