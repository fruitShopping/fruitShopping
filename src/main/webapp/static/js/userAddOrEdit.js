(function(window){
    var  u = {};
    u.initUserAddOrEdit = function(ctx){
        this.validform();//表单验证
        $commonForm.inputTag();//自动加上*
        this.bindClick();//绑定事件
    };
    u.bindClick = function(){
        //提交
        $("#addUserform_btn").click(function(){
            $("#userForm").submit();
        });
    };
    //表单验证
    u.validform = function(){
        var P_userform=$("#userForm").Validform({
            btnSubmit:"#userForm",
            tiptype:3,
            label:".label",
            showAllError:true
        });
    };
    window.$userAddOrEdit = u;
})(window);
