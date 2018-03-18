<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="fileform" method="post" id="fileform" enctype="multipart/form-data" action="fpStudentScoreSure">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">1.成绩导入(下载的excel模板请另存为97-2003.xls)</h4>
        <%--<h4 class="modal-title"> 2.学生姓名存在相同的,相同的学生名成绩会被修改成一样</h4>--%>
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
        <th>班级</th>
        <th>年级</th>
        <th>考试名称</th>
        <th>学生姓名</th>
        <th>学生编码</th>
        <th>语文</th>
        <th>数学</th>
        <th>外语</th>
        <th>道德与法治(九年级为思想品德)</th>
        <th>物理</th>
        <th>化学</th>
        <th>历史</th>
        <th>地理</th>
        <th>生物</th>

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
                filename: "成绩导入模板" //do not include extension
            });
        });
    })
</script>
