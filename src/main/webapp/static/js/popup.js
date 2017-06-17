/*
 *title 弹窗标题
 *w     弹窗宽度 
 *h     弹窗高度不传默认为 $(window).height() - 50
 *url   弹窗打开路径
**/

/*弹窗封装*/
function layer_show(title,url,w,h){
	if (title == null || title == '') {
		title=false;
	};
	if (url == null || url == '') {
		url="404.html";
	};
	if (w == null || w == '') {
		w=800;
	};
	if (h == null || h == '') {
		h=($(window).height() - 50);
	};
	layer.open({
		type: 2,
		area: [w+'px', h +'px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: title,
		content: url
	});
};

//用户管理删除弹窗
function delConfig(obj){
	layer.confirm('确认删除该条记录吗？', {
		     title: '提示',
	         icon:2,
             btn: ['确定','关闭'],
	         yes:function(){ 
				 obj.remove();//前台删除还需要后台删除
                 layer.msg('删除成功', {icon: 1,time: 1000});
	         }
	});  
};

