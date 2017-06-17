/*
 *用户管理
**/
(function(window){
	var  u = {};
	u.initPage = function(){
		this.winScroll();//滚动条
		this.dataPage();//分页
		this.bindClick();//绑定事件
	};
	//绑定事件
	u.bindClick = function(){
	   $(".queryCondition").each(function() {//下拉选择
           $(this).Bsselect();
       });
	   $.fn.tableSelected();//表单选中样式
	   $.fn.tableCheckBox();//复选框选中样式
	   /*新增*/
	   $("#ul-add").click(function(){
		   var isSelected = $(".listTable .tr-green").length;//是否选中
		   if(isSelected){
			   var title = "用户管理",url="Content/useradd.html",w=780,h=500;
			   parent.layer_show(title,url,w,h);
		   }else{
			   layer.msg('您没有选中如何数据请选择后操作', {time:2000, icon:0});	
		   }
	   });
	   /*删除*/
	   $("#ul-delete").click(function(){
		   var isSelected = $(".listTable .tr-green").length;//是否选中
		   if(isSelected){
			   var obj = $(".listTable .tr-green");//选中的tr
               parent.delConfig(obj); 
		   }else{
			   layer.msg('您没有选中如何数据请选择后操作', {time:2000, icon:0});	
		   }
	   });
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
	/*分页*/
	u.dataPage = function(){
		layui.use(['laypage', 'layer'], function(){
            var laypage = layui.laypage,
			    layer = layui.layer;
		        laypage({
                    cont: 'userControlPage',
					pages: 100,
					skip: true
			   });
  		});
	};
	window.$userControl = u;
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
      },
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
 


