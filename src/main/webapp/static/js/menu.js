/*
 *菜单管理
 **/
(function(window){
    var  u = {};
    u.initMenu = function(ctx){
        this.bindClick(ctx);//绑定事件
    };
    //绑定事件
    u.bindClick = function(ctx){
        $(".queryCondition").each(function() {//下拉选择
            $(this).Bsselect();
        });
        $.fn.tableSelected();//表单选中样式
        // $.fn.tableCheckBox();//复选框选中样式
        /*新增*/
        $("#ul-edit").click(function(){
            var isSelected = $(".listTable .tr-green").length;//是否选中
            if(isSelected){
                var that = $(".listTable .tr-green").find("input[type=checkbox]")[0];
                var idss = $(that).val();
                window.location.href = ctx+"/back/menu/edit?id="+idss;
            }else{
                layer.msg('您没有选中如何数据请选择后操作', {time:2000, icon:0});
            }
        });
        /*删除*/
        $("#ul-delete").click(function(){
            var isSelected = $(".listTable .tr-green").length;//是否选中
            if(isSelected){
                var obj = $(".listTable .tr-green");//选中的tr
                parent.menuDelConfig(obj,ctx);
            }else{
                layer.msg('您没有选中如何数据请选择后操作', {time:2000, icon:0});
            }
        });
    };
    window.$menuControl = u;
})(window);

/*Jq插件扩展*/
$.fn.extend({
    /*下拉框*/
    Bsselect: function() {
        var obj = this,
            Selectval = obj.find(".dropdown-text"),
            Selectoption = obj.find(".dropdown-menu");
        Selectoption.find("li").click(function() {
            var option = $(this).text();
            var dataValue = $(this).children("a").attr("data-value");
            Selectval.text(option);
            Selectval.attr("data-value", dataValue);
        });
    }
});