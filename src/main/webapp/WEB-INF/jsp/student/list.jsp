<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="w" uri="http://javacrazyer.iteye.com/tags/pager" %>
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
            <%--<c:import url="../../common/leftcommon.jsp"></c:import>--%>
        </div>

        <!--右侧内容-->
        <div class="col-md-10" style="background: #fffcfa" >

            <a class="large blue button f-ml20 f-mt20" data-toggle="modal" data-target="#addModal" href="addStudent">新增学生</a>
            <!-- Modal -->
            <div class="modal fade" id="addModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                    </div>
                </div>
            </div>

            <div class="panel-body" style="padding-bottom:0px;">
                <div class="panel panel-default">
                    <div class="panel-heading">查询条件</div>
                    <div class="panel-body">
                        <form id="formSearch" class="form-horizontal" action="studentList">
                            <div class="form-group" style="margin-top:15px">
                                <label class="control-label col-sm-1" class="rolename" for="txt_search_account">名称</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="txt_search_account" name="txt_search_name" value="${txt_search_name}">
                                </div>
                                <label class="control-label col-sm-1 rolecode"  for="txt_search_name">编码</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="txt_search_name" name="usercode" value="${usercode}">
                                </div>
                                <div class="col-sm-4" style="text-align:left;">
                                    <button type="submit" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                                </div>
                                <input name="msg" type="hidden" value="student">
                            </div>
                        </form>
                    </div>
                </div>







            </div>
            <table id="tb_roles" class="table table-bordered  table-hover  f-ml10" >
                <thead>
                <th data-valign="middle" data-align="center">学生姓名</th>
                <th data-valign="middle" data-align="center">学生编码</th>
                <th data-valign="middle" data-align="center">学生班级</th>
                <th data-valign="middle" data-align="center">手机</th>
                <th data-valign="middle" data-align="center">年龄</th>
                <%--<th data-valign="middle" data-align="center">性别</th>--%>
                <th>操作</th>
                </thead>
                <tbody>
                <c:forEach items="${tmStudents}" var="student">
                    <tr>
                        <td>${student.name}</td>
                        <td>${student.usercode}</td>
                        <td>${student.banjiname}</td>
                        <td>${student.phone}</td>
                        <td>${student.age}</td>
                        <%--<td>${user.sex}</td>--%>



                        <td>
                            <a class="large green button f-mr20 myModel" data-toggle="modal" data-target="#editModal" href="editStudent?studentid=${student.id}">修改学生</a>
                            <a class="large orange button f-mr20" data-toggle="modal" onclick="delStudent(${student.id})">删除学生</a>
                            <%--<a class="large blue button f-mr20 myModel" data-toggle="modal" data-target="#fpeditModal" href="fpRole?userid=${student.id}">分配班级</a>--%>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

            <w:pager pageNo="${pageindex}" recordCount="${counts}" pageSize="${pagesize}" url="studentList"></w:pager>

            <%--当前页数 总共数量 一页显示多少条--%>

        </div>

    </div>

</div>


</body>
</html>

<!-- 修改模态框 -->
<div class="modal fade" id="editModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>

<script>



    /**
     * 每次清除数据
     */
    $("#editModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });
    /**
     * 每次清除数据
     */
    $("#addModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });

    function  delStudent(studentid) {
        var r= confirm("你确定要删除该学生吗?");
        if(r){
            $.ajax({
                url:"deleteStudent?studentid="+studentid,
                success:function (data) {
                    var obj = eval('('+data+')')
                    if(obj.status=="success"){
                        toastrSuccessMessage(obj.msg,"信息提示");
                        setTimeout(function () {
                            location.reload();
                        },1000)

                    }
                }
            })
        }

    }



</script>