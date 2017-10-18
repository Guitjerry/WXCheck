<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">修改密码</h4>
</div>
<div class="modal-body">
    <div class="input-group f-mb10 f-pd5">
        <span class="input-group-addon" id="basic-addon1">原密码:&nbsp&nbsp&nbsp&nbsp</span>
        <input type="text" class="form-control" name="oldpassword" id="oldpassword" placeholder="请输入原密码" aria-describedby="basic-addon1">
    </div>

    <div class="input-group f-mt10 f-pd5">
        <span class="input-group-addon" id="basic-addon2">新密码:&nbsp&nbsp&nbsp&nbsp</span>
        <input type="text" class="form-control" name="newpassword" id="newpassword" placeholder="请输入新密码" aria-describedby="basic-addon2">
    </div>
    <div class="input-group f-mt10 f-pd5">
        <span class="input-group-addon" id="basic-addon3">确定密码:</span>
        <input type="text" class="form-control" name="surepassword" id="surepassword" placeholder="请再次输入密码" aria-describedby="basic-addon2">
    </div>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="button" class="btn btn-primary" onclick="resetPassword()">重置密码</button>
</div>
<script>
    function  resetPassword() {
        if($('#oldpassword').val()==""){
            toastrErrorMessage("原密码不能为空","错误提示");
            return;
        }
        if($('#newpassword').val()==""){
            toastrErrorMessage("新密码不能为空","错误提示");
            return;
        }
        if($('#surepassword').val()==""){
            toastrErrorMessage("请再次输入密码","错误提示");
            return;
        }
        if($('#newpassword').val()!=""&&$('#surepassword').val()!=""&&$('#newpassword').val()!=$('#surepassword').val()){
            toastrErrorMessage("二次密码输入不一致","错误提示");
            return;
        }
        var param = {"userid":$('#loginuserid').val(),"oldpassword":$('#oldpassword').val(),"newpassword":$('#newpassword').val()};
            $.ajax({
                url:rootPath+"/init/resetPasswordSure",
                data:param,
                success:function (data) {
                    var obj = eval('('+data+')')
                    if(obj.status=="success"){
                        $("#addModal").modal({show:false});
                        toastrSuccessMessage(obj.msg,"信息提示");
                        setTimeout(function () {
                           location.href=rootPath+"/init/logout";
                        },1000)

                    }else{
                        toastrErrorMessage(obj.msg,"信息提示");
                    }
                }
            })
    }
</script>
