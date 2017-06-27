<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/6/27
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=10">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${ctx}/static/bootstrap/css/bootstrap.css"/>
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
<h3 class="back-rel"><a class="back-btn-a" href="${ctx}/back/dict/list"><i class="iconfont icon-fanhui"></i>&nbsp;返回</a></h3>
<div class="form-table">
    <form class="registerform" id="addDictform" action="${ctx}/back/dict/save" method="post">
        <input type="hidden" name="id" value="${dict.id}">
        <div class="basicInfo ui-box">
            <h3>基本信息</h3>
            <div class="filedList">
                <label>名称</label>
                <input type="text" class="form-control inputXt" placeholder="名称" name="name"
                       auto_color_flag="true" datatype="*" nullmsg="请输入名称!" value="${dict.name}"/>
            </div>
            <div class="filedList">
                <label>编码</label>
                <input type="text" class="form-control inputXt" placeholder="编码" name="code"
                       auto_color_flag="true" datatype="*" nullmsg="请输入编码!" value="${dict.code}"/>
            </div>
        </div>
        <!--提交取消-->
        <div class="bus-ground-btn">
            <a id="addDictform_btn" class="btn btn-enter">&nbsp;确定</a>
            <button id="reset_btn" type="reset" class="btn btn-white" onclick="JavaScript :history.back(-1)">&nbsp;取消</button>
        </div>
        <!--提交取消-->
    </form>
</div>

</body>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery-2.2.3.min.js"></script>
<%--<script type="text/javascript" src="${ctx}/static/zTreeStyle/jquery.ztree.core.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/static/zTreeStyle/jquery.ztree.excheck.js"></script>--%>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery.nicescroll.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugins/ichecked/jquery.icheck.js"></script>
<script type="text/javascript" src="${ctx}/static/js/commonForm.js"></script>
<script type="text/javascript" src="${ctx}/static/js/popup.js"></script>
<script type="text/javascript" src="${ctx}/static/js/dictAddOrEdit.js"></script>
<script type="text/javascript" src="${ctx}/static/js/scroll.js"></script>
<script type="text/javascript">
    $(function(){
        $dictOperate.initDictAddOrEdit('${ctx}');
        $scroll.initScroll();
    });
</script>
</html>
