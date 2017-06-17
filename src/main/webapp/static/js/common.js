$(window).resize(function(){
	 resizefun();
});
$(function(){
    //左侧菜单
     tree();
     /*左侧菜单滚动条*/
	  $(".Hui-aside").mCustomScrollbar();
	  getExplorer();
	   /*浏览器兼容*/
            function getExplorer() {
                var explorer = window.navigator.userAgent;
                //alert(explorer);
                //ie
                if (explorer.indexOf("MSIE") >= 0) {
                }
                //firefox
                else if (explorer.indexOf("PlayStation") >= 0) {
                    //火狐下增加滚动速度
                    $(".mSBcontains").mCustomScrollbar({
                       scrollInertia:10,
                    })
                }
                //Chrome
                else if(explorer.indexOf("Chrome") >= 0){
                }
                //Opera
                else if(explorer.indexOf("Opera") >= 0){
                }
                //Safari
                else if(explorer.indexOf("Safari") >= 0){
                }
            };
      resizefun();
});
/*左侧菜单折叠收缩*/
function tree(){
    var b = this,
    c = 500;
    $(document).off("click", ".treeview a").on("click",".treeview a",
    function(){
        var d = $(this),
        e = d.next();
	    Hui_admin_tab(d);
		$('.pull-right-container i').attr('class','fa fa-angle-right');
        if (e.is(".treeview-menu") && e.is(":visible")) e.slideUp(c),
           e.parent("li").removeClass("active");
         else if (!e.is(":visible")){
           var f = d.parents("ul").first(),
           g = f.find("ul:visible").slideUp(c);
		   d.parents(".treeview").find('.pull-right-container i').attr('class','fa fa-angle-down');
           var h = d.parent("li");
           e.slideDown(c,
           function(){
              h.addClass("active");
           })
         }
		 d.parent("li").addClass('active').siblings().removeClass('active');
		 d.parent("li").find(".treeview-menu>li").removeClass('active');
    });
};
$(".Hui-aside").on("click",".treeview-menu a",function(){
    Hui_admin_tab(this);
	$(this).parent('li').addClass('active').siblings().removeClass('active');
});

function resizefun(){
    pingHeight=document.documentElement.clientHeight;
    pingWidth=document.documentElement.clientWidth;
    $(".Hui-aside").css({"height":pingHeight-90});
};
function Hui_admin_tab(obj){
    if($(obj).attr('_href')){
       var bStop=false;
       var bStopIndex=0;
       var _href=$(obj).attr('_href');
       var topWindow=$(window.parent.document);
       if(!bStop){
          creatIframe(_href);
       }else{
          var iframe_box=topWindow.find("#iframe_box");
          iframe_box.find(".show_iframe").hide().eq(bStopIndex).show().find("iframe").attr("src",_href);
       }
    }
};
function creatIframe(href){
    $("#iframe").attr("src",href);
      // var topWindow=$(window.parent.document);//子页面获取父页面元素
      // var iframe_box=topWindow.find('#iframe_box');
      // var iframeBox=iframe_box.find('.show_iframe');
      // iframeBox.hide();
      // iframe_box.append('<div class="show_iframe"><iframe frameborder="0" src='+href+'></iframe></div>');
};






