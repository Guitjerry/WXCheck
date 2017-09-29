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
        <div class="col-md-10" style="background: #fffcfa" >

            <a class="large blue button f-ml20 f-mt20" data-toggle="modal" data-target="#addModal" href="addBanji">新增班级</a>
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
                        <form id="formSearch" class="form-horizontal">
                            <div class="form-group" style="margin-top:15px">
                                <label class="control-label col-sm-1" class="banjiname" for="txt_search_name">班级名称</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="txt_search_name" name="txt_search_name">
                                </div>

                            </div>
                        </form>
                    </div>
                </div>







            </div>
            <table id="tb_roles" data-toggle="table">
                <thead>
                <th data-valign="middle" data-align="center">班级名</th>
                <th data-valign="middle" data-align="center">年级</th>
                <th data-valign="middle" data-align="center">学生数</th>
                <th data-valign="middle" data-align="center">类别</th>
                <th>操作</th>
                </thead>
                <tbody>
                <c:forEach items="${tmBanJis}" var="banji">
                    <tr>
                        <td>${banji.name}</td>
                        <td>${banji.grade}</td>
                        <td>${banji.studentCount}</td>
                        <td>${banji.banjitype}</td>


                        <td>
                            <a class="large green button f-mr20 myModel" data-toggle="modal" data-target="#editModal" href="editBanji?banjiid=${banji.ID}">修改用户</a>
                            <a class="large orange button f-mr20" data-toggle="modal" onclick="delBanji(${banji.ID})">删除班级</a>
                            <a class="large  button f-mr20"  data-toggle="modal" data-target="#fpeditModal" href="fpKemu?banjiid=${banji.ID}">分配科目</a>
                            <a class="large  button f-mr20"  data-toggle="modal" data-target="#fpStudenteditModal" href="fpStudent?banjiid=${banji.ID}">学生导入</a>
                            <a class="large  button f-mr20"  data-toggle="modal" data-target="#fpNewStudenteditModal" href="fpStudentdiv?banjiid=${banji.ID}">学生分配</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
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
<div class="modal fade" id="fpeditModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>

<div class="modal fade" id="fpStudenteditModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="height: 500px" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>


<div class="modal fade" id="fpNewStudenteditModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="height: 500px" >
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
    $("#fpeditModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });
    $("#fpStudenteditModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });
    $("#fpNewStudenteditModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });
    function  delBanji(banjiid) {
        var r= confirm("你确定要删除该班级吗?");
        if(r){
            $.ajax({
                url:"deleteBanji?banjiid="+banjiid,
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