var rootPath = getRootPath();
var jqueryurl = rootPath+"/js/jquery.js";
var headerurl = rootPath+"/js/header.js";
var bootstrapurl = rootPath+"/plugins/bootstrap/js/bootstrap.js";
var bootstraptableurl = rootPath+"/plugins/boostrap-table/bootstrap-table.js";
var bootstraptableznurl = rootPath+"/plugins/boostrap-table/locale/bootstrap-table-zh-CN.js";
document.writeln( '<script type="text/javascript" src='+jqueryurl+'></script>');
document.writeln( '<script type="text/javascript" src='+headerurl+'></script>');
document.writeln( '<script type="text/javascript" src='+bootstrapurl+'></script>');
document.writeln( '<script type="text/javascript" src='+bootstraptableurl+'></script>');
document.writeln( '<script type="text/javascript" src='+bootstraptableznurl+'></script>');