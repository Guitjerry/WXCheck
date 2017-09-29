<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
            aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">分配学生</h4>
</div>
<input id="banjiid" type="hidden" name="banjiid" value="${banjiid}">
<div class="modal-body">

    <table class="table table-bordered  table-hover f-mt10">
        <thead class="info">
            <th>
                <button class="btn btn-info" onclick="getChecked('on')">全选</button>
                <button class="btn btn-danger" onclick="getChecked('off')">取消全选</button>
            </th>
            <th class="success">学生名称</th>
            <th class="success">学生编码</th>
            <th class="success">学生班级</th>
        </thead>
        <tbody>
            <c:forEach items="${tmStudents}" var="student">
                <tr>
                    <td><input type="checkbox" class="simplecheck" studentid="${student.id}"></td>
                    <td>${student.name}</td>
                    <td>${student.usercode}</td>
                    <td>${student.banjiname}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
<input id="fbanjiid" type="hidden" value="${banjiid}">
<div class="clear"></div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    <button type="button" class="btn btn-primary" onclick="studentToBanji()">分配</button>
</div>
<script>
    function getChecked(a){
        var x = document.getElementsByTagName('input');
        for (var i = 0; i < x.length; i++){
            switch(a){
                case 'on':
                    x[i].checked = true;
                    break;
                case 'off':
                    x[i].checked = false;
                    break;
            };
        };
    }
    function studentToBanji() {
        var studentids =new Array();
        var banjiid =$('#fbanjiid').val();
        $('.simplecheck').each(function () {
            if($(this).prop("checked")){
                studentids.push($(this).attr("studentid"));
            }
        })
        console.info(studentids);
        var params = {"studentids":studentids,"banjiid":banjiid};
        $.ajax({
            url:"banjiFp",
            traditional: true,//这里设置为true
            data:params,
            success:function (data) {
                var obj = eval('('+data+')')
                if(obj.status=="success"){
                    $("#fpNewStudenteditModal").modal({show:false});
                    toastrSuccessMessage(obj.msg,"信息提示");
                    setTimeout(function () {
                        location.reload();
                    },1000)

                }
            }
        })
        //var ids =
    }


</script>