(function(window){
    var  u = {};
    u.initScroll = function(){
        this.winScroll();//初始化滚动条
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
    window.$scroll = u;
})(window);
