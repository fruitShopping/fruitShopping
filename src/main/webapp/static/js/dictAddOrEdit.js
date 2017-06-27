(function(window){
    var  u = {};
    u.initDictAddOrEdit = function(ctx){
        this.validform();//表单验证
        $commonForm.inputTag();//自动加上*
        this.bindClick();//绑定事件
    };
    u.bindClick = function(){
        //提交
        $("#addDictform_btn").click(function(){
            $("#addDictform").submit();
        });
    };
    //表单验证
    u.validform = function(){
        var P_userform=$("#addDictform").Validform({
            btnSubmit:"#addMenuform",
            tiptype:3,
            label:".label",
            showAllError:true
        });
    };
    window.$dictOperate = u;
})(window);
