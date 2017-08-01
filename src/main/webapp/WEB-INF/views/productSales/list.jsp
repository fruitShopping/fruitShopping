<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/6/28
  Time: 22:51
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
    <jsp:include page="../body/header.jsp"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/layui/css/layui.css"/>
</head>

<body style="background:#FFF;">
<div class="table-main">
    <!--操作按钮组-->
    <div class="response-head titlePanel">
        <div class="ui-filter title-search ">选择产品:</div>
        <div class="ui-filter">
           <%--<input id="searchName" class="form-control w-120" type="text" placeholder="请输入关键字"/>--%>
            <select class="form-control w-121" name="productId" id="productId">
                <option value="0">---请选择---</option>
                <c:forEach items="${productList}" var="product">
                    <option value="${product.id}">${product.productName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="ui-filter" style="margin:0px 15px;">
            <a id="btn_Search" class="btn btn-seach-info">&nbsp;查询</a>
        </div>
        <div class="toolbar">
            <div class="btn-group">
                <a id="ul-add" class="btn btn-info" href="${ctx}/back/productSales/add">
                    <i class="fa fa-plus"></i>&nbsp;新增
                </a>
            </div>
            <div class="btn-group">
                <a id="ul-edit" class="btn btn-success">
                    <i class="fa fa-pencil-square-o"></i>&nbsp;编辑</a>
            </div>
            <div class="btn-group">
                <a id="ul-delete" class="btn btn-uired">
                    <i class="fa fa-trash-o"></i>&nbsp;删除</a>
            </div>
        </div>
    </div>
    <!--操作按钮组-->
    <div class="table-body-info">
        <span class="top-line"></span>
        <table class="table table-responsive table-condensed listTable">
            <thead>
            <tr>
                <th>
                    <input type="checkbox" name="checkbox" vlaue="" id="checkAllProduct"/></th>
                <th>产品名称</th>
                <th>规格</th>
                <th>斤数(起售斤数或每箱斤数)</th>
                <th>包邮</th>
                <th>起邮斤数</th>
                <th>邮费</th>
                <th>赠送果币</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productSalesList.dates}" var="productSales">
                <tr>
                    <td>
                        <input type="checkbox" name="checkbox" value="${productSales.id}"/>
                    </td>
                    <td>${productSales.productName}</td>
                    <td>
                        <c:choose>
                            <c:when test="${productSales.salesMethod == 0}">斤</c:when>
                            <c:otherwise>箱</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${productSales.poundsNum}</td>
                    <td>
                        <c:choose>
                            <c:when test="${productSales.isFreePost == 0}">是</c:when>
                            <c:otherwise>否</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${productSales.freePostJin}</td>
                    <td>${productSales.postMoney}</td>
                    <td>${productSales.fruitScore}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <!--分页-->
        <c:choose>
            <c:when test="${userList.pageTotal > 1}">
                <div class="table-page" id="controlPage"></div>
                <%--</div>--%>
            </c:when>
            <c:otherwise>
                <div class="table-page" id="controlPage" style="display: none;"></div>
                <%--</div>--%>
            </c:otherwise>
        </c:choose>
        <!--分页-->
    </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery.nicescroll.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugins/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/static/js/checkBox.js"></script>
<script type="text/javascript" src="${ctx}/static/js/product/productSales.js"></script>
<script type="text/javascript" src="${ctx}/static/js/scroll.js"></script>
<script type="text/javascript" src="${ctx}/static/js/page.js"></script>
<script type="text/javascript">
    $(function () {
        $productSalesControl.initProductSales('${ctx}');
        $pageControl.initPage('${productSalesList.pageNum}', '${url}', '${productSalesList.pageTotal}');
        $checkBoxControl.initCheckBox();
        $scroll.initScroll();
    });
    var productId = '${productId}';
    $("#productId").val(productId);
</script>
</html>
