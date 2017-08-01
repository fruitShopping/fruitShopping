<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/6/29
  Time: 20:51
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
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/ichecked/skins/minimal/blue.css"/>
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
<h3 class="back-rel">
    <a class="back-btn-a" href="${ctx}/back/product/list">
        <i class="iconfont icon-fanhui"></i>&nbsp;返回
    </a>
</h3>
<div class="form-table">
    <form class="registerform" id="addProductForm" action="${ctx}/back/product/save" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${product.id}"/>
        <input type="hidden" name="detailImg" id="detailImg" value="${product.detailImg}"/>
        <input type="hidden" name="productImg" id="productImg" value="${product.productImg}"/>
        <input type="hidden" name="oldDetailImg" id="oldDetailImg" value="${product.detailImg}"/>
        <input type="hidden" name="oldProductImg" id="oldProductImg" value="${product.productImg}"/>
        <div class="basicInfo ui-box">
            <h3>基本信息</h3>
            <div class="filedList">
                <label>水果名称</label>
                <input type="text" class="form-control inputXt" placeholder="水果名称" name="productName"
                       auto_color_flag="true" datatype="*" nullmsg="请输入水果名称!" value="${product.productName}"/>
            </div>
            <div class="filedList">
                <label>标题</label>
                <input type="text" class="form-control inputXt" placeholder="标题" name="title" value="${product.title}"
                       auto_color_flag="true" datatype="*" nullmsg="请输入水果标题!"/>
                <span style="color:#a9a9a9;">标题就是产品详情页上的标题</span>
            </div>
            <div class="filedList">
                <label>水果类别</label>
                <select class="form-control inputXt" name="typeId" id="typeId" onchange="dictChange()"
                        auto_color_flag="true" datatype="*" nullmsg="请选择水果类别!">
                    <option value="">---请选择---</option>
                    <c:forEach items="${dictList}" var="dict">
                        <option value="${dict.id}">${dict.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="filedList">
                <label>水果品种</label>
                <select class="form-control inputXt" name="categoryId" id="categoryId"
                        auto_color_flag="true" datatype="*" nullmsg="请选择水果品种!">
                    <option value="">---请选择---</option>
                </select>
            </div>
            <div class="filedList">
                <label>原价</label>
                <input type="text" class="form-control inputXt" placeholder="原价" name="originalPrice" value="${product.originalPrice}"
                       auto_color_flag="true" datatype="/^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/"
                       nullmsg="请输入水果原价!" errormsg="必须为数字，可以有小数"/>
            </div>
            <div class="filedList">
                <label>优惠价</label>
                <input type="text" class="form-control inputXt" placeholder="优惠价" name="discountedPrice" value="${product.discountedPrice}"/>
            </div>
            <div class="filedList">
                <label>库存</label>
                <input type="text" class="form-control inputXt" placeholder="库存" name="inStock" value="${product.inStock}"
                       auto_color_flag="true" datatype="n" nullmsg="请输入水果库存!" errormsg="必须为整数数字"/>
                <span style="color:#a9a9a9;">单位：斤</span>
            </div>
            <div class="filedList">
                <label>促销</label>
                <select class="form-control inputXt" name="isPromotion" id="isPromotion">
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </div>
            <div class="filedList">
                <label>时令水果</label>
                <select class="form-control inputXt" name="isSeason" id="isSeason">
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </div>
            <div class="filedList">
                <label>上架</label>
                <select class="form-control inputXt" name="isShelves" id="isShelves">
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </div>
            <div class="filedList">
                <label>水果描述</label>
                <textarea class="form-control inputXt" name="description"
                          style="width:500px;height:200px;
                          display: inline-block;vertical-align:top">${product.description}</textarea>
            </div>
        </div>
        <div class="aptitudeInfo ui-box">
            <h3>产品图片</h3>
            <div class="row">
                <c:set var="num2" value="0"/>
                <c:forEach items="${productImgList}" var="productImg" varStatus="status">
                    <div class="col-md-4 col-sm-4 ui-box-col" style="margin-top: 10px;margin-left:10px;">
                        <div class="js_uploadBox zh-img">
                            <a href="javascript:;" class="file">
                                <input type="file" name="productImg_${status.index + 1}" onchange="productImgChange('${productImg}')" class="js_upFile" multiple/>
                            </a>
                            <div class="js_showBox">
                                <img  src="${ctx}/${productImg}"/>
                            </div>
                            <div class="img_bg bg-two"><span>添加照片</span></div>
                        </div>
                    </div>
                    <c:set var="num2" value="${status.index + 1}"/>
                </c:forEach>
                <c:if test="${num2 < 4}">
                    <c:forEach var="i" begin="1" end="${4-num2}">
                        <div class="col-md-4 col-sm-4 ui-box-col" style="margin-top: 10px;margin-left:10px;">
                            <div class="js_uploadBox zh-img">
                                <a href="javascript:;" class="file">
                                    <input type="file" name="productImg+${5-i}" class="js_upFile" multiple/>
                                </a>
                                <div class="js_showBox">
                                    <img  src="" />
                                </div>
                                <div class="img_bg bg-two"><span>添加照片</span></div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <div class="aptitudeInfo ui-box">
            <h3>产品详情图</h3>
            <div class="row">
                <c:set var="num" value="0"/>
                <c:forEach items="${detailImgList}" var="detailImg" varStatus="status">
                    <div class="col-md-4 col-sm-4 ui-box-col" style="margin-top: 10px;margin-left:10px;">
                        <div class="js_uploadBox zh-img">
                            <a href="javascript:;" class="file">
                                <input type="file" name="detailImg+${status.index + 1}" onchange="detailImgChange('${detailImg}')" class="js_upFile" multiple/>
                            </a>
                            <div class="js_showBox">
                                <img  src="${ctx}/${detailImg}" />
                            </div>
                            <div class="img_bg bg-two"><span>添加照片</span></div>
                        </div>
                    </div>
                    <c:set var="num" value="${status.index + 1}"/>
                </c:forEach>
                <c:if test="${num < 6}">
                    <c:forEach var="i" begin="1" end="${6-num}">
                        <div class="col-md-4 col-sm-4 ui-box-col" style="margin-top: 10px;margin-left:10px;">
                            <div class="js_uploadBox zh-img">
                                <a href="javascript:;" class="file">
                                    <input type="file" name="detailImg+${8-i}" class="js_upFile" multiple/>
                                </a>
                                <div class="js_showBox">
                                    <img  src="" />
                                </div>
                                <div class="img_bg bg-two"><span>添加照片</span></div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <!--提交取消-->
        <div class="bus-ground-btn">
            <a id="addProductForm_btn" class="btn btn-enter">&nbsp;确定</a>
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
<script type="text/javascript" src="${ctx}/static/js/lib/jquery.uploadView.js"></script>
<script type="text/javascript" src="${ctx}/static/js/commonForm.js"></script>
<script type="text/javascript" src="${ctx}/static/js/product/productOperate.js"></script>
<script type="text/javascript" src="${ctx}/static/js/scroll.js"></script>
<script type="text/javascript">
    $(function(){
        $scroll.initScroll();
        $productOperate.initProductOperate('${ctx}');
    });

    function dictChange(){
        var typeId = $("#typeId").val();
        //查询水果品种
        $.ajax({
            type:'post',
            url:'${ctx}/back/category/findCateByCode',
            data:{typeId:typeId},
            async: false,
            success:function (data) {
                var str = "<option value=''>---请选择---</option>";
                for(var i=0;i<data.length;i++){
                    str= str + "<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>" ;
                }
                $("#categoryId").html(str);
            }
        });
    }

    var typeIds = '${product.typeId}';
    typeId = $("#typeId").val(typeIds);
    dictChange();
    $("#categoryId").val('${product.categoryId}');
    $("#isShelves").val('${product.isShelves}');
    $("#isSeason").val('${product.isSeason}');
    $("#isPromotion").val('${product.isPromotion}');

    function detailImgChange(imgPath){
        var imgs = $("#detailImg").val();
        var strArr = imgs.split(",");
        var b="";
        for(var i=0;i<strArr.length;i++){
            if(!(strArr[i] == imgPath)){
                b = b + strArr[i] + ",";
            }
        }
        b = b.substring(0,b.length-1);
        $("#detailImg").val(b);
    }

    function productImgChange(imgPath){
        var imgs = $("#productImg").val();
        var strArr = imgs.split(",");
        var b="";
        for(var i=0;i<strArr.length;i++){
            if(!(strArr[i] == imgPath)){
                b = b + strArr[i] + ",";
            }
        }
        b = b.substring(0,b.length-1);
        $("#productImg").val(b);
    }
</script>
</html>
