(function(window){
    var  u = {};
    u.initPage = function(pageNo,url,pageTotal){
        this.dataPage(pageNo,url,pageTotal);//分页
    };
    /*分页*/
    u.dataPage = function(pageNo,url,pageTotal){
        layui.use(['laypage', 'layer'], function(){
            var laypage = layui.laypage,
                layer = layui.layer;
            laypage({
                cont: 'controlPage',
                pages: pageTotal,
                skip: true,
                curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
                    var page = location.search.match(/pageNo=(\d+)/); ;
                    return page ? page[1] : 1;
                }(),
                jump: function(obj,first){//点击页码出发的事件
                    if(first!=true){//是否首次进入页面
                        var currentPage = obj.curr;//获取点击的页码
                        window.location.href =url+"pageNo="+currentPage;
                    }
                }
            });
        });
    };
    window.$pageControl = u;
})(window);
