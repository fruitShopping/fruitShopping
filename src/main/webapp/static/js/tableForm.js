(function(window){
	var  u = {};
	u.initPage = function(){
		this.winScroll();//初始化滚动条
		this.validform();//表单验证
		this.upLoadimg();//图片上传
		this.validCus();//表单验证插件扩展
		this.radio();//单选框
	};
	/*初始化滚动条*/
	u.winScroll = function(){
		$("html").niceScroll({
            styler:"fb",
            cursorcolor:"#cccccc",
            cursorwidth: '5',
            cursorborderradius: '5px',
            background: '',
            autohidemode: false,
            spacebarenabled:false,
            cursorborder: '0',
            zindex: '1000'
        });
	};
	u.validCus = function(){
		var inputXt = $("input[class*=inputXt]");
        var inputSt = $("select[class*=inputXt]");
        inputXt.each(function(){
            That=$(this);
            messaggTip(That);
        });
        inputSt.each(function(){
            That=$(this);
            messaggTip(That);
        });
        function messaggTip(That){
            var Tagtrue = That.attr("auto_color_flag");
            if(Tagtrue){
                That.prev("label").prepend("<i class='i-red'>*&nbsp;</i>");
            }
        };
	};
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
/*			            if(data.status=="y"){
			                alert(data.message);
			                location.href = "ShipInfo/shipInfoListAction.do";
			            }else{
			                alert(data.message);
			            }*/
                }
            });
			//提交
			$("#personform_btn").click(function(){
		        $("#personform").submit();
	        });
	};
	//单选
	u.radio = function(){
		$("input[type='radio']").iCheck({
			 radioClass: 'iradio_minimal-blue',
             increaseArea: '20%' // optional
        });
	};
	//图片上传
	u.upLoadimg = function(){
		$(".js_upFile1").uploadView({
	           uploadBox: '.js_uploadBox',//设置上传框容器
	           showBox : '.js_showBox',//设置显示预览图片的容器
	           width : 200, //预览图片的宽度，单位px
	           height : 200, //预览图片的高度，单位px
	           allowType: ["gif", "jpeg", "jpg", "bmp", "png"], //允许上传图片的类型
	           maxSize :2, //允许上传图片的最大尺寸，单位M
	           success:function(e){
	            /*alert('图片上传成功');*/
				 $(".bg-one").hide();
	           }
         });
		 $(".js_upFile2").uploadView({
	           uploadBox: '.js_uploadBox',//设置上传框容器
	           showBox : '.js_showBox',//设置显示预览图片的容器
	           width : 265, //预览图片的宽度，单位px
	           height : 200, //预览图片的高度，单位px
	           allowType: ["gif", "jpeg", "jpg", "bmp", "png"], //允许上传图片的类型
	           maxSize :2, //允许上传图片的最大尺寸，单位M
	           success:function(e){
	            /*alert('图片上传成功');*/
				  $(".bg-two").hide();
	           }
         });
	};
	window.$busedit = u;
})(window);
