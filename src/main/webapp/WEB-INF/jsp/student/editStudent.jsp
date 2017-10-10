<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="editStudentForm">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改学生信息</h4>
    </div>
    <div class="modal-body">
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon1">学生姓名<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="editname" requierd="yes"  tip="学生名称不能为空"  id="editname" placeholder="请输入学生姓名" aria-describedby="basic-addon1" value="${student.name}">
        </div>
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" >学生编码<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="editcode" id="editcode" regex="^[0-9]*$" regextip="学生编码格式不正确" requierd="yes"   tip="学生编码不能为空" placeholder="请输入学生编码" aria-describedby="basic-addon1" value="${student.usercode}">
        </div>
        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon2">学生班级<icon class="icon-red">*</icon></span>
            <select name="banji" id="banji" style="width: 478px;height: 30px"  requierd="yes"   tip="学生班级不能为空" >
                <option value="">---请选择----</option>
                <c:forEach items="${tmBanJis}" var="tmbanji">
                    <option value="${tmbanji.ID}">${tmbanji.name}</option>
                </c:forEach>
                <option></option>
            </select>
            <%--<input type="text" class="form-control" name="editname" id="editname" placeholder="请输入用户名" aria-describedby="basic-addon2" value="${user.name}">--%>
        </div>
        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon3">学生手机</span>
            <input type="text" class="form-control" name="editphone" id="editphone" placeholder="请输入学生手机" aria-describedby="basic-addon2" value="${student.phone}">
        </div>
        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon4">学生年龄</span>
            <input type="text" class="form-control" name="editage" id="editage" placeholder="请输入学生年龄" regex="^[0-9]{1,2}$" regextip="输入年龄不正确" aria-describedby="basic-addon2" value="${student.age}">
        </div>

    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="editStudent(${student.id})">保存</button>

        <input type="hidden" value="${student.banjiid}" name="banjiid" id="banjiid">
    </div>
</form>


<script>
    $(function () {
        $('#banji').val($('#banjiid').val());
    })
    function  editStudent(studentid) {
        if(validform($('#editStudentForm'))){
            var param={"id":studentid,"name":$("#editname").val(),"usercode":$('#editcode').val(),"phone":$("#editphone").val(),"age":$("#editage").val(),"banjiid":$("#banji").val()};
            $.ajax({
                url:"editStudentSure",
                data:param,
                success:function (data) {
                    var obj = eval('('+data+')')
                    if(obj.status=="success"){
                        $("#editModal").modal({show:false});
                        toastrSuccessMessage(obj.msg,"信息提示");
                        setTimeout(function () {
                            //location.reload();
                        },1000)

                    }
                }
            });
        }

    }




</script>
