<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .clear{
        float: none;
    }
    .selectdiv{
        background: #f0ad4e;;
    }
   .chooselist{
       margin-bottom: 20px;
   }
   .banji{
       background: #c9a266;
       text-align: center;
       padding: 8px!important;
       color: #fff;
       margin-top: 10px;
       width: 100%;
   }

</style>
<input type="hidden" name="useridtmp" id="useridtmp" value="${userid}">
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">已分配科目【${bindKemu}】</h4>
</div>

<c:if test="${noclass!=null}">
    <div class="modal-body">请先分配班级</div>
</c:if>
<c:if test="${noclass==null}">
    <div class="modal-body ">
        <div class="banji">【第一步】 选择班级</div>
        <div class="chooselist ">
            <ul class="list-group banjiul f-mt10">
                <c:forEach items="${tmBanJis}" var="banji">
                    <li class="list-group-item" banjiid="${banji.ID}">${banji.name}</li>
                </c:forEach>

            </ul>
        </div>
        <div class="chooselist kemudiv " style="display: none">
            <div class="banji">【第二步】 选择科目</div>
            <ul class="list-group kemuul f-mt10">
                <c:forEach items="${tmKemus}" var="kemu">
                    <li class="list-group-item" kemuid="${kemu.id}">${kemu.name}</li>
                </c:forEach>

            </ul>
        </div>

    </div>
    <div class="clear"></div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="saveKemuAndUser()">保存</button>
    </div>
</c:if>

<script>
    $(function () {
        $('.banjiul li').on("click",function () {
            $(this).addClass('selectdiv');
            $(this).siblings("li").removeClass('selectdiv');
            $('.kemudiv').show();
        })
        $('.kemuul li').on("click",function () {
            $(this).addClass('selectdiv');
            $(this).siblings("li").removeClass('selectdiv');
        })
    })
    function  saveKemuAndUser() {
        var kemuid;
        var banjiid;
        var userid = $('#useridtmp').val();
        $('.kemuul li').each(function () {
            if($(this).hasClass('selectdiv')){
                kemuid = $(this).attr('kemuid');
            }
        })
        $('.banjiul li').each(function () {
            if($(this).hasClass('selectdiv')){
                banjiid = $(this).attr('banjiid');
            }
        })
        if(banjiid==null){
            toastrErrorMessage("至少需要选择一个班级","信息提示");
            return;
        }
        if(kemuid==null){
            toastrErrorMessage("至少需要选择一个科目","信息提示");
            return;
        }
        $.ajax({
            url:rootPath+"/user/userToKemu",
            data:{"userid":userid,"kemuid":kemuid,"banjiid":banjiid},
            success:function (data) {
                var obj = eval('('+data+')')
                if(obj.status=="success"){
                    $("#fpKemuEditModal").modal({show:false});
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