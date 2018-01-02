<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .choosespan{
        background: #ff9b6c !important;
    }
    .banji{
        background: #c9a266;
        text-align: center;
        padding: 8px!important;
        color: #fff;
        margin-top: 10px;
        width: 100%;
    }
    .chooselist{
        margin-top: 40px;
        margin-bottom: 40px;
    }
    .single{
        background: #c9c9c9;
        text-align: center;
        padding: 20px!important;
        color: #fff;

        margin: 5px;
        width: auto;
        height: 38px;
        line-height: 38px;
    }
    .clear{
        float: none!important;
    }

</style>


<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">布置作业</h4>
</div>
<div class="modal-body">
    <div class="container-fluid">

        <div class=" ">
            <div class="banji">【第一步】 选择班级</div>
            <div class="banjilist chooselist">
                <ul class="list-group">
                    <c:forEach items="${tmBanJiList}" var="banji">
                        <li  class="list-group-item selectbanji" banjiid="${banji.ID}">${banji.name}</li>
                    </c:forEach>
                </ul>


                <%--<c:forEach items="${tmBanJiList}" var="banji">--%>
                <%--<span class="single selectbanji" banjiid="${banji.ID}">--%>
                <%--${banji.name}--%>
                <%--</span>--%>
                <%--</c:forEach>--%>
            </div>
        </div>



        <div class=" mykemu f-none">
            <div class="banji">【第二步】 选择科目</div>
            <div class=" chooselist">
                <ul class="list-group kemuList">
                </ul>
            </div>
        </div>


        <div class=" selectzuoye f-none">
            <div class="banji" >【第三步】 布置作业</div>
            <div class="chooselist">
                <textarea id="editor_id" style="width: 100%;height: 300px"></textarea>
            </div>

        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            <button type="button" class="btn btn-primary" onclick="savezuoye()">提交</button>
        </div>


    </div>
</div>



<script>

    //    KindEditor.ready(function(K) {
    //        window.editor = K.create('textarea', {
    //            allowFileManager : true,
    //            langType : 'zh-CN',
    //            autoHeightMode : true
    //        });
    //        editor = K.create('#editor_id', {
    //        });
    //    })
    $('.selectbanji').on('click',function () {
        var banjiid = $(this).attr('banjiid');
        $(this).addClass('choosespan');
        $(this).siblings().removeClass('choosespan');
        $.ajax({
            url:"selectKemuByBanji?banjiid="+banjiid,
            success:function (data) {
                var datas = eval("("+data+")");
                var kemuhtml ="";
                for(var i=0;i<datas.length;i++){

                    kemuhtml += '<li  class="list-group-item selectkemu"'+' onclick="showzuoye(this)"'+ 'kemuid='+datas[i].id+'>'+datas[i].name+'</li>';
                }
                $('.kemuList').html("").append(kemuhtml);
            }
        })
        $('.mykemu').removeClass('f-none');
    })

    function showzuoye(obj) {
        var target = $(obj);
        target.addClass('choosespan');
        target.siblings().removeClass('choosespan');
        $('.selectzuoye').removeClass('f-none');
        $('.savetbtn').removeClass('f-none');
    }
    function savezuoye() {
        var banjiid;
        var kemuid;
        var task = $('#editor_id').val();
        $('.selectbanji ').each(function () {
            if($(this).hasClass('choosespan')){
                banjiid = $(this).attr('banjiid');
            }
        })
        $('.selectkemu').each(function () {
            if($(this).hasClass('choosespan')){
                kemuid = $(this).attr('kemuid');
            }
        });
        var param ={"banjiid":banjiid,"kemuid":kemuid,"task":task}
        $.ajax({
            url:"savezuoye",
            data:param,
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