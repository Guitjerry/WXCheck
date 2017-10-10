<%@ page import="com.xiaoyuan.util.Const" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="editBanjiForm">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增班级</h4>
    </div>
    <div class="modal-body">
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon1">班级名称<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="editname" id="editname" placeholder="请输入班级名称" requierd="yes" tip="班级名称不能为空"  aria-describedby="basic-addon1" value=" ${banji.name}">
        </div>

        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" >班级年级</span>

            <select class="form-control editnianji" name="editnianji"  default-select="${banji.grade}">
                <option value="">---请选择-----</option>
                <c:forEach items="<%=Const.getNianjiArray()%>" var="os">
                    <option value="${os.code}">${os.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon3">班级人数</span>
            <input type="text" class="form-control" name="editStudentCount" id="editStudentCount" placeholder="请输入班级人数"  placeholder="请输入班级人数" requierd="yes" tip="班级人数不能为空" regex="^[0-9]{1,2}$" regextip="班级人数输入不正确" aria-describedby="basic-addon2" value="${banji.studentCount}" >
        </div>
        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon4">班级类别</span>
            <select class="form-control editbanjitype" name="editbanjitype" requierd="yes" tip="班级类别不能为空"  default-select="${banji.banjitype}" >
                <option value="">---请选择-----</option>
                <c:forEach items="<%=Const.getBanjiTypeArray()%>" var="os">
                    <option value="${os.code}">${os.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="updateBanji(${banji.ID})">保存</button>
    </div>
</form>



<script>
    $(function () {
        //选中班级年级
        $(".editnianji option").each(function () {

            if($(this).val()== $('.editnianji').attr("default-select")){

                $(this).attr("selected","selected");
            }
        })
        //选择班级类别
        $(".editbanjitype option").each(function () {

            if($(this).val()== $('.editbanjitype').attr("default-select")){

                $(this).attr("selected","selected");
            }
        })
    })
    function  updateBanji(banjiid) {
        if(validform($('#editBanjiForm'))){
            var param={"ID":banjiid,"name":$("#editname").val(),"studentCount":$("#editStudentCount").val(),"grade":$(".editnianji").val(),"banjitype":$('.editbanjitype').val()};
            $.ajax({
                url:"editBanjiSure",
                data:param,
                success:function (data) {
                    var obj = eval('('+data+')')
                    if(obj.status=="success"){
                        $("#editModal").modal({show:false});
                        toastrSuccessMessage(obj.msg,"信息提示");
                        setTimeout(function () {
                            location.reload();
                        },3000)

                    }
                }
            });
        }
    }

</script>
