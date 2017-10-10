<%@ page import="com.xiaoyuan.util.Const" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:import url="../../common/include.jsp"></c:import>--%>
<form id="addChildResourceForm">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增二级资源</h4>
    </div>
    <div class="modal-body">
        <div class="input-group f-mb10 f-pd5">
            <span class="input-group-addon" id="basic-addon1">资源名称<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="childnname" id="childname" placeholder="请输入资源名称" requierd="yes" tip="资源名称不能为空" aria-describedby="basic-addon1" >
        </div>

        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" >菜单级别</span>

            <select class="form-control childdepth" name="childdepath"  readonly>
                <option value="2">二级菜单</option>
                <%--<c:forEach items="<%=Const.getDepthArray()%>" var="os">--%>
                <%--<option value="${os.code}">${os.name}</option>--%>
                <%--</c:forEach>--%>
            </select>
        </div>

        <div class="parentdiv input-group f-mt10 f-pd5 " >
            <span class="input-group-addon" >上级菜单</span>

            <select class="form-control childparentselect" name="childparentid"  readonly="true" >
                <option value="${resource.id}">${resource.name}</option>
            </select>
        </div>



        <div class="input-group f-mt10 f-pd5">
            <span class="input-group-addon" >链接地址<label class="icon-red">*</label></span>
            <input type="text" class="form-control" name="childlink" id="childlink" requierd="yes" tip="地址不能为空" placeholder="请输入链接地址">
        </div>

        <div class="input-group f-mt10 f-mb20 f-pd5">
            <span class="input-group-addon" >图标样式</span>
            <div class="btn btn-info f-ml20" style="width: 90%" onclick="loadicon()">选择图标</div>
            <input type="hidden" class="form-control" name="icon" id="icon" placeholder="图标样式" >
        </div>

        <!--图标选择-->
        <div id="editiconmodel"></div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="addChildrenSource()">保存</button>
    </div>
</form>


<script>
    $("#addchildrenModel").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });
    $(function () {

        $('#editiconmodel').load(rootPath+"/init/initicon", function () {
            $('.bs-glyphicons').addClass("f-none");


        });
        $('.bs-glyphicons-list li').each(function () {
            if($(this).children('.glyphicon-class').text()==icon){
                $(this).addClass('selecticon');
                $(this).children('.glyphicon-class').addClass('wfff');

            }

        })





    })
    //        //加载图标

    function loadicon() {

        if( $('.bs-glyphicons').hasClass('f-none')){
            $('.bs-glyphicons').removeClass('f-none').addClass("f-block");
        }else{
            $('.bs-glyphicons').removeClass("f-block").addClass("f-none");
        }


    }

    //更新资源信息
    function  addChildrenSource() {
        if(validform($('#addChildResourceForm'))){
            var depth = $('.childdepth').val();
            var param={"name":$("#childname").val(),"link":$("#childlink").val(),"depth":depth,"icon":$("#icon").val(),"parentid":$('.childparentselect').val()};
            $.ajax({
                url:"addChildrenResourceSure",
                data:param,
                success:function (data) {
                    var obj = eval('('+data+')')
                    if(obj.status=="success"){
                        $("#editchildrenModal").modal({show:false});
                        toastrSuccessMessage(obj.msg,"信息提示");
                        setTimeout(function () {
                            location.reload();
                        },1000)

                    }else{
                        toastrErrorMessage(obj.msg,"错误提示");
                        setTimeout(function () {
                            location.reload();
                        },1000)
                    }
                }
            });
        }

    }


</script>
