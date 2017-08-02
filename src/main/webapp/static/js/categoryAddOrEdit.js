(function(window){
    var  u = {};
    u.initCategoryAddOrEdit = function(ctx){
        this.validform();//表单验证
        $commonForm.inputTag();//自动加上*
        this.bindClick();//绑定事件
    };
    u.bindClick = function(){
        //提交
        $("#addCateForm_btn").click(function(){
            $("#addCateform").submit();
        });
    };
    //表单验证
    u.validform = function(){
        var P_userform=$("#addCateform").Validform({
            btnSubmit:"#addCateform",
            tiptype:3,
            label:".label",
            showAllError:true
        });
    };
    window.$categoryOperate = u;
})(window);
