<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/6/21
  Time: 22:42
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
    <link rel="stylesheet" href="${ctx}/static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/ichecked/skins/minimal/blue.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/validform.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/tableform.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/style.css" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${ctx}/static/js/lib/html5.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/lib/respond.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/lib/PIE_IE678.js"></script>
    <![endif]-->
</head>

<body>
<h3 class="back-rel"><a class="back-btn-a" href="${ctx}/back/users/userList"><i class="iconfont icon-fanhui"></i>&nbsp;返回</a></h3>
<div class="form-table">
    <form class="registerform" id="userForm" action="${ctx}/back/users/save" method="post">
        <div class="basicInfo ui-box">
            <h3>用户基本信息</h3>
            <div class="filedList">
                <label>用户名</label>
                <input type="text" class="form-control inputXt" placeholder="用户名" name="username"
                       auto_color_flag="true" datatype="*" nullmsg="请输入用户名!" />
            </div>
            <div class="filedList">
                <label>真实姓名</label>
                <input type="text" class="form-control inputXt" placeholder="真实姓名" name="realName"
                       auto_color_flag="true" datatype="*" nullmsg="请输入真实姓名!" />
            </div>
            <div class="filedList">
                <label>密码</label>
                <input type="password" class="form-control inputXt" placeholder="用户密码" name="password"
                       auto_color_flag="true" datatype="*6-18" nullmsg="请输入用户密码!" errormsg="密码至少6个字符,最多18个字符！"/>
            </div>
            <div class="filedList">
                <label>确认密码</label>
                <input type="password" class="form-control inputXt" placeholder="确认密码" name="rePassword"
                       auto_color_flag="true" datatype="*" recheck="password" nullmsg="请再次输入密码"/>
            </div>
            <div class="filedList">
                <label>所属角色</label>
                <c:forEach items="${roleList}" var="role">
                    <input type="checkbox" class="inputXt" name="roleIdsStr" value="${role.id}" datatype="*" nullmsg="请选择所属角色！"/>
                    <span>${role.description}</span>
                </c:forEach>
            </div>
            <div class="filedList">
                <label>身份证号码</label>
                <input type="text" class="form-control inputXt" placeholder="身份证号码" name="identityCardNum"/>
            </div>
            <div class="filedList">
                <label>邮箱</label>
                <input type="text" class="form-control inputXt" placeholder="邮箱" name="email"/>
            </div>
            <div class="filedList">
                <label>是否可用</label>
                <select class="form-control inputXt" name="isShow">
                    <option value="0">是</option>
                    <option value="1">否</option>
                </select>
            </div>
        </div>
        <!--提交取消-->
        <div class="bus-ground-btn">
            <a id="addUserform_btn" class="btn btn-enter">&nbsp;确定</a>
            <button id="reset_btn" type="reset" class="btn btn-white" onclick="JavaScript :history.back(-1)">&nbsp;取消</button>
        </div>
        <!--提交取消-->
    </form>
</div>

</body>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery.nicescroll.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugins/ichecked/jquery.icheck.js"></script>
<script type="text/javascript" src="${ctx}/static/js/commonForm.js"></script>
<script type="text/javascript" src="${ctx}/static/js/userAddOrEdit.js"></script>
<script type="text/javascript" src="${ctx}/static/js/scroll.js"></script>
<script type="text/javascript">
    $(function(){
        $userAddOrEdit.initUserAddOrEdit('${ctx}');
        $scroll.initScroll();
    });
</script>
</html>
