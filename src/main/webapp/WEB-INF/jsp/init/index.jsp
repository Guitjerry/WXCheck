<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--<c:import url="../../common/pc/include.jsp"></c:import>--%>
    <title>校园易购</title>
</head>
<body>
<div class="container-fluid">
<c:import url="../../common/include.jsp"></c:import>
    <div class="row">
        <c:import url="../../common/header.jsp"></c:import>
    </div>
    <div class="row">
        <div class="col-md-2">
            <ul id="accordion" class="accordion">
                <c:forEach items="${leftmenus}" var="menu">
                    <li>
                        ${menu.parentdiv}
                        ${menu.childreli}
                    </li>
                </c:forEach>
            </ul>

        </div>

        <!--右侧内容-->
        <div class="col-md-10">

        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function() {
        var Accordion = function(el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;

            // Variables privadas
            var links = this.el.find('.link');
            // Evento
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
        }

        Accordion.prototype.dropdown = function(e) {
            var $el = e.data.el;
            $this = $(this),
                    $next = $this.next();

            $next.slideToggle();
            $this.parent().toggleClass('open');

            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
            };
        }

        var accordion = new Accordion($('#accordion'), false);

//        $('#maintable').bootstrapTable({
//            url: '/xiaoyuan/main/student',
//            method: 'get',                      //请求方式（*）
//            toolbar: '#toolbar',                //工具按钮用哪个容器
//            striped: true,                      //是否显示行间隔色
//            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
//            pagination: true,                   //是否显示分页（*）
//            sortable: false,                     //是否启用排序
//            sortOrder: "asc",                   //排序方式
//            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
//            pageNumber:1,                       //初始化加载第一页，默认第一页
//            pageSize: 5,                       //每页的记录行数（*）
//            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
//            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
//            strictSearch: true,
//            showColumns: true,                  //是否显示所有的列
//            showRefresh: true,                  //是否显示刷新按钮
//            minimumCountColumns: 2,             //最少允许的列数
//            clickToSelect: true,                //是否启用点击选中行
//            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
//            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
//            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
//            cardView: false,                    //是否显示详细视图
//            detailView: false,                   //是否显示父子表
//            columns: [{
//                field: 'id',
//                title: 'ID',
//
//                sortable : true,
//
//            }, {
//                field: 'name',
//                title: '姓名',
//
//                sortable : true,
//
//            },{
//                title: '操作',
//                formatter:operateFormatter
//            }]
//        });
    });
</script>