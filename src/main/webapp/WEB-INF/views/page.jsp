<%--
  Created by IntelliJ IDEA.
  User: zjj-ideapad
  Date: 2015/1/6
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%--<div class="portlet box purple">--%>
<c:if test="${dateRecord.pageTotal > 1}">
    <div class="pagination">
        <ul>
            <c:choose>
                <c:when test="${dateRecord.pageNum == 1}">
                    <li><a href="javascript:void(0);">首页</a></li>
                    <li><a href="javascript:void(0);">上一页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="javascript:void(0);" onclick="goPage(1,'${url}','${dateRecord.parameter}')">首页</a></li>
                    <li><a href="javascript:void(0);" onclick="goPage(${dateRecord.pageNum - 1},'${url}','${dateRecord.parameter}')">上一页</a></li>
                </c:otherwise>
            </c:choose>
            <c:if test="${dateRecord.pageTotal >= 1}">
                <c:choose>
                    <c:when test="${dateRecord.pageNum<=5}">
                        <c:forEach var="i" begin="1" end="${dateRecord.pageNum}">
                            <c:choose>
                                <c:when test="${i == dateRecord.pageNum}">
                                    <li class="active"><a href="javascript:void(0);" onclick="goPage(${i},'${url}','${dateRecord.parameter}')">${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li ><a href="javascript:void(0);" onclick="goPage(${i},'${url}','${dateRecord.parameter}')">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <%--...&nbsp;--%>
                        <c:forEach var="i" begin="${dateRecord.pageNum-3}" end="${dateRecord.pageNum}">
                            <c:choose>
                                <c:when test="${i == dateRecord.pageNum}">
                                    <li class="active"><a href="javascript:void(0);" onclick="goPage(${i},'${url}','${dateRecord.parameter}')">${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li ><a href="javascript:void(0);" onclick="goPage(${i},'${url}','${dateRecord.parameter}')">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${dateRecord.pageNum>=dateRecord.pageTotal-4 || dateRecord.pageTotal-4<=0}">
                        <c:forEach var="i" begin="${dateRecord.pageNum+1}" end="${dateRecord.pageTotal}">
                            <%--<a href="ViewServlet?currentPage=${i}">[${i }]</a>&nbsp;--%>
                            <c:choose>
                                <c:when test="${i == dateRecord.pageNum}">
                                    <li class="active"><a href="javascript:void(0);" onclick="goPage(${i},'${url}','${dateRecord.parameter}')">${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li ><a href="javascript:void(0);" onclick="goPage(${i},'${url}','${dateRecord.parameter}')">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="i" begin="${dateRecord.pageNum+1}"  end="${dateRecord.pageNum+3}">
                            <li ><a href="javascript:void(0);" onclick="goPage(${i},'${url}','${dateRecord.parameter}')">${i}</a></li>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </c:if>
            <c:choose>
                <c:when test="${dateRecord.pageNum==dateRecord.pageTotal}">
                    <li><a href="javascript:void(0);">下一页</a></li>
                    <li><a href="javascript:void(0);">末页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="javascript:void(0);" onclick="goPage(${dateRecord.pageNum + 1},'${url}','${dateRecord.parameter}')">下一页</a></li>
                    <li><a href="javascript:void(0);" onclick="goPage(${dateRecord.pageTotal},'${url}','${dateRecord.parameter}')">末页</a></li>
                </c:otherwise>
            </c:choose>
                <%--<li>&nbsp;&nbsp;</li>--%>
            <li><a href="javascript:void(0);"> 第${dateRecord.pageNum}页/共${dateRecord.pageTotal}页</a></li>
        </ul>
    </div>
</c:if>
<%--</div>--%>
<%--</div>--%>
</body>
<script type="text/javascript">
    <%--function goPage(page,url){--%>
    <%--//         editPage();--%>
    <%--alert(url);--%>
    <%--window.location.href = ${pageContext.request.contextPath}url+"?currentPage=" + page;--%>
    <%--}--%>
    function goPage(page,url,param){
        if(param.length>0) {
            window.location.href = "${pageContext.request.contextPath}" + url + "?currentPage=" + page+"&"+param;
        }else{
            window.location.href = "${pageContext.request.contextPath}" + url + "?currentPage=" + page;
        }
    }
</script>
</html>
