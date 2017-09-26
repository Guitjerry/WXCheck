<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改角色信息</h4>
    </div>
    <div class="modal-body">
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon1">角色名称</span>
            <input type="text" class="form-control" name="name" id="name" placeholder="请输入角色名称" aria-describedby="basic-addon1" value="${role.name}">
        </div>

        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon2">角色编码</span>
            <input type="text" class="form-control" name="code" id="code" placeholder="请输入角色编码" aria-describedby="basic-addon2" value="${role.code}">
        </div>

    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="saveRole()">保存</button>
    </div>


<script>

</script>
