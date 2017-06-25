/*
 *菜单管理
 **/
(function(window){
    var  u = {};
    u.initRole = function(ctx){
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
                window.location.href = ctx+"/back/role/edit?id="+id;
            }else{
                layer.msg('您没有选中如何数据请选择后操作', {time:2000, icon:0});
            }
        });
        /*删除*/
        $("#ul-delete").click(function(){
            var isSelected = $(".listTable .tr-green").length;//是否选中
            if(isSelected){
                var obj = $(".listTable .tr-green");//选中的tr
                parent.delConfig(obj,ctx,"/back/role/delete");
            }else{
                layer.msg('您没有选中如何数据请选择后操作', {time:2000, icon:0});
            }
        });

        $("#ul-authority").click(function(){
            var isSelected = $(".listTable .tr-green").length;//是否选中
            if(isSelected){
                var length = $(".listTable .tr-green").find("input[type=checkbox]").length;
                if(length == 1){
                    var that = $(".listTable .tr-green").find("input[type=checkbox]")[0];
                    var id = $(that).val();
                    menuTree(id);
                    // console.log($("#treeDiv").html());
                    // parent.roleAuth($("#treeDiv").html());
                }else{
                    layer.msg('您只能选择一条数据进行操作', {time:2000, icon:0});
                }
            }else{
                layer.msg('您没有选中如何数据请选择后操作', {time:2000, icon:0});
            }

        });
    };
    window.$roleControl = u;
})(window);