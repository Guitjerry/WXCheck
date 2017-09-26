<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="addRoleSure" >
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增角色</h4>
    </div>
    <div class="modal-body">
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon1">角色名称</span>
            <input type="text" class="form-control" name="name" id="name" placeholder="请输入角色名称" aria-describedby="basic-addon1">
        </div>

        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon2">角色编码</span>
            <input type="text" class="form-control" name="code" id="code" placeholder="请输入角色编码" aria-describedby="basic-addon2">
        </div>

    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="saveRole()">保存</button>
    </div>
</form>

<script>
    function  saveRole() {
        var param={"name":$("#name").val(),"code":$("#code").val()};
        $.ajax({
            url:"addRoleSure",
            data:param,
            success:function (data) {
                var obj = eval('('+data+')')
                if(obj.status=="success"){
                    $("#addModal").modal({show:false});
                    toastrSuccessMessage(obj.msg,"信息提示");
                    setTimeout(function () {
                        location.reload();
                    },1000)

                }
            }
        });
    }

</script>
