<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎您登陆</title>
    <style>
        .error{color:red}
    </style>
</head>

<body>
    <div id="ad">
        <form class="form-vertical login-form" id="form" method="POST" action="">
            <div class="login">
                <div class="error">
                    <span class="error">${error}</span>
                </div>
                <input class="btn_login_input" type="text" placeholder="用户名" name="username" id="username" value="<shiro:principal/>"/>
                <input class="btn_login_input" type="password" placeholder="密码" name="password"/>
                <br/>
                <input class="btn_login" name="submit" type="submit" value="登录" />
                <%--<p class="fpw"><a href="${pageContext.request.contextPath}/resetPassword" class="" id="forget-password">无法登录或忘记密码？</a></p>--%>
                <%--<a href="${pageContext.request.contextPath}/register" id="register-btn" class="">--%>
                    <%--<input class="btn_signup" name="" type="button" value="注册" />--%>
                <%--</a>--%>
            </div>
        </form>
    </div>

    <div id="footer">2015 copyright</div>
</body>
</html>
