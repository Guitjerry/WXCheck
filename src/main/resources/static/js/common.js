
//js获取项目根路径
function getRootPath(){  
    var currentPath=window.document.location.href;  
    var pathName=window.document.location.pathname;  
    var pos=currentPath.indexOf(pathName);  
    var localhostPaht=currentPath.substring(0,pos);  
//    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
    return(localhostPaht);
}

//获取请求参数
function getQueryParamValue(key) {
	var uri = window.location.search;
	var reg = new RegExp("" + key + "=([^&?]*)", "ig");
	return (uri.match(reg)) ? (uri.match(reg)[0].substr(key.length + 1)) : null;
}

//空值转换
function emptyValConvert(val){
	if(val!=undefined && val!=''){
		return val;
	}else{
		return '';
	}
}

//配置值替换
function packageValReplace(val){
	if(val=='有'){
		return '●';
	}else if(val=='无'){
		return '-';
	}else if(val=='选配'){
		return '○';
	}else{
		return emptyValConvert(val);
	}
	
}


