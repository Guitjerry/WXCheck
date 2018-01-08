<%@ page import="com.xiaoyuan.util.Const" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="addJilvChildForm">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增明细纪律</h4>
    </div>
    <div class="modal-body">
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon1">纪律名称<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="addname" requierd="yes" tip="纪律名称不能为空" id="addname" placeholder="请输入纪律名称" aria-describedby="basic-addon1">
        </div>
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon2">纪律类别</span>
            <select class="form-control JLId" name="JLId"  requierd="yes" tip="主纪律不能为空" >
                <option value="">----请选择----</option>
                <c:forEach items="${tmClassJiLvs}" var="os">
                    <option value="${os.id}">${os.name}</option>
                </c:forEach>
            </select>
        </div>

    </div>

    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="saveJilv()">保存</button>
    </div>
</form>

<script>

    function  saveJilv() {
        if(validform($('#addJilvChildForm'))){
            var param={"name":$("#addname").val(),"JLId":$(".JLId").val()};
            $.ajax({
                url:"addJilvChildSure",
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
