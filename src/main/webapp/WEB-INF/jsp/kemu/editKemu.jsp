<%@ page import="com.xiaoyuan.util.Const" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">编辑科目</h4>
</div>
<div class="modal-body">
    <div class="input-group f-mb10 f-pd5">
        <span class="input-group-addon" id="basic-addon1">科目名称</span>
        <input type="text" class="form-control" name="editname" id="editname" placeholder="请输入科目名称" aria-describedby="basic-addon1" value=" ${tmkemu.name}">
    </div>


</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="button" class="btn btn-primary" onclick="updateKemu(${tmkemu.id})">保存</button>
</div>


<script>

    function  updateKemu(kemuid) {
        var param={"id":kemuid,"name":$("#editname").val()};
        $.ajax({
            url:"editKemuSure",
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
