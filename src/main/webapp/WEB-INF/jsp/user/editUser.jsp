<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
</div>
<div class="modal-body">
    <div class="input-group f-mb10 f-pd5">
        <span class="input-group-addon" id="basic-addon1">登录名称</span>
        <input type="text" class="form-control" name="editaccount" id="editaccount" placeholder="请输入登录名" aria-describedby="basic-addon1" value="${user.account}">
    </div>
    <div class="input-group f-mb10 f-pd5">
        <span class="input-group-addon" >登录密码</span>
        <input type="text" class="form-control" name="editpasswod" id="editpasswod" placeholder="请输入密码" aria-describedby="basic-addon1" value="${user.password}">
    </div>
    <div class="input-group f-mt10 f-pd5">
        <span class="input-group-addon" id="basic-addon2">用户名&nbsp&nbsp&nbsp&nbsp</span>
        <input type="text" class="form-control" name="editname" id="editname" placeholder="请输入用户名" aria-describedby="basic-addon2" value="${user.name}">
    </div>
    <div class="input-group f-mt10 f-pd5">
        <span class="input-group-addon" id="basic-addon3">登录邮箱</span>
        <input type="text" class="form-control" name="editemail" id="editemail" placeholder="请输入用户名" aria-describedby="basic-addon2" value="${user.email}">
    </div>
    <div class="input-group f-mt10 f-pd5">
        <span class="input-group-addon" id="basic-addon4">电话&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
        <input type="text" class="form-control" name="editphone" id="editphone" placeholder="请输入用户名" aria-describedby="basic-addon2" value="${user.phone}">
    </div>
    <div class="parentdiv input-group f-mt10 f-pd5" >
        <span class="input-group-addon" >状态&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
        <select class="form-control editstatus" name="editstatus" default-select="${user.status}" >
            <option value="0">有效</option>
            <option value="1">无效</option>
        </select>
    </div>

</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="button" class="btn btn-primary" onclick="editUser(${user.id})">保存</button>
</div>


<script>
    $(function () {
        //选中菜单级别
        $(".editstatus option").each(function () {

            if($(this).val()== $('.editstatus').attr("default-select")){

                $(this).attr("selected","selected");
            }
        })
    })
    function  editUser(userid) {
        var param={"account":$("#editaccount").val(),"password":$('#editpasswod').val(),"name":$("#editname").val(),"email":$("#editemail").val(),"phone":$('#editphone').val(),"id":userid,"status":$('.editstatus').val()};
        $.ajax({
            url:"editUserSure",
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

</script>
