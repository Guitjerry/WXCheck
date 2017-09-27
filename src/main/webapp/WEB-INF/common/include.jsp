<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<link href="../plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
<link href="../css/main.css" rel="stylesheet">
<link href="../css/leftmenu.css" rel="stylesheet">
<link href="../plugins/boostrap-table/bootstrap-table.css" rel="stylesheet">
<link href="../plugins/bootstrap-toastr/toastr.css" rel="stylesheet">
<link href="../plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet">
<link href="../plugins/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="../plugins/jquery-ztree/zTreeStyle.css" rel="stylesheet">
<link href="../plugins/bootstrap-fileinput/bootstrap-fileinput.css" rel="stylesheet">
<link href="../css/playground.css" rel="stylesheet">
<link href="stylesheet" href="<%=request.getContextPath()%>/plugins/kindeditor/themes/default/default.css" />
<link href="<%=request.getContextPath()%>/plugins/kindeditor/plugins/code/prettify.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/plugins/bootstrap-fileinput/bootstrap-fileinput.css" rel="stylesheet">


<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/leftMenu.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="../plugins/boostrap-table/bootstrap-table.js"></script>
<script type="text/javascript" src="../plugins/boostrap-table/locale/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="../plugins/bootstrap-toastr/toastr.js"></script>
<script type="text/javascript" src="../plugins/bootstrap-select/js/bootstrap-select.js"></script>
<script type="text/javascript" src="../plugins/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../plugins/bootstrap-confirmation/bootstrap-confirmation.js"></script>
<script type="text/javascript" src="../plugins/jquery-ztree/jquery.ztree.core.js"></script>
<script type="text/javascript" src="../plugins/jquery-ztree/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="../plugins/bootstrap-fileinput/bootstrap-fileinput.js"></script>
<script type="text/javascript" src="../plugins/bootstrap-fileinput/locales/zh.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/kindeditor/plugins/code/prettify.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/kindeditor/kindeditor.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/kindeditor/lang/zh-CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/bootstrap-fileinput/bootstrap-fileinput.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/bootstrap-fileinput/zh.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-fileinput/js/fileinput.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap-fileinput/js/fileinput_locale_zh.js"></script>
<script type="text/javascript" src="../js/rdcp.toastr.js"></script>
<input name="msg" class="selectmsg" value="${msg}" type="hidden">
<input type="hidden" id="userid" name="userid" value="<%=session.getAttribute("userid")%>">