<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>

    </title>
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
            width: 80%;
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

           margin-left: 20px;
           width: 20%;
           height: 38px;
           line-height: 38px;
       }
        .clear{
            float: none!important;
        }

    </style>

</head>
<body>

<div class="container-fluid">
    <c:import url="../../../common/include.jsp"></c:import>
    <div class="row">
        <c:import url="../../../common/header.jsp"></c:import>
    </div>
    <div class="row">
        <div class="col-md-2">
            <c:import url="../../../common/leftcommon.jsp"></c:import>
        </div>
        <div class="col-md-10">
            <div class=" ">
                <div class="banji">【第一步】 选择班级</div>
                <div class="banjilist chooselist">
                    <c:forEach items="${tmBanJiList}" var="banji">
                         <span class="single selectbanji" banjiid="${banji.ID}">
                                 ${banji.name}
                         </span>
                    </c:forEach>
                </div>
            </div>



            <div class=" mykemu f-none">
                <div class="banji">【第二步】 选择科目</div>
                <div class="kemuList chooselist">
                </div>
            </div>


            <div class=" selectzuoye f-none">
                <div class="banji" >【第三步】 布置作业</div>
                <div class="chooselist">
                    <textarea id="editor_id" style="width: 80%"></textarea>
                    </textarea>
                </div>
            </div>



            <div><a class="large green button f-mr20 savetbtn f-none" style="width: 50%;text-align: center;margin-left: 200px" onclick="savezuoye()">提交</a></div>
        </div>
    </div>
</div>


</body>
</html>
<script>

    KindEditor.ready(function(K) {
        window.editor = K.create('textarea', {
            allowFileManager : true,
            langType : 'zh-CN',
            autoHeightMode : true
        });
        editor = K.create('#editor_id', {
        });
    })
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
                    kemuhtml += '<span class="single selectkemu"'+' onclick="showzuoye(this)"'+ 'kemuid='+datas[i].id+'>'+datas[i].name+'</span>';
                }
                $('.kemuList').html("").append(kemuhtml);
            }
        })
        $('.mykemu').removeClass('f-none');
    })

    function showzuoye(obj) {
        var target = $(obj);
        target.addClass('choosespan');
        $('.selectzuoye').removeClass('f-none');
        $('.savetbtn').removeClass('f-none');
    }
    function savezuoye() {
        var banjiid;
        var kemuid;
        var task = editor.html();
        $('.selectbanji ').each(function () {
            if($(this).hasClass('choosespan')){
                banjiid = $(this).attr('banjiid');
            }
        })
        $('.selectkemu  ').each(function () {
            if($(this).hasClass('choosespan')){
                kemuid = $(this).attr('kemuid');
            }
        })
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