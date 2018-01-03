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

            <a class="large blue button f-ml5 f-mt20" data-toggle="modal" data-target="#addModal" href="addUser">新增用户</a>
            <!-- Modal -->
            <div class="modal fade" id="addModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                    </div>
                </div>
            </div>

            <div class="panel-body" style="padding-bottom:0px;padding-top: 10px;padding-left: 0px">
                <div class="panel panel-default">
                    <div class="panel-heading">查询条件</div>
                    <div class="panel-body">
                        <form id="formSearch" class="form-horizontal" action="userList">
                            <div class="form-group" style="margin-top:15px">
                                <label class="control-label col-sm-1" class="rolename" for="txt_search_account">登录名</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="txt_search_account" name="txt_search_account" value="${txt_search_account}">
                                </div>
                                <label class="control-label col-sm-1 rolecode"  for="txt_search_name">用户名</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="txt_search_name" name="txt_search_name" value="${txt_search_name}">
                                </div>
                                <label class="control-label col-sm-1 rolecode"  for="txt_search_phone">手机号</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="txt_search_phone" name="txt_search_phone" value="${txt_search_phone}">
                                </div>
                                <div class="col-sm-3" style="text-align:left;">
                                    <button type="submit" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                                    <input type="hidden" name="msg" id="msg" value="user">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>







                </div>
                <table id="tb_roles" class="table table-hover">
                    <thead>
                    <th data-valign="middle" data-align="center">登录名</th>
                    <th data-valign="middle" data-align="center">用户名</th>
                    <th data-valign="middle" data-align="center">电子邮件</th>
                    <th data-valign="middle" data-align="center">手机</th>
                    <%--<th data-valign="middle" data-align="center">状态</th>--%>
                    <th>操作</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${tmUsers}" var="user">
                        <tr>
                            <td>${user.account}</td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>${user.phone}</td>

                                <%--<td>--%>
                                    <%--<c:if test="${user.status==0}"> 有效 </c:if>--%>
                                    <%--<c:if test="${user.status==1}"> 无效 </c:if>--%>
                                <%--</td>--%>


                            <td>
                                <a class="large green button f-mr20 myModel" data-toggle="modal" data-target="#editModal" href="editUser?userid=${user.id}">修改用户</a>
                                 <a class="large orange button f-mr20" data-toggle="modal" onclick="delUser(${user.id})">删除用户</a>
                                <a class="large blue button f-mr20 myModel" data-toggle="modal" data-target="#fpeditModal" href="fpRole?userid=${user.id}">分配角色</a>

                                <a class="large blue button f-mr20 myModel" data-toggle="modal" data-target="#fpBanjiEditModal" href="fpbanji?userid=${user.id}" <c:if test="${admin==''||admin==null}">style="display: none"</c:if>>分配班级</a>
                                <a class="large blue button f-mr20 myModel" data-toggle="modal" data-target="#fpKemuEditModal" href="fpkemu?userid=${user.id}" <c:if test="${admin==''||admin==null}">style="display: none"</c:if> <c:if test="${user.code=='banzhuren'}">style="display: none"</c:if>>分配科目</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                 <w:pager pageNo="${pageNo}" recordCount="${counts}" pageSize="${pagesize}" url="userList"></w:pager>
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
<!-- 修改模态框 -->
<div class="modal fade" id="fpeditModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>

<!-- 分配班级模态框 -->
<div class="modal fade" id="fpBanjiEditModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>

<!-- 分配科目模态框 -->
<div class="modal fade" id="fpKemuEditModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
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
    $("#fpBanjiEditModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });
    $("#fpKemuEditModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });

    function  delUser(userid) {
        var r= confirm("你确定要删除该用户吗?");
        if(r){
            $.ajax({
                url:"deleteUser?userid="+userid,
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