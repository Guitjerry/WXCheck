/**
 * 公用工具类
 * @author
 */
(function(object){
    object.validatetion = {
        validator:null,
        init : function(selector){
            $(selector).each(function(){_func.validatetion($(this));});
        }
    };
    //内部方法
    var _func = {
        validatetion : function(selector){
            var form = $(selector);
            var flag =false;
            object.validatetion.validator = form.validate({
                // errorPlacement: function(error,elementhtml){		//用于自定义错误显示位置
                //     if(element.data('error')==='_myError'){
                //         error.addClass('myerror');
                //         error.appendTo(elementhtml);
                //     }else{
                //         error.appendTo(elementhtml);
                //     }
                // },
                // errorPlacement:{
                //   ""
                // },
                highlight: function(element, errorClass) {  //针对验证的表单设置高亮
                    // $(element).parents('div.form-group').children("div").addClass('has-error');
                    // $(element).css("display","inline");
                },success: function(element) {	//验证成功，去除元素错误框样式
                    // $(element).parents('div.has-error').removeClass('has-error');
                }
            });
        },

        //loading
        loading : function(opt){
            var loading = $('<div id="loading" style="position:fixed;left:0;top:0;width:100%;height:100%;z-index:10000;"></div>');
            loading.append('<div style="width:100%;height:100%;opacity:0.2;background-color:#fff"></div>');
            loading.append('<div class="leftLoading"></div>');
            if(opt=="show"){
                $('body').append(loading);
            }else{
                $('#loading').remove();
            }
        }


    };
})(window.Util = window.Util || {});

