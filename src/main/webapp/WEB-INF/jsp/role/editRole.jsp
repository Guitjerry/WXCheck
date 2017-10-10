<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="editRoleForm" >

    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改角色信息</h4>
    </div>
    <div class="modal-body">
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon1">角色名称<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="editname" id="editname" placeholder="请输入角色名称"  requierd="yes" tip="角色名称不能为空" aria-describedby="basic-addon1" value="${role.name}">
        </div>

        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon2">角色编码<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="editcode" id="editcode" placeholder="请输入角色编码" requierd="yes" tip="角色编码不能为空" aria-describedby="basic-addon2" value="${role.code}">
        </div>

    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="editRole(${role.id})">保存</button>
    </div>

</form>


<script>
    function editRole(roleid) {
        if(validform($('#editRoleForm'))){
            var param={"name":$("#editname").val(),"code":$("#editcode").val(),"id":roleid};
            $.ajax({
                url:"editRoleSure",
                data:param,
                success:function (data) {
                    var obj = eval('('+data+')')
                    if(obj.status=="success"){
                        $("#editModal").modal({show:false});
                        toastrSuccessMessage(obj.msg,"信息提示");
                        setTimeout(function () {
                            location.reload();
                        },1000)

                    }
                }
            });
        }


    }
</script>
