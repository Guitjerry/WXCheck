<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增用户</h4>
    </div>
    <div class="modal-body">
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon1">登录名称</span>
            <input type="text" class="form-control" name="addaccount" id="addaccount" placeholder="请输入登录名" required aria-describedby="basic-addon1">
        </div>
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" >登录密码</span>
            <input type="text" class="form-control" name="addpasswod" id="addpasswod" placeholder="请输入密码" aria-describedby="basic-addon1">
        </div>
        <%--<div class="input-group f-mb10 f-pd5">--%>
            <%--<span class="input-group-addon" >重复确认密码</span>--%>
            <%--<input type="text" class="form-control" name="addpasswodsame" id="addpasswodsame" placeholder="请重复确认密码" aria-describedby="basic-addon1">--%>
        <%--</div>--%>
        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon2">用户名&nbsp&nbsp&nbsp&nbsp</span>
            <input type="text" class="form-control" name="addname" id="addname" placeholder="请输入用户名" aria-describedby="basic-addon2">
        </div>
        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon3">登录邮箱</span>
            <input type="text" class="form-control" name="addemail" id="addemail" placeholder="请输入email" aria-describedby="basic-addon2">
        </div>
        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon4">电话&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
            <input type="text" class="form-control" name="addphone" id="addphone" placeholder="请输入电话" aria-describedby="basic-addon2">
        </div>
        <div class="parentdiv input-group f-mt10 f-pd5" >
            <span class="input-group-addon" >状态&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
            <select class="form-control addstatus" name="addstatus"  >
                <option value="0">有效</option>
                <option value="1">无效</option>
            </select>

        </div>
    </div>


    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="saveUser()">保存</button>
    </div>


<script>
    function  saveUser() {


        var param={"account":$("#addaccount").val(),"password":$('#addpasswod').val(),"name":$("#addname").val(),"email":$("#addemail").val(),"phone":$('#addphone').val(),"status":$('.addstatus').val()};
        $.ajax({
            url:"addUserSure",
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
