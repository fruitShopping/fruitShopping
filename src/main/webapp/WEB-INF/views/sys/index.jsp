<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/6/10
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=10">
    <title>商城后台管理</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <jsp:include page="../body/header.jsp"/>
</head>

<body>
<header class="Hui-header">
    <a href="#" class="logo">
        <span class="logo-lg"><img src="${ctx}/static/images/logo.png"/></span>
    </a>
    <nav class="navbar">
        <div class="userInfo">
            <img src="${ctx}/static/images/user2-160x160.jpg" class="img-circle"/>
            <span class="infoName"><shiro:principal/></span>|<a href="javascript:;" class="editPass">修改密码</a>
            <span class="text-algin">欢迎，<d><shiro:principal/></d>进入点鲜果后台管理系统！</span>
        </div>
        <div class="systemInfo">
            <ul>
                <li>
                    <a href="javascript:;">
                        <i class="iconzy icon-fruit"></i>
                        <span>商城首页</span>
                    </a>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="iconzy icon-shop"></i>
                        <span>我的商铺</span>
                    </a>
                </li>
                <li>
                    <a href="${ctx}/logout">
                        <i class="iconzy icon-close"></i>
                        <span>退出</span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<!--头部-->

<!--侧边栏-->
<aside class="Hui-aside mSBcontains">
    <section class="sidebar">
        <ul class="sidebar-menu">
            <c:forEach items="${menuList}" var="menu">
                <c:if test="${menu.parentId == 1&&menu.isShow eq '0'}">
                    <li class="treeview">
                        <a href="javascript:void(0)">
                            <i class="${menu.icon}"></i>
                            <span>${menu.name}</span>
                            <span class="pull-right-container">
                              <i class="fa fa-angle-right"></i>
                            </span>
                        </a>
                        <ul class="treeview-menu">
                            <c:forEach items="${menuList}" var="menu2">
                                <c:if test="${menu2.parentId eq menu.id&&menu2.isShow eq '0'}">
                                    <li><a _href="${menu2.href}">${menu2.name}</a></li>
                                </c:if>
                            </c:forEach >
                        </ul>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </section>
</aside>
<!--侧边栏-->

<!--中间部分-->
<section class="Hui-article-box" id="iframe_box">
    <div class="show_iframe">
        <iframe scrolling="no" frameborder="0" src="" name="fram" id="iframe"></iframe>
    </div>
</section>
<!--中间部分-->
<footer class="footer">
    <p>张超锋@版权所有</p>
</footer>
<jsp:include page="../body/footer.jsp"/>
</body>
</html>

