<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/6/25
  Time: 17:57
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
    <link rel="stylesheet" type="text/css" href="${ctx}/static/bootstrap/css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/fontImg/iconfont.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/ichecked/skins/minimal/blue.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/validform.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/tableform.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/style.css"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${ctx}/static/lib/html5.js"></script>
    <script type="text/javascript" src="${ctx}/static/lib/respond.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/lib/PIE_IE678.js"></script>
    <![endif]-->
</head>

<body>
<h3 class="back-rel"><a class="back-btn-a" href="${ctx}/back/business/businessInfo"><i class="iconfont icon-fanhui"></i>&nbsp;返回</a></h3>
<div class="form-table">
    <form class="registerform" id="personform" action="${ctx}/back/business/save" method="post" enctype="multipart/form-data">
        <input type="hidden" name="user.id" value="${business.user.id}">
        <input type="hidden" name="id" value="${business.id}">
        <div class="basicInfo ui-box">
            <h3>基本信息</h3>
            <div class="filedList">
                <label>用户名</label>
                <input type="text" class="form-control inputXt" placeholder="请输入用户名" name="user.username" value="${business.user.username}"
                       ajaxurl="${ctx}/back/users/checkUsernameBus" auto_color_flag="true" nullmsg="请输入用户名"  datatype="s1-20" errormsg="请输入1-20个字符!" />
            </div>
            <div class="filedList">
                <label>真实姓名</label>
                <input type="text" class="form-control inputXt" placeholder="请输入真实姓名" name="user.realName" value="${business.user.realName}"
                       nullmsg="请输入真实姓名" auto_color_flag="true" datatype="zh1-20" errormsg="请输入1-20个字符!" />
            </div>
            <div class="filedList">
                <label>身份证号</label>
                <input type="text" class="form-control inputXt" placeholder="请输入身份证号" name="user.identityCardNum" value="${business.user.identityCardNum}"
                       nullmsg="请输入身份证号" auto_color_flag="true" datatype="idCards" errormsg="请输正确的身份证号" />
            </div>
            <div class="filedList">
                <label>手机号码</label>
                <input type="text" class="form-control inputXt" placeholder="请输入手机号码" name="user.telephone" value="${business.user.telephone}"
                       nullmsg="请输入手机号码" auto_color_flag="true" datatype="telphone" errormsg="请输正确的手机号" />
            </div>
        </div>
        <div class="storeInfo ui-box">
            <h3>店铺信息</h3>
            <div class="filedList">
                <label>店铺名</label>
                <input type="text" class="form-control inputXt" placeholder="请输入店铺名" name="merchantName" value="${business.merchantName}"
                       nullmsg="请输入店铺名" auto_color_flag="true" datatype="*1-50" errormsg="长度为1-50" />
            </div>
            <div class="filedList">
                <div class="ground-radio">
                    <label>店铺类型</label>
                    <div class="radio-box" style="margin-left:15px;">
                        <input type="radio" name="type" checked value="1"><span>个体</span>
                    </div>
                    <div class="radio-box">
                        <input type="radio" name="type" datatype="*" value="0"><span>企业</span>
                    </div>
                    <span class="type-tip">说明：企业必须上传资质</span>
                </div>
            </div>
        </div>

        <div class="aptitudeInfo ui-box" id="company" style="display: none">
            <h3>资质</h3>
            <div class="row">
                <c:if test="${business.imgList.size() == 0}">
                    <div class="col-md-4 col-sm-4 ui-box-col">
                        <div class="js_uploadBox dp-img">
                            <a href="javascript:;" class="file">
                                <input type="file" name="files1" class="js_upFile1" multiple/>
                            </a>
                            <div class="js_showBox">
                                <img  src="" />
                            </div>
                            <div class="img_bg bg-one"><span>添加照片</span></div>
                        </div>
                        <p><span>(请再次上传店铺头像)</span></p>
                    </div>
                    <div class="col-md-4 col-sm-4 ui-box-col">
                        <div class="js_uploadBox zh-img">
                            <a href="javascript:;" class="file">
                                <input type="file" name="files2" class="js_upFile2" multiple/>
                            </a>
                            <div class="js_showBox">
                                <img  src="" />
                            </div>
                            <div class="img_bg bg-two"><span>添加照片</span></div>
                        </div>
                        <p><span>(请在此上传营业执照)</span></p>
                    </div>
                </c:if>
                <c:forEach items="${business.imgList}" var="img">
                    <c:choose>
                        <c:when test="${img.type ==0}">
                            <div class="col-md-4 col-sm-4 ui-box-col">
                                <div class="js_uploadBox dp-img">
                                    <a href="javascript:;" class="file">
                                        <input type="file" name="files1" class="js_upFile1" multiple/>
                                    </a>
                                    <div class="js_showBox">
                                        <c:choose>
                                            <c:when test="${business.type == 0}">
                                                <img  src="${ctx}/${img.imgPath}" />
                                            </c:when>
                                            <c:otherwise>
                                                <img  src="" />
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="img_bg bg-one"><span>添加照片</span></div>
                                </div>
                                <p><span>(请再次上传店铺头像)</span></p>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="col-md-4 col-sm-4 ui-box-col">
                                <div class="js_uploadBox zh-img">
                                    <a href="javascript:;" class="file">
                                        <input type="file" name="files2" class="js_upFile2" multiple/>
                                    </a>
                                    <div class="js_showBox">
                                        <c:choose>
                                            <c:when test="${business.type == 0}">
                                                <img  src="${ctx}/${img.imgPath}" />
                                            </c:when>
                                            <c:otherwise>
                                                <img  src="" />
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="img_bg bg-two"><span>添加照片</span></div>
                                </div>
                                <p><span>(请在此上传营业执照)</span></p>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <span class="type-tip">提示:营业执照信息必须与商户信息一致</span>
            </div>
        </div>
        <div class="aptitudeInfo ui-box" id="personal" style="display: block">
            <h3>资质</h3>
            <div class="row">
                <c:if test="${business.imgList.size() == 0}">
                    <div class="col-md-4 col-sm-4 ui-box-col">
                        <div class="js_uploadBox dp-img">
                            <a href="javascript:;" class="file">
                                <input type="file" name="files3" class="js_upFile1" multiple/>
                            </a>
                            <div class="js_showBox">
                                <img  src="" />
                            </div>
                            <div class="img_bg bg-one"><span>添加照片</span></div>
                        </div>
                        <p><span>(身份证正面)</span></p>
                    </div>
                    <div class="col-md-4 col-sm-4 ui-box-col">
                        <div class="js_uploadBox zh-img">
                            <a href="javascript:;" class="file">
                                <input type="file" name="files4" class="js_upFile2" multiple/>
                            </a>
                            <div class="js_showBox">
                                <img  src="" />
                            </div>
                            <div class="img_bg bg-two"><span>添加照片</span></div>
                        </div>
                        <p><span>(身份证反面)</span></p>
                    </div>
                </c:if>
                <c:forEach items="${business.imgList}" var="img">
                    <c:choose>
                        <c:when test="${img.type ==0}">
                            <div class="col-md-4 col-sm-4 ui-box-col">
                                <div class="js_uploadBox dp-img">
                                    <a href="javascript:;" class="file">
                                        <input type="file" name="files3" class="js_upFile1" multiple/>
                                    </a>
                                    <div class="js_showBox">
                                        <c:choose>
                                            <c:when test="${business.type == 1}">
                                                <img  src="${ctx}/${img.imgPath}" />
                                            </c:when>
                                            <c:otherwise>
                                                <img  src="" />
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="img_bg bg-one"><span>添加照片</span></div>
                                </div>
                                <p><span>(身份证正面)</span></p>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="col-md-4 col-sm-4 ui-box-col">
                                <div class="js_uploadBox zh-img">
                                    <a href="javascript:;" class="file">
                                        <input type="file" name="files4" class="js_upFile2" multiple/>
                                    </a>
                                    <div class="js_showBox">
                                        <c:choose>
                                            <c:when test="${business.type == 1}">
                                                <img  src="${ctx}/${img.imgPath}" />
                                            </c:when>
                                            <c:otherwise>
                                                <img  src="" />
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="img_bg bg-two"><span>添加照片</span></div>
                                </div>
                                <p><span>(身份证反面)</span></p>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <span class="type-tip">提示:证件信息必须与本人信息一致</span>
            </div>
        </div>
        <!--提交取消-->
        <div class="bus-ground-btn">
            <a id="personform_btn" class="btn btn-enter">&nbsp;确定</a>
            <button id="reset_btn" type="reset" class="btn btn-white" onclick="JavaScript :history.back(-1)">&nbsp;取消</button>
        </div>
        <!--提交取消-->
    </form>
</div>


</body>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery.nicescroll.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/lib/jquery.uploadView.js"></script>
<script type="text/javascript" src="${ctx}/static/plugins/ichecked/jquery.icheck.js"></script>
<script type="text/javascript" src="${ctx}/static/js/commonForm.js"></script>
<script type="text/javascript" src="${ctx}/static/js/business/businessEdit.js"></script>
<script type="text/javascript" src="${ctx}/static/js/scroll.js"></script>
<script type="text/javascript">
    $(function(){
        $('input').on('ifChecked', function(event){
           var value = $(this).val();
            if(value == 0){
                $("#company").css("display","block");
                $("#personal").css("display","none");
            }else{
                $("#company").css("display","none");
                $("#personal").css("display","block");
            }
        });
        $busEdit.initPage();
        $scroll.initScroll();
    });
    var type = '${business.type}';
    $("input[name='type'][value="+type+"]").attr("checked",true);
    if(type == '0'){
        $("#company").css("display","block");
        $("#personal").css("display","none");
    }else{
        $("#company").css("display","none");
        $("#personal").css("display","block");
    }
</script>

</html>

