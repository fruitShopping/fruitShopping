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
        <!--<div class="ui-filter title-search ">
            <div class="btn-group queryCondition">
                <a class="btn btn-default dropdown-text" data-toggle="dropdown" aria-expanded="false"
                   data-value="0">用户名</a>
                <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" style="min-width:108px;">
                    <li>
                        <a data-value="0">用户名</a></li>
                    <li>
                        <a data-value="1">手机号码</a></li>
                </ul>
            </div>
        </div>-->
        <div class="ui-filter">
            <input id="searchName" class="form-control w-120" type="text" placeholder="请输入关键字"/>
        </div>
        <div class="ui-filter" style="margin:0px 15px;">
            <a id="btn_Search" class="btn btn-seach-info">&nbsp;查询</a>
        </div>
        <div class="toolbar">
            <div class="btn-group">
                <a id="ul-add" class="btn btn-info" href="${ctx}/back/product/add">
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
                <th>产品类别</th>
                <th>产品种类</th>
                <th>原价</th>
                <th>优惠价</th>
                <%--<th>规格</th>--%>
                <th>上架</th>
                <th>库存(斤)</th>
                <th>已售(斤)</th>
                <th>促销产品</th>
                <th>时令产品</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productList.dates}" var="product">
                <tr>
                    <td>
                        <input type="checkbox" name="checkbox" value="${product.id}"/>
                    </td>
                    <td><a href="${ctx}/back/product/view?productId=${product.id}" style="color:green;">${product.productName}</a></td>
                    <td>${product.typeName}</td>
                    <td>${product.categoryName}</td>
                    <td>${product.originalPrice}</td>
                    <td>${product.discountedPrice}</td>
                    <td>
                    <c:choose>
                        <c:when test="${product.isShelves==1}">
                            是
                        </c:when>
                        <c:otherwise>否</c:otherwise>
                    </c:choose>
                    </td>
                    <%--<td>${product.startJin}</td>--%>
                    <td>${product.inStock}</td>
                    <td>${product.sold}</td>
                    <td>
                        <c:choose>
                            <c:when test="${product.isPromotion==0}">
                                否
                            </c:when>
                            <c:otherwise>是</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${product.isSeason == 0}">否</c:when>
                            <c:otherwise>是</c:otherwise>
                        </c:choose>
                    </td>
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
<script type="text/javascript" src="${ctx}/static/js/product/product.js"></script>
<script type="text/javascript" src="${ctx}/static/js/scroll.js"></script>
<script type="text/javascript" src="${ctx}/static/js/page.js"></script>
<script type="text/javascript">
    $(function () {
        $productControl.initProduct('${ctx}');
        $pageControl.initPage('${productList.pageNum}', '${url}', '${productList.pageTotal}');
        $checkBoxControl.initCheckBox();
        $scroll.initScroll();
    });

</script>
</html>
