/*
 *字典管理
 **/
(function(window){
    var  u = {};
    u.initDict = function(ctx){
        this.bindClick(ctx);//绑定事件
    };
    //绑定事件
    u.bindClick = function(ctx){
        $.fn.tableSelected();//表单选中样式
        /*更新*/
        $("#ul-edit").click(function(){
            var isSelected = $(".listTable .tr-green").length;//是否选中
            if(isSelected){
                var that = $(".listTable .tr-green").find("input[type=checkbox]")[0];
                var id = $(that).val();
                window.location.href = ctx+"/back/dict/update?dictId="+id;
            }else{
                layer.msg('您没有选中如何数据请选择后操作', {time:2000, icon:0});
            }
        });
        /*删除*/
        $("#ul-delete").click(function(){
            var isSelected = $(".listTable .tr-green").length;//是否选中
            if(isSelected){
                var obj = $(".listTable .tr-green");//选中的tr
                parent.delConfig(obj,ctx,"/back/dict/delete");
            }else{
                layer.msg('您没有选中如何数据请选择后操作', {time:2000, icon:0});
            }
        });
    };
    window.$dictControl = u;
})(window);