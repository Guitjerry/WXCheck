<%@ page import="com.xiaoyuan.util.Const" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .jilvdiv ul li{
        /*display: none;*/
        width: 47%;
        float: left;
        padding: 5px;
        margin: 5px;
        background: rgba(45, 44, 65, 0.18);
        color: #fff;
        text-align: center;
        height: 30px;
    }
    .studentdiv ul li{
        /*display: none;*/
        width: 23%;
        float: left;
        padding: 5px;
        margin: 5px;
        background: rgba(45, 44, 65, 0.18);
        color: #fff;
        text-align: center;
        height: 30px;
    }
    .selectdiv{
        background: #f0ad4e!important;
    }
    .studentdiv ul li:hover{
        cursor: pointer;
    }
    .jilvdiv ul li:hover{
        cursor: pointer;
    }
    .choosediv{
        background: #c9a266;
        text-align: center;
        padding: 8px!important;
        color: #fff;
        margin-top: 10px;
        width: 100%;
    }
</style>
<form id="addClassJilvForm">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增违反纪律</h4>
    </div>



    <div class="modal-body contentbody">
        <div class="choosediv">【第一步】 选择学生</div>
        <div style="margin: 10px">

            学生名称<input type="text"  name="txt_search_name" class="txt_search_name">
            学生编码<input type="text"  name="usercode" class="usercode">
            <div class="btn" onclick="queryStudent()" style="background: #dddddd;color: #fff;padding: 5px">查询</div>
        </div>

        <div class="studentdiv">
            <ul>
                <c:forEach items="${tmStudents}" var="student">
                    <li class="studentli" studentId="${student.id}">${student.name}</li>
                </c:forEach>
            </ul>
        </div>
        <div style="clear:both;">

        </div>
        
        <div class="jilvmain" style="display: none;">
            <div class="choosediv" style="float: none!important;display: block">【第二步】 选择违反纪律</div>
            <div class="jilvdiv">
                <ul>
                    <c:forEach items="${tmClassJiLvChildList}" var="jilv">
                        <li class="jilvli" jilvId = ${jilv.id}>${jilv.name}【${jilv.parentname}】</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
       
        <div style="clear:both;">

        </div>

        <div class="contentmain" style="display: none">
            <div class="choosediv">【第三步】 填写相关内容</div>

            <div class="input-group f-mb10 f-pd5">
                <span class="input-group-addon" id="basic-addon3">发生课程<label class="icon-red">*</label></span>
                <input class="form-control" name="addkecheng" requierd="yes" tip="发生课程不能为空" id="addkecheng" placeholder="请输入发生课程【例子:2018年1月8号第三节语文课】" aria-describedby="basic-addon1"/>
            </div>
            <div class="input-group f-mb10 f-pd5">
                <span class="input-group-addon" id="basic-addon2">具体内容<label class="icon-red">*</label></span>
                <textarea class="form-control" name="addcontent" requierd="yes" tip="具体内容不能为空" id="addcontent" placeholder="请输入具体内容" aria-describedby="basic-addon1"/>
            </div>
        </div>


    </div>


    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="saveClassJilv()">保存</button>
    </div>
</form>

<script>
    $(function () {
        $('.studentli').on('click',function () {
            $(this).addClass('selectdiv').siblings('li').removeClass('selectdiv');
            $('.jilvmain').show();
        })
        $('.jilvli').on('click',function () {
            $(this).addClass('selectdiv').siblings('li').removeClass('selectdiv');
            $('.contentmain').show();
        })
    })
    function queryStudent() {
        var param = {txt_search_name:$('.txt_search_name').val(),usercode:$('.usercode').val()}
        $.ajax({
            url:"searchStudent",
            data:param,
            success:function (data) {
                var obj = eval('('+data+')');
                var students = obj.students;
                var listr="";
                for(var i in students){
                    listr += "<li class='studentli'" +"studentId="+students[i].id+">"+students[i].name+"</li>";
                }
                $('.studentdiv ul').html("").html(listr);
                $('.studentli').on('click',function () {
                    $(this).addClass('selectdiv').siblings('li').removeClass('selectdiv');
                    $('.jilvmain').show();


                })
            }
        });
    }
    //保存违反纪律
    function  saveClassJilv() {
        if(validform($('#addClassJilvForm'))){
            var studentId = "";
            var jilvId= "";
            //学生id
            $('.studentli').each(function () {
                if($(this).hasClass('selectdiv')){
                    studentId = $(this).attr('studentId');
                }
            })
            //纪律id
            $('.jilvli').each(function () {
                if($(this).hasClass('selectdiv')){
                    jilvId = $(this).attr('jilvId');
                }
            })
            var content = $('#addcontent').val();
            var kecheng = $('#addkecheng').val();

            var param={"content":content,"keCheng":kecheng,jvChildId:jilvId,studentId:studentId};
            $.ajax({
                url:"addStudentJilvSure",
                data:param,
                success:function (data) {
                    var obj = eval('('+data+')')
                    if(obj.status=="success"){
                        $("#addModal").modal({show:false});
                        toastrSuccessMessage(obj.msg,"信息提示");
                        setTimeout(function () {
                            location.reload();
                        },1000)

                    }
                }
            });
        }

    }

</script>
