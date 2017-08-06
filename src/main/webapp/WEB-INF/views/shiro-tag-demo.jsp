<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
        <p>
            <shiro:guest>
                欢迎游客访问，<a href="${ctx}/login">登录</a>
            </shiro:guest>
        </p>
        <p>
            <shiro:user>
                欢迎[<shiro:principal/>]登录，<a href="${pageContext.request.contextPath}/logout">退出</a>
            </shiro:user>
        </p>
        <p>
            <shiro:authenticated>
                用户[<shiro:principal/>]已身份验证通过
            </shiro:authenticated>
        </p>
        <p>
            <shiro:notAuthenticated>
                未身份验证（包括记住我）
            </shiro:notAuthenticated>
        </p>
        <p>
            <shiro:principal/>
            显示用户身份信息，默认调用Subject.getPrincipal()获取，即Primary Principal。
        </p>
        <p>
            <shiro:principal type="java.lang.String"/>
            相当于Subject.getPrincipals().oneByType(String.class)。
        </p>

        <p>
            <%--<shiro:principal property="username"/>--%>相当于((User)Subject.getPrincipals()).getUsername()。
        </p>

        <p>
            <shiro:hasRole name="admin">
                用户[<shiro:principal/>]拥有角色admin<br/>
            </shiro:hasRole>
            如果当前Subject有角色将显示body体内容。
        </p>
        <p>
            <shiro:hasAnyRoles name="admin,user">
                用户[<shiro:principal/>]拥有角色admin或user<br/>
            </shiro:hasAnyRoles>
            如果当前Subject有任意一个角色（或的关系）将显示body体内容
        </p>
    <p>
        <shiro:lacksRole name="abc">
            用户[<shiro:principal/>]没有角色abc<br/>
        </shiro:lacksRole>
        如果当前Subject没有角色将显示body体内容
    </p>
        <p>
            <shiro:hasPermission name="user:create">
                用户[<shiro:principal/>]拥有权限user:create<br/>
            </shiro:hasPermission>
            如果当前Subject有权限将显示body体内容
        </p>
    <p>
        <shiro:lacksPermission name="org:create">
            用户[<shiro:principal/>]没有权限org:create<br/>
        </shiro:lacksPermission>
        如果当前Subject没有权限将显示body体内容。
    </p>
    <p>
        http://jinnianshilongnian.iteye.com/blog/1864800
        另外可以参考我的《简单shiro扩展实现NOT、AND、OR权限验证》实现NOT、AND、OR权限验证：
        http://jinnianshilongnian.iteye.com/blog/1864800。
    </p>
    </body>
</html>
