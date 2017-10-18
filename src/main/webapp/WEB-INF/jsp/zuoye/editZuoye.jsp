<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">修改作业信息</h4>
</div>
<div class="modal-body">
    <div class="input-group f-mb10 f-pd5">
        <span class="input-group-addon" id="basic-addon1">作业科目<label class="icon-red">*</label></span>
        <input type="text" class="form-control" name="zuoyekemu"  aria-describedby="basic-addon1" value="${zuoye.kemuname}" disabled>
    </div>
    <div class="input-group f-mb10 f-pd5">
        <span class="input-group-addon" id="basic-addon2">作业班级<label class="icon-red">*</label></span>
        <input type="text" class="form-control" name="zuoyebanji"  aria-describedby="basic-addon1" value="${zuoye.banjiname}" disabled>
    </div>
    <div class="f-mb10 f-pd5">
        <div>作业内容:</div>
        <textarea id="editor_conent" style="width: 100%;height: 300px">${zuoye.task}</textarea>
    </div>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="button" class="btn btn-primary" onclick="editZuoyeSure(${zuoye.zuoyeid})">保存</button>

</div>
<script>
    function editZuoyeSure(zuoyeid) {
        $.ajax({
            url:"editZuoyeSure",
            data:{"task":$('#editor_conent').val(),"zuoyeid":zuoyeid},
            success:function (data) {
                var obj = eval('('+data+')')
                if(obj.status=="success"){
                    toastrSuccessMessage(obj.msg,"信息提示");
                    setTimeout(function () {
                        location.reload();
                    },1000)

                }
            }

        })
    }
</script>