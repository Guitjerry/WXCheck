<%@ page import="com.xiaoyuan.util.Const" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">新增班级</h4>
</div>
<div class="modal-body">
    <div class="input-group f-mb10 f-pd5">
        <span class="input-group-addon" id="basic-addon1">班级名称</span>
        <input type="text" class="form-control" name="addname" id="addname" placeholder="请输入班级名称" aria-describedby="basic-addon1">
    </div>

    <div class="input-group f-mt10 f-pd5">
        <span class="input-group-addon" >班级年级</span>

        <select class="form-control addnianji" name="addnianji"  >
            <option value="">---请选择-----</option>
            <c:forEach items="<%=Const.getNianjiArray()%>" var="os">
            <option value="${os.code}">${os.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="input-group f-mt10 f-pd5">
        <span class="input-group-addon" id="basic-addon3">班级人数</span>
        <input type="text" class="form-control" name="addStudentCount" id="addStudentCount" placeholder="请输入班级人数" aria-describedby="basic-addon2">
    </div>
    <div class="input-group f-mt10 f-pd5">
        <span class="input-group-addon" id="basic-addon4">班级类别</span>
        <select class="form-control addbanjitype" name="addbanjitype"  >
            <option value="">---请选择-----</option>
            <c:forEach items="<%=Const.getBanjiTypeArray()%>" var="os">
                <option value="${os.code}">${os.name}</option>
            </c:forEach>
        </select>
    </div>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="button" class="btn btn-primary" onclick="saveBanji()">保存</button>
</div>


<script>

    function  saveBanji() {
        var param={"name":$("#addname").val(),"studentCount":$("#addStudentCount").val(),"grade":$(".addnianji").val(),"banjitype":$('.addbanjitype').val(),"status":$('.addstatus').val()};
        $.ajax({
            url:"addBanjiSure",
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
