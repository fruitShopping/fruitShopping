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
<h3 class="back-rel"><a class="back-btn-a" href="${ctx}/back/category/list"><i class="iconfont icon-fanhui"></i>&nbsp;返回</a></h3>
<div class="form-table">
    <form class="registerform" id="addCateform" action="${ctx}/back/category/save" method="post">
        <input type="hidden" name="id" value="${category.id}">
        <div class="basicInfo ui-box">
            <h3>基本信息</h3>
            <div class="filedList">
                <label>产品名称</label>
                <input type="text" class="form-control inputXt" placeholder="产品名称" name="categoryName"
                       auto_color_flag="true" datatype="*" nullmsg="请输入产品名称!" value="${category.categoryName}"/>
            </div>
            <div class="filedList">
                <label>是否上架</label>
                <select class="form-control inputXt" name="isShelves" id="isShelves">
                    <option value="0">是</option>
                    <option value="1">否</option>
                </select>
            </div>
            <div class="filedList">
                <label>所属类别</label>
                <select class="form-control inputXt" name="typeId" id="typeId" datatype="*" nullmsg="请选择所属类别!">
                    <option value="">----请选择---</option>
                    <c:forEach items="${dictList}" var="dict">
                        <option value="${dict.id}">${dict.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <!--提交取消-->
        <div class="bus-ground-btn">
            <a id="addCateForm_btn" class="btn btn-enter">&nbsp;确定</a>
            <button id="reset_btn" type="reset" class="btn btn-white" onclick="JavaScript :history.back(-1)">&nbsp;取消</button>
        </div>
        <!--提交取消-->
    </form>
</div>

</body>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery.nicescroll.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugins/ichecked/jquery.icheck.js"></script>
<script type="text/javascript" src="${ctx}/static/js/commonForm.js"></script>
<script type="text/javascript" src="${ctx}/static/js/categoryAddOrEdit.js"></script>
<script type="text/javascript" src="${ctx}/static/js/scroll.js"></script>
<script type="text/javascript">
    $(function(){
        $categoryOperate.initCategoryAddOrEdit('${ctx}');
        $scroll.initScroll();
    });
    var isShelves = '${category.isShelves}';
    var typeId = '${category.typeId}';
    $("#isShelves").val(isShelves);
    $("#typeId").val(typeId);
</script>
</html>
