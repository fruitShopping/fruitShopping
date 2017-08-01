<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/6/16
  Time: 23:40
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
        <div class="ui-filter title-search ">
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
        </div>
        <div class="ui-filter">
            <input id="searchName" class="form-control w-120" type="text" placeholder="请输入关键字"/>
        </div>
        <div class="ui-filter" style="margin:0px 15px;">
            <a id="btn_Search" class="btn btn-seach-info">&nbsp;查询</a>
        </div>
        <div class="toolbar">
            <div class="btn-group">
                <a id="ul-add" class="btn btn-info" href="${ctx}/back/users/add">
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
                    <input type="checkbox" name="checkbox" vlaue="" id="checkAlluser"/></th>
                <th>用户名</th>
                <th>真实姓名</th>
                <th>手机号码</th>
                <th>角色</th>
                <th>是否可用</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList.dates}" var="user">
                <tr>
                    <td>
                        <input type="checkbox" name="checkbox" value="${user.id}"/>
                    </td>
                    <td>${user.username}</td>
                    <td>${user.realName}</td>
                    <td>${user.telephone}</td>
                    <td>${user.roleNames}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.locked}">不可用</c:when>
                            <c:otherwise>正常</c:otherwise>
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
<script type="text/javascript" src="${ctx}/static/js/userControl.js"></script>
<script type="text/javascript" src="${ctx}/static/js/scroll.js"></script>
<script type="text/javascript" src="${ctx}/static/js/page.js"></script>
<script type="text/javascript">
    $(function () {
        $userControl.initUser('${ctx}');
        $pageControl.initPage('${userList.pageNum}', '${url}', '${userList.pageTotal}');
        $checkBoxControl.initCheckBox();
        $scroll.initScroll();
    });
    var usename = '${username}';
    var telephone = '${mobile}';
    if (usename != "") {
        $(".dropdown-text").text("用户名");
        $(".dropdown-text").attr("data-value", "0");
        $("#searchName").val(usename);
    }
    if (telephone != "") {
        $(".dropdown-text").text("手机号码");
        $(".dropdown-text").attr("data-value", "1");
        $("#searchName").val(telephone);
    }
</script>
</html>
