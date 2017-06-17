/*
 *公用表格方法
**/
(function(window){
	var  u = {};
	//给input自动加上* 表格样式1
	u.inputTag = function(){
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
	//给input自动加上* 表格样式2
	u.inputTwoTag = function(){
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
                That.parent().prev("td").prepend("<i class='i-red'>*&nbsp;</i>");
            }
        };
	};
	/*关闭弹窗*/
	u.layer_close = function(){
	    var index = parent.layer.getFrameIndex(window.name);
	    parent.layer.close(index);
	};
	window.$commonForm = u;
})(window);