<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <title>未授权</title>
        <link href="${ctx}/static/bootstrap/css/bootstrap.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <div style="margin-top: 20px;" class="alert alert-danger" role="alert">
                <span style="font-size: 24px;">很遗憾,您不具备访问该网页的权限。</span>
            </div>
            <button class="btn btn-default" type="button" onclick="history.go(-1)">返回上一页</button>
            <a class="btn btn-default" href="${ctx}/login">请更换账号登录</a>
        </div>
    </body>
</html>
