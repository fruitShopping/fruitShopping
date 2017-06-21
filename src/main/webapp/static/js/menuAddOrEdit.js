(function(window){
    var  u = {};
    u.initMenuAddOrEdit = function(ctx){
        this.validform();//表单验证
        $commonForm.inputTag();//自动加上*
        this.bindClick();//绑定事件
    };
    u.bindClick = function(){
        //提交
        $("#addMenuform_btn").click(function(){
            $("#addMenuform").submit();
        });
    };
    //表单验证
    u.validform = function(){
        var P_userform=$("#addMenuform").Validform({
            btnSubmit:"#addMenuform",
            tiptype:3,
            label:".label",
            showAllError:true
        });
    };
    window.$menuOperate = u;
})(window);
