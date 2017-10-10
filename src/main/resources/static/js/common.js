var rootPath = getRootPath();
/**
 *
 * @param target 表单对象
 * @param targetelemnet 表单元素对象
 * @param tipmsg 提示信息
 */
function appendvalid(target, targetelemnet, tipmsg) {
    var tipdiv = $('<div  id="toast-container" class="toast-top-right" aria-live="polite" style="display: none">' +
        '<div  class="toast toast-error toastdiv" style="opacity: 0.866;">');
    targetelemnet = $(targetelemnet);
    if ($('.toastdiv').length <= 0) {
        target.append(tipdiv);
    }

    $('.toastdiv').append('<div class="toast-message">' + tipmsg + '</div>');
    $('.toastdiv').parent('.toast-top-right').show('slow');
    setTimeout(function () {
        $('.toastdiv').html("").parent('.toast-top-right').hide('slow');
    }, 3000)
}
/**
 * 验证表单
 * @param roleSelector 表单对象
 * @returns {boolean}
 */
function validform(roleSelector) {
    var target = $(roleSelector);
    var alltxt = target.serializeArray();//获取所有的子元素
    var flag = true;
    for (var i = 0; i < alltxt.length; i++) {
        var targetinput = $('input[name=' + '"' + alltxt[i].name + '"' + ']');
        var targetselect = $('select[name=' + '"' + alltxt[i].name + '"' + ']');
        if (target != undefined) {
            if (targetinput.attr("requierd") == "yes" && targetinput.val() == "") {
                appendvalid(target, targetinput, targetinput.attr('tip'));
                flag = false;

            }
            if (targetinput.attr('regix') != "" && targetinput.attr('regex') != undefined && targetinput.val() != "") {
                var regexp = targetinput.attr('regex');
                var regexptip = targetinput.attr('regextip');
                var re = new RegExp(regexp);
                var txt = targetinput.val();
                if (!re.test(txt)) {
                    appendvalid(target, targetinput, regexptip);
                    flag = false;
                }
            }
        }
        if (targetselect != undefined) {
            if (targetselect.attr("requierd") == "yes" && targetselect.val() == "") {
                appendvalid(target, targetselect,targetselect.attr('tip'));
                flag = false;
            }
        }
    }
    return flag;
}
function getRootPath() {
    var currentPath = window.document.location.href;
    var pathName = window.document.location.pathname;
    var pos = currentPath.indexOf(pathName);
    var localhostPaht = currentPath.substring(0, pos);
    return (localhostPaht + "/wxCheck");
}


//获取请求参数
function getQueryParamValue(key) {
    var uri = window.location.search;
    var reg = new RegExp("" + key + "=([^&?]*)", "ig");
    return (uri.match(reg)) ? (uri.match(reg)[0].substr(key.length + 1)) : null;
}

//空值转换
function emptyValConvert(val) {
    if (val != undefined && val != '') {
        return val;
    } else {
        return '';
    }
}

//配置值替换
function packageValReplace(val) {
    if (val == '有') {
        return '●';
    } else if (val == '无') {
        return '-';
    } else if (val == '选配') {
        return '○';
    } else {
        return emptyValConvert(val);
    }

}


