(function(window){
    var  u = {};
    u.initMenuAddOrEdit = function(){
        this.validform();//表单验证
        $commonForm.inputTag();//自动加上*
        this.bindClick();//绑定事件
    };
    u.bindClick = function(){
        //提交
        $("#personform_btn").click(function(){
            $("#personform").submit();
        });
    }
    //表单验证
    u.validform = function(){
        var P_userform=$("#personform").Validform({
            btnSubmit:"#personform_btn",
            tiptype:3,
            label:".label",
            showAllError:false,
            datatype:{
                "zh1-6" : /^[\u4E00-\u9FA5\uf900-\ufa2d]{1,6}$/,
                "idCards" :/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,
                "telphone" :/(^[0-9]{3,4}[0-9]{7,8}$)|(^[0-9]{7,8}$)|(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{7,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/
            },
            ajaxPost:true,
            callback : function(data) {
                alert(data);
                /*			            if(data.status=="y"){
                 alert(data.message);
                 location.href = "ShipInfo/shipInfoListAction.do";
                 }else{
                 alert(data.message);
                 }*/
            }
        });
    };
    window.$menuOperate = u;
})(window);
