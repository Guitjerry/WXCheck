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

            <a class="large blue button f-ml20 f-mt20 f-mb10" data-toggle="modal" data-target="#addModal" href="addRole">新增角色</a>
            <!-- Modal -->
            <div class="modal fade" id="addModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                    </div>
                </div>
            </div>

            <%--<div class="panel-body" style="padding-bottom:0px;">--%>
                <%--<div class="panel panel-default">--%>
                    <%--<div class="panel-heading">查询条件</div>--%>
                    <%--<div class="panel-body">--%>
                        <%--<form id="formSearch" class="form-horizontal">--%>
                            <%--<div class="form-group" style="margin-top:15px">--%>
                                <%--<label class="control-label col-sm-1" class="rolename" for="txt_search_departmentname">名称</label>--%>
                                <%--<div class="col-sm-3">--%>
                                    <%--<input type="text" class="form-control" id="txt_search_departmentname">--%>
                                <%--</div>--%>
                                <%--<label class="control-label col-sm-1 rolecode"  for="txt_search_statu">编码</label>--%>
                                <%--<div class="col-sm-3">--%>
                                    <%--<input type="text" class="form-control" id="txt_search_statu">--%>
                                <%--</div>--%>
                                <%--<div class="col-sm-4" style="text-align:left;">--%>
                                    <%--<button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</form>--%>
                    <%--</div>--%>
                <%--</div>--%>







                <%--</div>--%>
                <table id="tb_roles" data-toggle="table">
                    <thead>
                        <th data-valign="middle" data-align="center">名称</th>
                        <th data-valign="middle" data-align="center">编码</th>
                        <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${roles}" var="role">
                            <tr>
                                <td>${role.name}</td>
                                <td>${role.code}</td>
                                <td> <a class="large green button f-mr20 myModel" data-toggle="modal" data-target="#editModal" href="editRole?roleid=${role.id}">修改角色</a><a class="large orange button f-mr20" data-toggle="modal" href="#">删除角色</a><a class="large  button f-mr20" data-toggle="modal" data-target="#fpeditModal" href="fpResource?roleid=${role.id}">分配资源</a></td>
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


!-- 修改模态框 -->
<div class="modal fade" id="fpeditModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
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
    $("#fpeditModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });

    /**
     * 每次清除数据
     */
    $("#addModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });
    //加载图标
    function loadicon() {
        if($('.bs-glyphicons').hasClass('f-none')){
            $('.bs-glyphicons').removeClass('f-none').addClass("f-block");
        }else{
            $('.bs-glyphicons').removeClass("f-block").addClass("f-none");
        }

    }
</script>