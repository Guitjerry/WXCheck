<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>校园易购</title>
</head>
<body>

<input name="msg" value="${msg}" type="hidden">
<div class="container-fluid">
    <c:import url="../../../common/include.jsp"></c:import>
    <div class="row">
        <c:import url="../../../common/header.jsp"></c:import>
    </div>
    <div class="row">
        <div class="col-md-2 leftdiv">
        </div>

        <!--右侧内容 资源列表-->
        <!--右侧内容-->
        <div class="col-md-10" style="background: #fffcfa" >

            <a class="large blue button f-ml20 f-mt20" data-toggle="modal" data-target="#addModal" href="addResource">新增资源</a>


            <div class="panel-body" style="padding-bottom:0px;">
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

                <table id="tb_roles" class="table table-bordered">
                    <tr class="info">
                        <th>名称</th>
                        <th class="f-tac">菜单级别</th>
                        <th class="f-tac">图标</th>
                        <th class="f-tac">链接地址</th>
                        <th>操作</th>
                    </tr>
                    <tbody>
                    <c:forEach items="${resourcelist}" var="resource">
                        <tr >
                            <td parentid="${resource.id}" class="showtds" >${resource.name}<a onclick="showchildren(${resource.id})" class="f-ml10"><span class="glyphicon glyphicon-chevron-up f-ml10"></span></a></td>
                            <td class="f-tac">${resource.depth}</td>
                            <td class="f-tac">${resource.icon}</td>
                            <td class="f-tac">${resource.link}</td>
                            <td> <a class="large green button f-mr20 myModel" data-toggle="modal" data-target="#editModal" href="editResource?resourceid=${resource.id}">修改资源</a><c:if test="${resource.parentid==null}"><a class="large orange button f-mr20" data-toggle="modal" data-target="#addchildrenModel"  href="addChildrenResource?parentid=${resource.id}">新增二级资源</a></c:if></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>
<!-- 添加资源模态框-->
<div class="modal fade" id="addModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>
<!-- 修改模态框 -->
<div class="modal fade" id="editModal" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>


<!-- 修改子类模态框 -->
<div class="modal fade" id="editchildrenModel" class="editchildrenModel" tabindex="-1" role="dialog"  >
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>

<!-- 新增子类模态框 -->
<div class="modal fade" id="addchildrenModel" class="addchildrenModel" tabindex="-1" role="dialog"  >
    <div class="modal-dialog" role="document">
        <div class="modal-content">

        </div>
    </div>
</div>

</body>
</html>
<script>
    


    $(function () {
        $('.showtds').each(function () {
            showchildren($(this).attr('parentid'));
        })
    })
    function showchildren(parentid) {
        var appends = $('tr[parenttag='+parentid+']');
        if(appends.length>0){
            var singleappends =$(appends[0]);
            $(singleappends.prev('tr')).find('.glyphicon-chevron-down').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
            for(var j=0;j<appends.length;j++){
                $(appends[j]).remove();
            }
            return;
        }
        $.ajax({
            url: "listchildrenResource?parentid="+parentid,
            success:function (data) {
                var obj = eval("("+data+")");
                if(obj.status=="success"){
                    $('.showtds').each(function () {
                        var targetElement = $(this);
                        if(obj.entity.length<=0){
                            return;
                        }
                        if(obj.entity[0].parentid==targetElement.attr('parentid')){

                            targetElement.children('a').children('.glyphicon-chevron-up').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
                            var tds = obj.entity;
                            for(var i=0;i<tds.length;i++){
                                var nametd = "<td>"+"<span style='padding-left: 40px;color: #f1a325'>"+obj.entity[i].name+"</span></td>";
                                var depthtd = "<td class='f-tac'>"+"<span>"+obj.entity[i].depth+"</span></td>";
                                var icontd = "<td class='f-tac'>"+obj.entity[i].icon+"</td>";
                                var linktd = "<td class='f-tac'>"+obj.entity[i].link+"</td>";
                                var hrefs = "editChildrenResource?resourceid="+obj.entity[i].id+"&parentid="+obj.entity[i].parentid;
                                var btntd = "<td>"+"<a class='large green button f-mr20 editchildrenModel' data-toggle='modal' data-target='#editchildrenModel' href="+hrefs+">修改资源</a>"+"</td>";

//                                var opt = "<td>"+'<button type="button" title="新增三级类目" class="btn btn-danger" onclick="showchildrendiv('+obj.entity[i].id+','+"'"+obj.entity[i].name+"'"+')"> 新增三级类目</button>'+"</td>";
                                var newElement = $("<tr parenttag="+obj.entity[i].parentid+ ">"+nametd+depthtd+icontd+linktd+btntd+"</tr>");
                                var parent = targetElement.parent("tr").parent("tbody");
                                newElement.insertAfter(targetElement.parent("tr"));
                                //如果不是，则插入在目标元素的下一个兄弟节点 的前面。也就是目标元素的后面
                            }

                        }
                    })

                }

            }

        });
    }

</script>