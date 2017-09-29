<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="fileform" method="post" id="fileform" enctype="multipart/form-data" action="/upload/uploadfile">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">分配学生</h4>
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
    </div>
</form>

