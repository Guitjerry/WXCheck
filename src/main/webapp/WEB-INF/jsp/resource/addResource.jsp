<%@ page import="com.xiaoyuan.util.Const" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:import url="../../common/include.jsp"></c:import>--%>
<form id="addResourceForm">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增资源</h4>
    </div>
    <div class="modal-body">
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon1">资源名称<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="name" id="name" placeholder="请输入资源名称" requierd="yes" tip="资源名称不能为空" aria-describedby="basic-addon1">
        </div>

        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" >菜单级别<icon class="icon-red">*</icon></span>

            <select class="form-control depth" name="depath"  requierd="yes" tip="菜单级别不能为空">
                <option selected value="">--请选择---</option>
                <option value="1">一级菜单</option>
                <option value="2">二级菜单</option>
                <%--<c:forEach items="<%=Const.getDepthArray()%>" var="os">--%>
                <%--<option value="${os.code}">${os.name}</option>--%>
                <%--</c:forEach>--%>
            </select>
        </div>

        <div class="parentdiv input-group f-mt10 f-pd5 f-none" >
            <span class="input-group-addon" >上级菜单</span>

            <select class="form-control parentselect" name="parentid"  >
                <option value="">---------请选择——-----</option>
                <c:forEach items="${parentList}" var="parentResource">
                    <option value="${parentResource.id}">${parentResource.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" >链接地址</span>
            <input type="text" class="form-control" name="link" id="link" placeholder="请输入链接地址" >
        </div>

        <div class="input-group f-mt10 f-mb20 f-pd5">
            <span class="input-group-addon" >图标样式</span>
            <div class="btn btn-info f-ml20" style="width: 90%" onclick="loadicon()">选择图标</div>
            <input type="hidden" class="form-control" name="icon" id="icon" placeholder="图标样式" >
        </div>

        <!--图标选择-->
        <div id="iconmodel"></div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="saveSource()">保存</button>
    </div>

</form>

<script>

    $("#addModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });
    function  saveSource() {
        if(validform($('#addResourceForm'))){
            var depth = $('.depth').val();
            if(depth=="2"&&($('.parentselect').val()==""||$('.parentselect').val()==null)){
                toastrErrorMessage("请选择上级菜单");
                return;
            }
            var param={"name":$("#name").val(),"link":$("#link").val(),"depth":depth,"icon":$("#icon").val(),"parentid":$('.parentselect').val()};
            $.ajax({
                url:"addResourceSure",
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
    $(function () {
        //加载图标页面
        $('#iconmodel').load(rootPath+"/init/initicon",function () {
            $("#addModal").find('.bs-glyphicons').addClass("f-none");

        });

        //选中二级需要选中父级
        $(document).on('change','.depth',function () {
            if($(this).val()=="2"){
                $('.parentdiv').removeClass('f-none');
            }else{
                $('.parentdiv').addClass('f-none');


            }
        })
    })
    //加载图标
    function loadicon() {
        if($("#addModal").find('.bs-glyphicons').hasClass('f-none')){
            $("#addModal").find('.bs-glyphicons').removeClass('f-none').addClass("f-block");
        }else{
            $("#addModal").find('.bs-glyphicons').removeClass("f-block").addClass("f-none");
        }

    }

</script>
