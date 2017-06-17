<%--
  Created by IntelliJ IDEA.
  User: zjj-ideapad
  Date: 2015/3/30
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>用户管理</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <jsp:include page="../body/header.jsp"/>
</head>
<body class="page-header-fixed">
<%@include file="../body/page_header.jsp"%>
<div class="page-container">
    <jsp:include page="../body/left_page.jsp"/>
    <div class="page-content">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <!-- BEGIN STYLE CUSTOMIZER -->
                    <!-- END BEGIN STYLE CUSTOMIZER -->
                    <h1>&nbsp;</h1>
                    <ul class="breadcrumb">
                        <li>
                            <i class="icon-home"></i>
                            <a href="${pageContext.request.contextPath}/">首页</a>
                            <span class="icon-angle-right"></span>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/users/editUser">用户修改</a></li>
                    </ul>
                </div>
            </div>
            <input type="hidden" id="userId" name="userId" value=""/>
            <div class="row-fluid">
                <div class="span12">
                    <!-- BEGIN EXAMPLE TABLE PORTLET-->
                    <div class="portlet box blue">
                        <div class="portlet-title">
                            <div class="caption"><i class="icon-reorder"></i>用户管理</div>
                        </div>
                        <div class="portlet-body">
                            <form action="${pageContext.request.contextPath}/users/editUser" method="post" id="editUser_form" class="form-horizontal">
                                <input type="hidden" name="backupPassword" value="${backupPassword}"/>
                                <input type="hidden" name="userId" value="${userId}"/>
                                <table class="table table-striped table-bordered table-hover" id="sample_1">
                                    <tr>
                                        <td>
                                            <div class="control-group">
                                                <label class="control-label">用户名：<span class="required">*</span></label>
                                                <div class="controls">
                                                    <input type="text" readonly="true" name="username" id="username" placeholder="用户名" class="span6 m-wrap" value="${user.username}"/>
                                                    <span class="help-inline"></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="control-group">
                                                <label class="control-label">密码：<span class="required">*</span></label>
                                                <div class="controls">
                                                    <input type="password" name="password" id="password" placeholder="密码" class="span6 m-wrap" value="${user.password}"/>
                                                    <span class="help-inline"></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="control-group">
                                                <label class="control-label">重输密码：<span class="required">*</span></label>
                                                <div class="controls">
                                                    <input type="password" name="repeat_password" id="repeat_password" placeholder="密码" class="span6 m-wrap" value="${user.password}"/>
                                                    <span class="help-inline"></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="control-group">
                                                <label class="control-label">真实姓名：<span class="required">*</span></label>
                                                <div class="controls">
                                                    <input type="text" readonly="true" name="real_name" id="real_name" placeholder="真实姓名" class="span6 m-wrap" value="${user.real_name}"/>
                                                    <span class="help-inline"></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="control-group">
                                                <label class="control-label">身份证号码：<span class="required">*</span></label>
                                                <div class="controls">
                                                    <input type="text" readonly="true"  name="identity_card_num" id="identity_card_num" placeholder="身份证号码" class="span6 m-wrap" value="${user.identity_card_num}"/>
                                                    <span class="help-inline"></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="control-group">
                                                <label class="control-label">手机号码：<span class="required">*</span></label>
                                                <div class="controls">
                                                    <input type="text" name="telephone" id="telephone" placeholder="手机号码" class="span6 m-wrap" value="${user.telephone}"/>
                                                    <span class="help-inline"></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-actions">
                                                <input class="btn blue" id="submit" type="submit" value="提交"/>
                                                <a href="${pageContext.request.contextPath}/users/userList" class="btn">取消</a>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../body/footer.jsp" %>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/card.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/editUser.js"></script>
<script>
    jQuery(document).ready(function () {
        App.init();
        EditUserValidation.init('${pageContext.request.contextPath}');
        $(".page-sidebar-menu").has("li").children().removeClass("active")
        $("li").has("a").children().removeClass("active");
        $("#user_manager").addClass("active");
    });
</script>
</html>
