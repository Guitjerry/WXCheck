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

            <a class="large blue button f-ml20 f-mt20" data-toggle="modal" data-target="#addModal" href="addZuoye">布置作业</a>


            <div class="panel-body" style="padding-bottom:0px;">
                <div class="panel panel-default">
                    <div class="panel-heading">查询条件</div>
                    <div class="panel-body">
                        <form id="formSearch" class="form-horizontal" action="zuoyeList">
                            <div class="form-group" style="margin-top:15px">
                                <label class="control-label col-sm-1" class="rolename" for="txt_search_kemu">科目名称</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="txt_search_kemu" name="txt_search_kemu"  value="${txt_search_kemu}">
                                </div>
                                <label class="control-label col-sm-1 rolecode"  for="txt_search_banji">班级名称</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="txt_search_banji" name="txt_search_banji" value="${txt_search_banji}">
                                </div>
                                <div class="col-sm-4" style="text-align:left;">
                                    <button type="submit" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                                    <input type="hidden" name="msg" id="msg" value="index">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>







            </div>
            <table id="tb_roles" class="table table-bordered  table-hover  f-ml10">
                <thead>
                <th data-valign="middle" data-align="center">班级</th>
                <th data-valign="middle" data-align="center">科目</th>
                <th data-valign="middle" data-align="center">作业内容</th>
                <th>操作</th>
                </thead>
                <tbody>
                <c:forEach items="${zuoyeVos}" var="zuoye">
                    <tr>
                        <td>${zuoye.banjiname}</td>
                        <td>${zuoye.kemuname}</td>
                        <td>${zuoye.task}</td>

                        <td>
                            <a class="large green button f-mr20 myModel" data-toggle="modal" data-target="#editModal" href="editZuoye?zuoyeid=${zuoye.zuoyeid}">修改作业</a>
                            <a class="large orange button f-mr20" data-toggle="modal" onclick="delZuoye(${zuoye.zuoyeid})">删除作业</a>
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
<!-- Modal -->
<div class="modal fade" id="addModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
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

    function  delZuoye(zuoyeid) {
        var r= confirm("你确定要删除该作业吗?");
        if(r){
            $.ajax({
                url:"deleteZuoye?zuoyeid="+zuoyeid,
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