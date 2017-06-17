<%--
  Created by IntelliJ IDEA.
  User: zjj-ideapad
  Date: 2015/3/25
  Time: 9:45
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
    <script type="text/javascript">
        function doLocked(num,userId){
            $.ajax({
                url:${pageContext.request.contextPath}"/users/doLocked",
                method:"POST",
                data:{userId:userId,num:num},
                success:function(data){
                    if(data == true){
                        pageReload();
                    }
                }
            })
        }

        function deleteUser(userId){
            document.getElementById("userId").value = userId;
            var $modal = $('#modal');
            $modal.modal();
        }

        function startDelete(){
            var userId = $("#userId").val();
            $.ajax({
                url:${pageContext.request.contextPath}"/users/userDel",
                method:"POST",
                data:{userId:userId},
                success:function(data){
                    if(data == true){
                        var $modal = $('#delModal');
                        $modal.modal();
                    }
                }
            });
        }

        function editUser(userId){
            window.location.href = "${pageContext.request.contextPath}/users/editUser/"+userId;
        }
        function pageReload(){
            window.location.reload();
        }
    </script>
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
                        <li><a href="${pageContext.request.contextPath}/users/userList">用户管理</a></li>
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
                            <form id = "checkForm" action="" method="get" class="form-horizontal">
                                <input type="hidden" name="currentPage" value="${dateRecord.pageNum}"/>
                                <%--<h3 class="form-section">返现历史查询</h3>--%>
                                <div class="row-fluid">
                                    <div class="span12 ">
                                        <%--<div class="control-group">--%>
                                        <label class="control-label" for="username">用户名：</label>
                                        <div class="controls">
                                            <input class="span3 m-wrap" id="username" name="username" type="text" value="${username}" />
                                            <button type="submit" class="btn blue"><i class="icon-ok"></i>查询</button>
                                        </div>
                                        <%--</div>--%>
                                    </div>

                                </div>
                            </form>
                            <div id="modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                    <h3 id="myModalLabel1">用户删除</h3>
                                </div>
                                <div class="modal-body" style="text-align: center">
                                    <h3>确定删除？</h3>
                                </div>
                                <div class="modal-footer">
                                    <%--<button class="btn" data-dismiss="modal" aria-hidden="true">确定</button>--%>
                                    <input type="button"  onclick="startDelete()" data-dismiss="modal" class="btn green" value="确定">
                                    <input type="button" data-dismiss="modal" class="btn green" value="取消">
                                </div>
                            </div>
                            <div id="delModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">

                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                    <h3 id="myModalLabel2">用户删除</h3>
                                </div>
                                <div class="modal-body" style="text-align: center">
                                    <h3>删除成功！</h3>
                                </div>
                                <div class="modal-footer">
                                    <%--<button class="btn" data-dismiss="modal" aria-hidden="true">确定</button>--%>
                                    <input type="button"  onclick="pageReload()" data-dismiss="modal" class="btn green" value="确定">
                                </div>
                            </div>
                            <table class="table table-striped table-bordered table-hover" id="sample_1">
                                <thead>
                                <tr>
                                    <%--<th style="width:8px;"><input type="checkbox" onclick="if(this.checked==true) { checkAll('moId'); } else { clearAll('moId'); }"/></th>--%>
                                    <th>用户名</th>
                                    <th>真实姓名</th>
                                    <th>手机号码</th>
                                    <th>注册时间</th>
                                    <th>锁定</th>
                                    <th>删除</th>
                                    <th>修改</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${dateRecord.dates}" var="user">
                                    <tr class="odd gradeX">
                                            <%--<td><input type="checkbox" name="moId" value="${moTableList.id}" /></td>--%>
                                        <td>${user.username}</td>
                                        <td>${user.real_name}</td>
                                        <td>${user.telephone}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${user.addTime}"/></td>
                                        <c:choose>
                                            <c:when test="${user.username=='admin'}">
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${user.locked == false}">
                                                            <button class="btn dropdown-toggle" data-toggle="dropdown">
                                                                <i class="icon-lock"></i> 锁定
                                                            </button>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button class="btn dropdown-toggle" data-toggle="dropdown" >
                                                                <i class="icon-unlock"></i> 解锁
                                                            </button>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td>
                                                    <button class="btn dropdown-toggle" data-toggle="dropdown">
                                                        <i class="icon-trash"></i> 删除
                                                    </button>
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${user.locked == false}">
                                                            <button class="btn green" data-toggle="dropdown" onclick="doLocked('1','${user.id}')">
                                                                <i class="icon-lock"></i> 锁定
                                                            </button>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button class="btn red" data-toggle="dropdown" onclick="doLocked('0','${user.id}')" >
                                                                <i class="icon-unlock"></i> 解锁
                                                            </button>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td>
                                                    <button class="btn purple" data-toggle="dropdown" onclick="deleteUser('${user.id}')">
                                                        <i class="icon-trash"></i> 删除
                                                    </button>
                                                </td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td>
                                            <%--<a href="${pageContext.request.contextPath}/users/editUser/${user.id}" class="btn mini purple">--%>
                                            <button class="btn purple" data-toggle="dropdown" onclick="editUser('${user.id}')">
                                                <i class="icon-edit"></i> 修改
                                            </button>
                                            <%--</a>--%>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <div class="portlet-body" id="div" style="text-align: center">
                            <jsp:include page="../page.jsp"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../body/footer.jsp" %>
</body>
<script>
    jQuery(document).ready(function () {
        App.init();
        $(".page-sidebar-menu").has("li").children().removeClass("active")
        $("li").has("a").children().removeClass("active");
        $("#user_manager").addClass("active");
    });
</script>
</html>
