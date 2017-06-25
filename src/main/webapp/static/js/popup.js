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

//菜单管理删除弹窗
function delConfig(obj,ctx,url){
	layer.confirm('确认删除该条记录吗？', {
		     title: '提示',
	         icon:2,
             btn: ['确定','关闭'],
	         yes:function(){
				 var num  = obj.size();
				 var ids= '';
				 for(var i=0;i<num;i++){
					 var that = $(obj[i]).find("input[type=checkbox]")[0];
					 ids = ids + $(that).val() +',';
				 }
				 $.ajax({
					 type:"POST",
					 url:ctx+url,
					 data:{ids:ids},
					 success:function(data){
						 if(data){
							 layer.msg('删除成功', {icon: 1,time: 1000});
							 fram.location.reload();
						 }else{
							 layer.msg('删除失败', {icon: 1,time: 1000});
						 }
					 }
				 });

	         }
	});  
};

// var zdoc = document.frames[iframe].document;
var selectIds,changeIds;
function roleAuth(roleId,ctx){
	layer.open({
		type: 1
		,title: "角色赋权" //不显示标题栏
		// ,closeBtn: false
		,area: ['300px','400px']
		,shade: 0.5
		,id: 'LAY_layuipro' //设定一个id，防止重复弹出
		,resize: false
		,btn: ['确认', '取消']
		,btnAlign: 'c'
		,moveType: 1 //拖拽模式，0或者1
		,content: $("#treeDiv")
		,yes: function(index,layero){
			//更新角色权限
			$.ajax({
				type:"post",
				url:ctx+"/back/role/roleAndMenu",
				data:{roleId:roleId,selectIds:selectIds,changeIds:changeIds},
				success:function(data){
					if(data){
						layer.msg('角色赋权成功', {time:2000, icon:1});
					}else{
						layer.msg('角色赋权失败', {time:2000, icon:0});
					}
					layer.close(index);
				}
			});
		}
	});
}


var setting = {
	view: {
		selectedMulti: false
	},
	check: {
		chkboxType: { "Y": "s", "N": "p" },
		enable: true
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onCheck: onCheck
	}
};

function onCheck(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		nodes = zTree.getChangeCheckedNodes();
	var id = ""
//                    name = "";
//            nodes.sort(function compare(a,b){return a.id-b.id;});
	for (var i=0, l=nodes.length; i<l; i++) {
		id += nodes[i].id + ",";
		name += nodes[i].name + ",";
	}
	if (id.length > 0 ) id = id.substring(0, id.length-1);
//            if (name.length > 0 ) name = name.substring(0, name.length-1);
	changeIds =id;
	console.log("changeIds:"+id);
	// zdoc.getElementById('changeIds').value = id;
	// $("#changeIds").val(id);
}

function createTree(roleId,data,ctx) {
	$.fn.zTree.init($("#treeDemo"), setting, data);
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	var selectNodes = zTree.getCheckedNodes(true);
	var selectIdStr = "";
	for (var i=0, l=selectNodes.length; i<l; i++) {
		selectIdStr += selectNodes[i].id + ",";
	}
	if (selectIdStr.length > 0 ){
		selectIdStr = selectIdStr.substring(0, selectIdStr.length-1);
	}

	zTree.expandAll(true);
	selectIds = selectIdStr;
	console.log(selectIds+"=========");
	// zdoc.getElementById('selectIds').value = selectIds;
		// $("#selectIds").val(selectIds);
	roleAuth(roleId,ctx);
}

