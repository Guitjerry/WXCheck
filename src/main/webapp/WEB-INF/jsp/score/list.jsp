<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="w" uri="http://javacrazyer.iteye.com/tags/pager" %>
<html>
<head>
    <%--<c:import url="../../common/pc/include.jsp"></c:import>--%>
    <title>成绩列表</title>
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
            <button class="btn btn-info "  id="button1" style="margin-top: 10px" >导出数据</button>
            <%--<a class="large blue button f-ml20 f-mt20" data-toggle="modal" data-target="#addModal" href="addStudent">新增成绩</a>--%>
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
                        <form id="formSearch" class="form-horizontal" action="list">
                            <div class="form-group" style="margin-top:15px">
                                <label class="control-label col-sm-1" class="name" for="txt_search_account">学生名称</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="txt_search_account" name="name" value="${name}">
                                </div>
                                <label class="control-label col-sm-1 studentcode"  for="studentcode">学生编码</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="studentcode" name="studentcode" value="${studentcode}">
                                </div>

                                <label class="control-label col-sm-1 schoolclass"  for="studentcode">班级</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="schoolclass" name="schoolclass" value="${schoolclass}">
                                </div>

                                <div class="col-sm-3" style="text-align:left;">
                                    <button type="submit" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                                </div>
                                <input name="msg" type="hidden" value="score">
                            </div>
                        </form>
                    </div>
                </div>







            </div>
            <table id="CheckResultTable" class="table table-bordered  table-hover  f-ml10" >
                <thead>
                <th data-valign="middle" data-align="center">考试名称</th>
                <th data-valign="middle" data-align="center">班级</th>
                <th data-valign="middle" data-align="center">姓名</th>
                <th data-valign="middle" data-align="center">编码</th>


                <th data-valign="middle" data-align="center">语文</th>
                <th data-valign="middle" data-align="center">数学</th>
                <th data-valign="middle" data-align="center">外语</th>
                <th data-valign="middle" data-align="center">物理</th>
                <th data-valign="middle" data-align="center">化学</th>
                <th data-valign="middle" data-align="center">生物</th>
                <th data-valign="middle" data-align="center">地理</th>
                <th data-valign="middle" data-align="center">历史</th>
                <th data-valign="middle" data-align="center">思想</th>
                <th data-valign="middle" data-align="center">总分</th>
                <th data-valign="middle" data-align="center">操作</th>

                <%--<th data-valign="middle" data-align="center">性别</th>--%>
                <%--<th>操作</th>--%>
                </thead>
                <tbody>
                <c:forEach items="${tmUserScoreList}" var="score">
                    <tr>

                        <td>${score.schoolTest}</td>
                        <td>${score.schoolClass}</td>
                        <td>${score.name}</td>
                        <td>${score.studentcode}</td>

                        <td>${score.yuwen}</td>
                        <td>${score.shuxue}</td>
                        <td>${score.waiyu}</td>
                        <td>${score.wuli}</td>
                        <td>${score.huaxue}</td>
                        <td>${score.shengwu}</td>
                        <td>${score.dili}</td>
                        <td>${score.lishi}</td>
                        <td>${score.shixiang}</td>
                        <td>${score.sumCount}</td>
                            <%--<td>${user.sex}</td>--%>
                        <td><button class="btn" onclick="delscore(${score.id})">删除</button></td>


                        <%--<td>--%>
                            <%--<a class="large green button f-mr20 myModel" data-toggle="modal" data-target="#editModal" href="editStudent?studentid=${student.id}">修改</a>--%>
                            <%--&lt;%&ndash;<a class="large orange button f-mr20" data-toggle="modal" onclick="delStudent(${student.id})">删除</a>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<a class="large blue button f-mr20 myModel" data-toggle="modal" data-target="#fpeditModal" href="fpRole?userid=${student.id}">分配班级</a>&ndash;%&gt;--%>
                        <%--</td>--%>
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

<script>

    $(function () {
        $("#button1").click(function(){
            $("#CheckResultTable").table2excel({
                // exclude CSS class
                exclude: ".noExl",
                name: "Worksheet Name",
                filename: "成绩信息" //do not include extension
            });
        });
    })

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

    function  delscore(scoreid) {
        var r= confirm("你确定要删除该学生成绩吗?");
        if(r){
            $.ajax({
                url:"delscore?scoreid="+scoreid,
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