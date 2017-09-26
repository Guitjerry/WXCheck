<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="fileform" method="post"  id="fileform" enctype="multipart/form-data">
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">分配科目</h4>
</div>
<div class="modal-body">

        <input id="file-0" class="file" type="file" name="filename" multiple data-min-file-count="1">


    <br>

</div>
<div class="clear"></div>

</form>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button onclick="ajaxfileUploadwx()" class="btn btn-primary" >保存</button>
</div>

<script>
    $("#file-0").fileinput({
        'allowedFileExtensions' : ['XLS'],
        showUpload: false, //是否显示上传按钮
        language: 'zh', //设置语言  ,
        showRemove:true,
        dropZoneEnabled: false,
        showCaption: true,//是否显示标题
    });

    function  ajaxfileUploadwx(){
        var filename = $("#file").val();
//        if(filename==null||filename==undefined){
//            toastrErrorMessage("请上传XLS文件...","信息提示");
//            return;
//        }
//        fm.append('filename', filename);
        $.ajax({
            type: "POST",
            url:"/upload/uploadfile",
//            data:fm,
            enctype: 'multipart/form-data',
            success:function (data) {
                
            }

        })
    }

</script>

