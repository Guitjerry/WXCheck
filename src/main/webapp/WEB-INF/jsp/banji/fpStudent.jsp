<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="fileform" method="post" id="fileform" enctype="multipart/form-data" action="fpStudentSure">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">分配学生(下载的excel模板请另存为97-2003.xls)</h4>
    </div>
    <input id="banjiid" type="hidden" name="banjiid" value="${banjiid}">
    <div class="modal-body">

        <input id="file-0" class="file" type="file" name="filename" multiple data-min-file-count="1">


        <br>

    </div>
    <div class="clear"></div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit" class="btn btn-primary">上传</button>
        <button type="button" class="btn btn-info" id="button1">下载模板</button>
    </div>
    <table id="CheckResultTable" style="display: none">
        <thead>
            <th>学生编码</th>
            <th>学生名称</th>
        </thead>
        <tbody>

        </tbody>
    </table>
</form>
<script>
    $(function () {
        $("#button1").click(function(){
            $("#CheckResultTable").table2excel({
                // exclude CSS class
                exclude: ".noExl",
                name: "Worksheet Name",
                filename: "学生导入模板" //do not include extension
            });
        });
    })
</script>
