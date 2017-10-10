<%@ page import="com.xiaoyuan.util.Const" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="addKemuForm">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增科目</h4>
    </div>
    <div class="modal-body">
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon1">科目名称<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="addname" requierd="yes" tip="科目名称不能为空" id="addname" placeholder="请输入科目名称" aria-describedby="basic-addon1">
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="saveKemu()">保存</button>
    </div>
</form>

<script>

    function  saveKemu() {
        if(validform($('#addKemuForm'))){
            var param={"name":$("#addname").val()};
            $.ajax({
                url:"addKemuSure",
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

    }

</script>
