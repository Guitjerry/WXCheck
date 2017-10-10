/**
 * 框架默认事件
 *
 * 接收参数
 *   role : 规则
 *
 *   data-target : 关联控制对象
 *
 *   data-id : 操作id
 *
 *   data-action : 操作动作
 *
 *   data-config ：配置参数,采用json格式，不支持嵌套
 *
 *   data-url : ajax请求地址
 *
 *   data-alert : 是否需要弹出框   true/false
 */

(function (object) {
    //支持的规则
    var _ROLES = {
        editForm: "editForm"

    };

    //外部方法
    object.role = {
        autoload: function () {
            // window.Util.showBox.init();
            // window.Util.datetimepicker.init();
            var roleSelector;

            for (i in _ROLES) {
                roleSelector = "[role*='_" + _ROLES[i] + "']";
                //
                // if ($(roleSelector).length > 0) {
                //     switch (_ROLES[i]) {
                //
                //
                //         case _ROLES.editForm:
                //             _func.initVidate(roleSelector);
                //
                //     }
                // }
            }
        }
    };

    //内部方法
    var _func = {
        // //验证绑定
        // initVidate: function (roleSelector) {
        //     var target = $(roleSelector);
        //     if (target.data('validate') === true) {	//如果需要验证
        //         // window.Util.validatetion.init(roleSelector);
        //     }
        // },

    };
})(window.Core = window.Core || {});


//自动加载
$(function () {
    window.Core.role.autoload();
});
