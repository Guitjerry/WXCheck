<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <form id="addStudentForm">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增学生</h4>
    </div>
    <div class="modal-body">
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon1">学生名称<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="addname"  id="addname" requierd="yes"  tip="学生名称不能为空" placeholder="请输入学生名称"  aria-describedby="basic-addon1">
        </div>
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" >学生编码<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="addcode" id="addcode" regex="^[0-9]*$" regextip="学生编码格式不正确" requierd="yes"   tip="学生编码不能为空" placeholder="请输入学生编码" aria-describedby="basic-addon1">
        </div>
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" >学生班级<icon class="icon-red">*</icon></span>
            <select name="banji" id="banji" style="width: 478px;height: 30px"  requierd="yes"   tip="学生班级不能为空">
                <option value="">--请选择--</option>
                <c:forEach items="${tmBanJis}" var="tmbanji">
                    <option value="${tmbanji.ID}">${tmbanji.name}</option>
                </c:forEach>
                <option></option>
            </select>
            <%--<input type="text" class="form-control" name="addbanji" id="addbanji" placeholder="请输入学生编码" aria-describedby="basic-addon1">--%>
        </div>
        <%--<div class="input-group f-mb10 f-pd5">--%>
        <%--<span class="input-group-addon" >重复确认密码</span>--%>
        <%--<input type="text" class="form-control" name="addpasswodsame" id="addpasswodsame" placeholder="请重复确认密码" aria-describedby="basic-addon1">--%>
        <%--</div>--%>
        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon2">学生手机</span>
            <input type="text" class="form-control" name="addphone" id="addphone" placeholder="请输入学生手机" regex="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$" regextip="手机格式不正确" aria-describedby="basic-addon2">
        </div>
        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" id="basic-addon3">学生年龄</span>
            <input type="text" class="form-control" name="addage" id="addage" regex="^[0-9]{1,2}$" regextip="输入年龄不正确" placeholder="请输入学生年龄" aria-describedby="basic-addon2">
        </div>
    </div>


    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="saveStudent()">保存</button>
    </div>


</form>
<script>


    /**
     *
     * @param error 错误元素位置
     * @param elementhtml 添加的提示信息
     */

    function  saveStudent() {
        if(validform($('#addStudentForm'))){
            var param={"name":$("#addname").val(),"usercode":$('#addcode').val(),"phone":$("#addphone").val(),"age":$("#addage").val(),"banjiid":$("#banji").val()};
            $.ajax({
                url: "addStudentSure",
                data: param,
                success: function (data) {
                    var obj = eval('(' + data + ')')
                    if (obj.status == "success") {
                        $("#addModal").modal({show: false});
                        toastrSuccessMessage(obj.msg, "信息提示");
                        setTimeout(function () {
                            location.reload();
                        }, 1000)

                    }

                }
            });
        }
    }


</script>
