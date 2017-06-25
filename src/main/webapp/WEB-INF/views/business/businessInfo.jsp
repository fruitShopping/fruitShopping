<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/6/25
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=10">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${ctx}/static/bootstrap/css/bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="${ctx}/static/fontImg/iconfont.css" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/public.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/style.css" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${ctx}/static/lib/html5.js"></script>
    <script type="text/javascript" src="${ctx}/static/lib/respond.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/lib/PIE_IE678.js"></script>
    <![endif]-->
</head>

<body  style="min-width:992px;">
<!--商户信息-->
<div class="usInfo ui-box">
    <h3>商户信息</h3>
    <div class="row">
        <div class="col-md-4 col-sm-4 ui-box-col">
            <i class="icon icon-usinf"></i>
            <div class="info-box-right">
                <h3>真实姓名</h3>
                <p>张晓龙<span>企业</span></p>
            </div>
        </div>
        <div class="col-md-4 col-sm-4 ui-box-col">
            <i class="icon icon-booxk"></i>
            <div class="info-box-right">
                <h3>身份证号</h3>
                <p>420982199302091480</p>
            </div>
        </div>
        <div class="col-md-4 col-sm-4 ui-box-col">
            <i class="icon icon-telf"></i>
            <div class="info-box-right">
                <h3>手机号码</h3>
                <p>158-2569-1546</p>
            </div>
        </div>
    </div>
</div>
<!--商户信息-->
<!--店铺信息-->
<div class="shopInfo ui-box">
    <h3>店铺信息</h3>
    <div class="row">
        <div class="col-md-4 col-sm-4 ui-box-col">
            <img src="${ctx}/static/images/sgzy_03.jpg" />
            <p>梅泓声水果庄园</p>
        </div>
        <div class="col-md-4 col-sm-4 ui-box-col">
            <img src="${ctx}/static/images/yyzz_03.jpg" />
            <p>458844765854<br/><span>(营业执照注册号)</span></p>
        </div>
    </div>
</div>
<!--店铺信息-->
<div class="ui-box">
    <a id="btn_edit" class="btn btn-greenlur" href="busedit.html"><i class="iconfont icon-modify"></i>&nbsp;修改</a>
</div>
</body>
<script src="${ctx}/static/js/lib/jquery-2.2.3.min.js"></script>
<script src="${ctx}/static/js/lib/jquery.nicescroll.js"></script>
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function(){
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
    });
</script>
</html>
