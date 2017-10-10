<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
   .rolediv{
        background: #c9c9c9;
        text-align: center;
        padding: 8px!important;
        color: #fff;
        margin-left: 10px;
        margin-right: 10px;
        margin-top: 10px;
    }
    .rolediv:hover{
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
<input type="hidden" name="userid" id="userid" value="${userid}">
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">分配角色</h4>
</div>
<div class="modal-body">
    <c:forEach items="${roles}" var="role">
        <div class="rolediv
            <c:forEach items="${selectrole}" var="srole">
                 <c:if test="${role.id==srole.roleid}">selectdiv</c:if>
            </c:forEach> "
             roleid="${role.id}">${role.name}</div>

    </c:forEach>

</div>
<div class="clear"></div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="button" class="btn btn-primary" onclick="saveRoleAndUser()">保存</button>
</div>
<script>
    $(function () {

        $('.rolediv').on("click",function () {
            if($(this).hasClass('selectdiv')){
                $(this).removeClass('selectdiv');
            }else{
                $(this).addClass("selectdiv");
            }

        })
    })
    function  saveRoleAndUser() {
        var roleids = [];
        var userid = $('#userid').val();
        $('.rolediv').each(function () {
            if($(this).hasClass('selectdiv')){
                roleids.push($(this).attr('roleid'));
            }
        })
        if(roleids==null||roleids.length==0){
            toastrErrorMessage("至少需要选择一个资源","信息提示");
            return;
        }
        $.ajax({
            url:rootPath+"/user/userToRole",
            data:{"userid":userid,"roleids":roleids},
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