<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎您登陆</title>
    <link href="${ctx}/static/bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <style>
        .error{color:red}
    </style>
</head>

<body>
<div class="container">
    <br><br>
    <form class="form-horizontal" role="form" method="post" action="${ctx}/login">
        <div class="form-group">
            <label for="labfusername" class="col-sm-2 control-label">用户名：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="labfusername" placeholder="请输入用户名"
                       name="username" value="<shiro:principal/>"/>
            </div>
        </div>
        <div class="form-group">
            <label for="labfpassword" class="col-sm-2 control-label">密<span style="visibility: hidden">占</span>码：</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="labfpassword" placeholder="请输入密码" name="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">提交</button>
            </div>
        </div>
    </form>

    <span class="label label-danger">${error}</span>

    <br><br>

    <div class="panel panel-default">

        <div class="panel-body">
            <table class="table table-condensed">
                <thead>
                <tr>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>权限说明</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>admin</td>
                    <td>123456</td>
                    <td>超级管理员,可以执行任何操作</td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>system</td>
                    <td>超级管理员,可以执行任何操作</td>
                </tr>

                </tbody>
            </table>

        </div>
    </div>
</div>
</body>
</html>
