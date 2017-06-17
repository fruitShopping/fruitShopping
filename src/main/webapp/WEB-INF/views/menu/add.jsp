<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/6/17
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=10">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${ctx}/static/bootstrap/css/bootstrap.css"/>
    <%--<link rel="stylesheet" href="../fontImg/iconfont.css" type="text/css" />--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/ichecked/skins/minimal/blue.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/validform.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/tableform.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/style.css" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${ctx}/static/js/lib/html5.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/lib/respond.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/lib/PIE_IE678.js"></script>
    <![endif]-->
</head>

<body>
<h3 class="back-rel"><a class="back-btn-a" href="${ctx}/back/menu/menuList"><i class="iconfont icon-fanhui"></i>&nbsp;返回</a></h3>
<div class="form-table">
    <form class="registerform" id="personform">
        <div class="basicInfo ui-box">
            <h3>基本信息</h3>
            <div class="filedList">
                <label>用户名</label>
                <input type="text" class="form-control inputXt" auto_color_flag="true" nullmsg placeholder="请输入用户名" datatype="s1-4" errormsg="请输入1-4个字符!" />
            </div>
            <div class="filedList">
                <label>真实姓名</label>
                <input type="text" class="form-control inputXt" placeholder="请输入真实姓名" auto_color_flag="true" datatype="zh1-4" errormsg="请输入1-4个字符!" />
            </div>
            <div class="filedList">
                <label>身份证号</label>
                <input type="text" class="form-control inputXt" placeholder="请输入身份证号" auto_color_flag="true" datatype="idCards" errormsg="请输正确的身份证号" />
            </div>
            <div class="filedList">
                <label>手机号</label>
                <input type="text" class="form-control inputXt" placeholder="请输入手机号" auto_color_flag="true" datatype="telphone" errormsg="请输正确的手机号" />
            </div>
        </div>
        <!--提交取消-->
        <div class="bus-ground-btn">
            <a id="personform_btn" class="btn btn-enter">&nbsp;确定</a>
            <button id="reset_btn" type="reset" class="btn btn-white">&nbsp;取消</button>
        </div>
        <!--提交取消-->
    </form>
</div>


</body>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery.nicescroll.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugins/ichecked/jquery.icheck.js"></script>
<script type="text/javascript" src="${ctx}/static/js/popup.js"></script>
<script type="text/javascript" src="${ctx}/static/js/commonForm.js"></script>
<script type="text/javascript" src="${ctx}/static/js/menuAddOrEdit.js"></script>
<script type="text/javascript" src="${ctx}/static/js/scroll.js"></script>
<script type="text/javascript">
    $(function(){
        $menuOperate.initMenuAddOrEdit();
        $scroll.initScroll();
    });
</script>

</html>

