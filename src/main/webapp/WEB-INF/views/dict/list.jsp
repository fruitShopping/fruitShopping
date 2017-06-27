<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/6/27
  Time: 22:18
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
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/layui/css/layui.css" />
    <%--<link rel="stylesheet" type="text/css" href="${ctx}/static/zTreeStyle/zTreeStyle.css">--%>
</head>

<body style="background:#FFF;">
<div class="table-main">
    <!--操作按钮组-->
    <div class="response-head titlePanel">
        <div class="toolbar">
            <div class="btn-group">
                <a id="ul-add" class="btn btn-info" href="${ctx}/back/dict/add">
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
                    <input type="checkbox" name="checkbox" vlaue="" id="checkAlluser" />
                </th>
                <th>名称</th>
                <th>编码</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dictList.dates}" var="dict">
                <tr>
                    <td>
                        <input type="checkbox" name="checkbox" value="${dict.id}"/>
                    </td>
                    <td>${dict.name}</td>
                    <td>${dict.code}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--分页-->
    <c:choose>
        <c:when test="${dictList.pageTotal > 1}">
            <div class="table-page" id="controlPage"></div>
        </c:when>
        <c:otherwise>
            <div class="table-page" id="controlPage" style="display: none;"></div>
        </c:otherwise>
    </c:choose>
<!--分页-->
</div>
</body>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery.nicescroll.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugins/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/static/plugins/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/static/js/dict.js"></script>
<script type="text/javascript" src="${ctx}/static/js/checkBox.js"></script>
<script type="text/javascript" src="${ctx}/static/js/scroll.js"></script>
<script type="text/javascript" src="${ctx}/static/js/page.js"></script>
<script type="text/javascript">
    $(function() {
        $dictControl.initDict('${ctx}');
        $checkBoxControl.initCheckBox();
        $pageControl.initPage('${dictList.pageNum}', '${url}', '${dictList.pageTotal}');
        $scroll.initScroll();
    });

</script>
</html>
