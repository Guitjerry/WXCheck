<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .resourcediv{
        background: #c9c9c9;
        text-align: center;
        padding: 8px!important;
        color: #fff;
        margin-left: 10px;
        margin-right: 10px;
        margin-top: 10px;
    }
    .resourcediv:hover{
        background:#f0ad4e;;
        cursor: pointer;
    }
    .clear{
        float: none;
    }
    .selectdiv{
        background: #f0ad4e;;
    }
</style>
<input type="hidden" name="roleid" id="roleid" value="${roleid}">
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">分配资源</h4>
</div>
<div class="modal-body">
    <c:forEach items="${resources}" var="resource">
        <div class="resourcediv
            <c:forEach items="${selectresource}" var="sresource">
                 <c:if test="${sresource.resourceid==resource.resourceid}">selectdiv</c:if>
            </c:forEach> "
             resourceid="${resource.resourceid}">${resource.name}[${resource.parentname}]</div>

    </c:forEach>

</div>
<div class="clear"></div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="button" class="btn btn-primary" onclick="saveRoleAndResource()">保存</button>
</div>
<script>
    $(function () {

        $('.resourcediv').on("click",function () {
            if($(this).hasClass('selectdiv')){
                $(this).removeClass('selectdiv');
            }else{
                $(this).addClass("selectdiv");
            }

        })
    })
    function  saveRoleAndResource() {
        var resourceids = [];
        var roleid = $('#roleid').val();
        $('.resourcediv').each(function () {
            if($(this).hasClass('selectdiv')){
                resourceids.push($(this).attr('resourceid'));
            }
        })
        if(resourceids==null||resourceids.length==0){
            toastrErrorMessage("至少需要选择一个资源","信息提示");
            return;
        }
        $.ajax({
            url:rootPath+"/roleToResource/add",
            data:{"roleid":roleid,"resourceids":resourceids},
            success:function (data) {
                var obj = eval('('+data+')')
                if(obj.status=="success"){
                    $("#fpeditModal").modal({show:false});
                    toastrSuccessMessage(obj.msg,"信息提示");
                    setTimeout(function () {
                        location.reload();
                    },1000)

                }else{
                    toastrErrorMessage(obj.msg,"信息提示");
                }
            }
        })
    }
</script>