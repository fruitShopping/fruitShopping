/*
 *多选框
 **/
(function(window){
    var  u = {};
    u.initCheckBox = function(){
        this.bindClick();//绑定事件
    };
    //绑定事件
    u.bindClick = function(){
        $.fn.tableCheckBox();//复选框选中样式
        //全选
        $("#checkAlluser").click(function(){
            if($(this).prop("checked")){
                $(".listTable input[name='checkbox']").prop("checked",true);
                $(".listTable input[name='checkbox']").not($(this)).parent().parent().addClass("tr-green");
            }else{
                $(".listTable input[name='checkbox']").prop("checked",false);
                $(".listTable input[name='checkbox']").not($(this)).parent().parent().removeClass("tr-green");
            }
        });
    };
    window.$checkBoxControl = u;
})(window);

/*Jq插件扩展*/
$.fn.extend({
    //tr选中包含复选框
    tableSelected:function(){
        $(".listTable tr").slice(1).each(function(){
            var self = $(this);
            self.children().slice(1).click(function(){
                $(self.children()[0]).find("input[type='checkbox']").each(function(){
                    if(!$(this).prop("checked")){
                        $(this).prop("checked",true);
                        $(this).parent().parent().addClass("tr-green");
                    }else{
                        $(this).prop("checked",false);
                        $(this).parent().parent().removeClass("tr-green");
                    }
                });
            });
        });
    },
    //tr选中不包含复选框
    tableSelectedTr:function(){
        $(".listTable tr").slice(1).each(function(){
            var self = $(this);
            self.click(function(){
                $(this).addClass("tr-green").siblings().removeClass("tr-green");
            });
        });
    },
    //复选框选中
    tableCheckBox:function(){
        $(".listTable input[type='checkbox']").not("#checkAlluser").each(function(){
            var that = $(this);
            that.click(function(){
                if(that.prop("checked")){
                    that.parent().parent().addClass("tr-green");
                }else{
                    that.parent().parent().removeClass("tr-green");
                }
            });
        });
    }
});