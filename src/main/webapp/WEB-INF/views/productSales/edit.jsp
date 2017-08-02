<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/7/2
  Time: 18:38
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
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/ichecked/skins/minimal/blue.css"/>
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
<h3 class="back-rel">
    <a class="back-btn-a" href="${ctx}/back/productSales/list">
        <i class="iconfont icon-fanhui"></i>&nbsp;返回
    </a>
</h3>
<div class="form-table">
    <form class="registerform" id="addProSalesForm" action="${ctx}/back/productSales/save" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${productSales.id}"/>
        <div class="basicInfo ui-box">
            <h3>基本信息</h3>
            <div class="filedList">
                <label>选择产品</label>
                <select class="form-control inputXt" name="productId" id="productId" disabled="disabled">
                    <option value="">---请选择---</option>
                    <c:forEach items="${productList}" var="product">
                        <option value="${product.id}">${product.productName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="filedList">
                <label>规格</label>
                <select class="form-control inputXt" name="salesMethod" id="salesMethod">
                    <option value="0">斤</option>
                    <option value="1">箱</option>
                </select>
            </div>
            <div class="filedList">
                <label>斤数</label>
                <input type="text" class="form-control inputXt" placeholder="斤数" name="poundsNum"
                       auto_color_flag="true" datatype="n"
                       nullmsg="请输入斤数!" errormsg="必须为整数数字" value="${productSales.poundsNum}"/>
                <span style="color:#a9a9a9;">规格为斤则是起售斤数，规格为箱则是每箱斤数</span>
            </div>
            <div class="filedList">
                <label>是否包邮</label>
                <select class="form-control inputXt" name="isFreePost" id="isFreePost">
                    <option value="0">是</option>
                    <option value="1">否</option>
                </select>
            </div>
            <div class="filedList">
                <label>起邮斤数</label>
                <input type="text" class="form-control inputXt" placeholder="起邮斤数" name="freePostJin" value="${productSales.freePostJin}"/>
            </div>
            <div class="filedList">
                <label>邮费</label>
                <input type="text" class="form-control inputXt" placeholder="邮费" name="postMoney" value="${productSales.postMoney}"/>
            </div>
            <div class="filedList">
                <label>赠送果币</label>
                <input type="text" class="form-control inputXt" placeholder="赠送果币" name="fruitScore" value="${productSales.fruitScore}" />
            </div>
        </div>
        <!--提交取消-->
        <div class="bus-ground-btn">
            <a id="addProSalesForm_btn" class="btn btn-enter">&nbsp;确定</a>
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
<script type="text/javascript" src="${ctx}/static/js/product/productSalesOperate.js"></script>
<script type="text/javascript" src="${ctx}/static/js/scroll.js"></script>
<script type="text/javascript">
    $(function(){
        $scroll.initScroll();
        $proSaleaOperate.initProSalesOperate('${ctx}');
    });
    var productId = '${productSales.productId}';
    var salesMethod = '${productSales.salesMethod}';
    var isFreePost = '${productSales.isFreePost}';
    $("#productId").val(productId);
    $("#salesMethod").val(salesMethod);
    $("#isFreePost").val(isFreePost);
</script>
</html>
