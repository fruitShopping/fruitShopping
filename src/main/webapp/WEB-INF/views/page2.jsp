<%--
  Created by IntelliJ IDEA.
  User: lenovo123
  Date: 2015/4/14
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%--<div class="portlet box purple">--%>
<c:if test="${dateRecord2.pageTotal > 1}">
    <div class="pagination">
        <ul>
            <c:choose>
                <c:when test="${dateRecord2.pageNum == 1}">
                    <li><a href="javascript:void(0);">首页</a></li>
                    <li><a href="javascript:void(0);">上一页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="javascript:void(0);" onclick="goPage2(1,'${url}','${dateRecord2.parameter}')">首页</a></li>
                    <li><a href="javascript:void(0);" onclick="goPage2(${dateRecord2.pageNum - 1},'${url}','${dateRecord2.parameter}')">上一页</a></li>
                </c:otherwise>
            </c:choose>
            <c:if test="${dateRecord2.pageTotal >= 1}">
                <c:choose>
                    <c:when test="${dateRecord2.pageNum<=5}">
                        <c:forEach var="i" begin="1" end="${dateRecord2.pageNum}">
                            <c:choose>
                                <c:when test="${i == dateRecord2.pageNum}">
                                    <li class="active"><a href="javascript:void(0);" onclick="goPage2(${i},'${url}','${dateRecord2.parameter}')">${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li ><a href="javascript:void(0);" onclick="goPage2(${i},'${url}','${dateRecord2.parameter}')">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <%--...&nbsp;--%>
                        <c:forEach var="i" begin="${dateRecord2.pageNum-3}" end="${dateRecord2.pageNum}">
                            <c:choose>
                                <c:when test="${i == dateRecord2.pageNum}">
                                    <li class="active"><a href="javascript:void(0);" onclick="goPage2(${i},'${url}','${dateRecord2.parameter}')">${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li ><a href="javascript:void(0);" onclick="goPage2(${i},'${url}','${dateRecord2.parameter}')">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${dateRecord2.pageNum>=dateRecord2.pageTotal-4 || dateRecord2.pageTotal-4<=0}">
                        <c:forEach var="i" begin="${dateRecord2.pageNum+1}" end="${dateRecord2.pageTotal}">
                            <%--<a href="ViewServlet?currentPage=${i}">[${i }]</a>&nbsp;--%>
                            <c:choose>
                                <c:when test="${i == dateRecord2.pageNum}">
                                    <li class="active"><a href="javascript:void(0);" onclick="goPage2(${i},'${url}','${dateRecord2.parameter}')">${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li ><a href="javascript:void(0);" onclick="goPage2(${i},'${url}','${dateRecord2.parameter}')">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="i" begin="${dateRecord2.pageNum+1}"  end="${dateRecord2.pageNum+3}">
                            <li ><a href="javascript:void(0);" onclick="goPage2(${i},'${url}','${dateRecord2.parameter}')">${i}</a></li>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </c:if>
            <c:choose>
                <c:when test="${dateRecord2.pageNum==dateRecord2.pageTotal}">
                    <li><a href="javascript:void(0);">下一页</a></li>
                    <li><a href="javascript:void(0);">末页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="javascript:void(0);" onclick="goPage2(${dateRecord2.pageNum + 1},'${url}','${dateRecord2.parameter}')">下一页</a></li>
                    <li><a href="javascript:void(0);" onclick="goPage2(${dateRecord2.pageTotal},'${url}','${dateRecord2.parameter}')">末页</a></li>
                </c:otherwise>
            </c:choose>
                <%--<li>&nbsp;&nbsp;</li>--%>
            <li><a href="javascript:void(0);"> 第${dateRecord2.pageNum}页/共${dateRecord2.pageTotal}页</a></li>
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
    function goPage2(page,url,param){
        if(param.length>0) {
            window.location.href = "${pageContext.request.contextPath}" + url + "?currentPage2=" + page+"&"+param;
        }else{
            window.location.href = "${pageContext.request.contextPath}" + url + "?currentPage2=" + page;
        }
    }
</script>
</html>
