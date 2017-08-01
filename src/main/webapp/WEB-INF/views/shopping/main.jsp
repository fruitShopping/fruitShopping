<%--
  Created by IntelliJ IDEA.
  User: zcf
  Date: 2017/7/15
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>点鲜果商城</title>
    <link rel="stylesheet" href="${ctx}/static/css/head_foot.css" />
    <link rel="stylesheet" href="${ctx}/static/css/index.css" />
</head>

<body>
<div class="head">
    <!-- 京东的头部导航nav -->
    <div class="shortcut">
        <div class="w">
            <!--nav的left-->

            <div class="fl">
                <img src="${ctx}/static/img/pscar.png" style="float: left;margin-top: 9px;" />
                <div class="dt" style="float: left;">
                    送至：北京<i><s>◇</s></i>
                </div>
                <span>&nbsp;&nbsp;欢迎来到</span>
                <span class="titleColor">点鲜果水果商城</span>
            </div>
            <!--nav的right-->
            <div class="fr">
                <ul>
                    <li>
                        <a href="#" target="_blank" class="col-red">免费注册</a>
                        <a href="登录/登录界面.html">&nbsp;&nbsp;&nbsp;&nbsp;你好，请[登录]</a>
                    </li>

                    <li class="line"></li>
                    <li>我的水果</li>

                    <li class="line"></li>
                    <li>招商引入</li>

                    <li class="line"></li>
                    <li>客服服务</li>

                    <li class="line"></li>
                    <li>购物车</li>

                    <li class="line"></li>
                    <li class="fore">
                        <img src="${ctx}/static/img/phone.png" />
                        <span class="titleColor">4000-000-000</span>
                    </li>

                </ul>
            </div>
        </div>
    </div>
    <!-- 京东的头部导航nav结束 -->
</div>
<!--TopCenter部分-->
<div class="w clearfix">
    <div class="logo">
        <div class="db11">
            <a href="htps://www.jd.com"><img src="${ctx}/static/img/logo-201305.png"> </a>
        </div>
        <div class="tabCom">
            <ul class="titleComs">
                <li>
                    <p>首页</p>
                    <span style="margin-left: 26px;">Home</span>
                </li>
                <li>
                    <p>水果直销</p>
                    <span>Selling</span>
                </li>
                <li>
                    <p>促销活动</p>
                    <span>Activity</span>
                </li>
                <li>
                    <p>时令水果</p>
                    <span>Time</span>
                </li>
            </ul>
        </div>
    </div>
    <div class="search">
        <input type="text" name="" id="" placeholder="香梨" />
        <ul class="hot_kinds">
            <li>香梨</li>
            <li>车厘子</li>
            <li>凤梨</li>
            <li>山竹</li>
            <li>芒果</li>
        </ul>
    </div>
    <div class="car">
        <span class="iocn1"></span>
        <span class="iocn3">0</span>
    </div>
</div>

<div class="content">
    <div class="banner">
        <div class="w">
            <div class="list">
                <div class="sell_show">
                    <img src="${ctx}/static/img/tab.png" />
                    <span>所有商品列表</span>
                </div>
                <div class="item">
                    <img src="${ctx}/static/img/Imported-Food.png" />
                    <span class="outfoot">进口食品</span>
                    <span class="trg">></span>
                    <ul>
                        <li>
                            <a href="#"><span>奇异果</span></a>
                        </li>
                        <li>
                            <a href="#"><span>凤梨</span></a>
                        </li>
                        <li>
                            <a href="#"><span>车厘子</span></a>
                        </li>
                    </ul>
                </div>
                <div class="item">
                    <img src="${ctx}/static/img/fruit.png" />
                    <span class="outfoot">新鲜水果</span>
                    <span class="trg">></span>
                    <ul>
                        <li>
                            <a href="#"><span>苹果</span></a>
                        </li>
                        <li>
                            <a href="#"><span>香梨</span></a>
                        </li>
                        <li>
                            <a href="#"><span>西瓜</span></a>
                        </li>
                        <li>
                            <a href="#"><span>橙子</span></a>
                        </li>
                    </ul>
                    </ul>
                </div>
                <div class="item">
                    <img src="${ctx}/static/img/sock-.png" />
                    <span class="outfoot">甜品零食</span>
                    <span class="trg">></span>
                    <ul>
                        <li>
                            <a href="#"><span>奇异果</span></a>
                        </li>
                        <li>
                            <a href="#"><span>凤梨</span></a>
                        </li>
                        <li>
                            <a href="#"><span>车厘子</span></a>
                        </li>
                    </ul>
                </div>
                <div class="item">
                    <img src="${ctx}/static/img/seasoning.png" />
                    <span class="outfoot">进口食品</span>
                    <span class="trg">></span>
                    <ul>
                        <li>
                            <a href="#"><span>奇异果</span></a>
                        </li>
                        <li>
                            <a href="#"><span>凤梨</span></a>
                        </li>
                        <li>
                            <a href="#"><span>车厘子</span></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="huaban">
                <img src="${ctx}/static/img/huabian.png" />
            </div>
        </div>
    </div>
    <div class="show_img w">
        <img src="${ctx}/static/img/class1.png" style="margin-left: 20px;" />
        <img src="${ctx}/static/img/class1.2.png" />
        <img src="${ctx}/static/img/class1.3.png" />
        <img src="${ctx}/static/img/class1.4.png" />
    </div>
    <div class="w hot_thing">
        <p class="title">-热销好货-</p>
        <ul class="w">
            <li>
                <img src="${ctx}/static/img/ningmeng.png" class="bigshow" />
                <span class="name">四川安岳柠檬</span>
                <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>
                <p class="infor">
                    <span class="price">¥19.9</span>
                    <span class="number">/1斤</span>
                </p>
            </li>
            <li>
                <img src="${ctx}/static/img/yezi.png" class="bigshow" />
                <span class="name">易拉椰汁皇</span>
                <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>
                <p class="infor">
                    <span class="price">¥39.9</span>
                    <span class="number">/2个</span>
                </p>
            </li>
            <li>
                <img src="${ctx}/static/img/ningmeng.png" class="bigshow" />
                <span class="name">南非葡萄柚</span>
                <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>
                <p class="infor">
                    <span class="price">¥39.9</span>
                    <span class="number">/6个</span>
                </p>
            </li>
            <li>
                <img src="${ctx}/static/img/ningmeng.png" class="bigshow" />
                <span class="name">台湾爱文芒果</span>
                <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>
                <p class="infor">
                    <span class="price">¥58.0</span>
                    <span class="number">/1斤</span>
                </p>
            </li>
            <li>
                <img src="${ctx}/static/img/ningmeng.png" class="bigshow" />
                <span class="name">台湾爱文芒果</span>
                <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>
                <p class="infor">
                    <span class="price">¥58.0</span>
                    <span class="number">/1斤</span>
                </p>
            </li>

            <li style="margin-top: 0px;">
                <img src="${ctx}/static/img/ningmeng.png" class="bigshow" />
                <span class="name">四川安岳柠檬</span>
                <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>
                <p class="infor">
                    <span class="price">¥19.9</span>
                    <span class="number">/1斤</span>
                </p>
            </li>
            <li style="margin-top: 0px;">
                <img src="${ctx}/static/img/yezi.png" class="bigshow" />
                <span class="name">易拉椰汁皇</span>
                <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>
                <p class="infor">
                    <span class="price">¥39.9</span>
                    <span class="number">/2个</span>
                </p>
            </li>
            <li style="margin-top: 0px;">
                <img src="${ctx}/static/img/ningmeng.png" class="bigshow" />
                <span class="name">南非葡萄柚</span>
                <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>
                <p class="infor">
                    <span class="price">¥39.9</span>
                    <span class="number">/6个</span>
                </p>
            </li>
            <li style="margin-top: 0px;">
                <img src="${ctx}/static/img/ningmeng.png" class="bigshow" />
                <span class="name">台湾爱文芒果</span>
                <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>
                <p class="infor">
                    <span class="price">¥58.0</span>
                    <span class="number">/1斤</span>
                </p>
            </li>
            <li style="margin-top: 0px;">
                <img src="${ctx}/static/img/ningmeng.png" class="bigshow" />
                <span class="name">台湾爱文芒果</span>
                <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>
                <p class="infor">
                    <span class="price">¥58.0</span>
                    <span class="number">/1斤</span>
                </p>
            </li>

        </ul>
    </div>
    <div class="w hot_fruit">
        <div class="hot_top">
            <div class="top_left">
                <i></i>
                <span class="top_title">Hot</span>
                <span class="top_label">热卖水果</span>
            </div>
            <div class="top_right">
                <span>查看全部&nbsp;></span>
            </div>
        </div>
        <div class="hot_bottom">
            <img src="${ctx}/static/img/banner-left.png" class="bottom_left" />
            <img src="${ctx}/static/img/information.png" class="in_detail" />
            <div class="bottom_right">
                <ul>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>
                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>

                </ul>
            </div>
        </div>
    </div>
    <div class="w small_colomn">
        <img src="${ctx}/static/img/banner-moddle.png" />
    </div>
    <div class="w hot_fruit">
        <div class="hot_top">
            <div class="top_left">
                <i></i>
                <span class="top_title">Hot</span>
                <span class="top_label">热卖水果</span>
            </div>
            <div class="top_right">
                <span>查看全部&nbsp;></span>
            </div>
        </div>
        <div class="hot_bottom">
            <img src="${ctx}/static/img/banner-left2.png" class="bottom_left" />
            <img src="${ctx}/static/img/information.png" class="in_detail" />
            <div class="bottom_right">
                <ul>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>

                </ul>
            </div>
        </div>
    </div>
    <div class="w small_colomn">
        <img src="${ctx}/static/img/banner-moddle.png" />
    </div>
    <div class="w hot_fruit">
        <div class="hot_top">
            <div class="top_left">
                <i></i>
                <span class="top_title">Hot</span>
                <span class="top_label">热卖水果</span>
            </div>
            <div class="top_right">
                <span>查看全部&nbsp;></span>
            </div>
        </div>
        <div class="hot_bottom">
            <img src="${ctx}/static/img/banner-left3.png" class="bottom_left" />
            <img src="${ctx}/static/img/information.png" class="in_detail" />
            <div class="bottom_right">
                <ul>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">四川安岳柠檬</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>
                    <li>
                        <img src="${ctx}/static/img/qiyiguo.png" class="bigshow" />
                        <p class="name">易拉椰汁皇</p>
                        <p class="infor">
                            <span class="price">¥39.9</span>
                            <span class="number">/2个</span>
                        </p>
                        <a href="#"><img src="${ctx}/static/img/-shopping-cart2.png" class="shopping" /></a>

                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>
<div class="foot ">
    <img src="${ctx}/static/img/loop.png" class="trangle" />
    <div class="bg w">
        <div class="lamn">
            <ul>
                <li style="margin-left: 80px;">
                    <img src="${ctx}/static/img/you.png" />
                    <span>品质保障</span>
                </li>
                <li>
                    <img src="${ctx}/static/img/tong.png" />
                    <span>同城服务</span>
                </li>
                <li>
                    <img src="${ctx}/static/img/hui.png" />
                    <span>直销优惠</span>
                </li>
                <li>
                    <img src="${ctx}/static/img/cheng.png" />
                    <span>诚信经营</span>
                </li>
            </ul>
        </div>
        <div class="intro">
            <dl style="margin-left: 150px;">
                <dt>购物指南</dt>
                <dd>
                    <a href="#">免费注册</a>
                </dd>
            </dl>

            <dl>
                <dt>品质保证</dt>
                <dd>
                    <a href="#">发票保障</a>
                </dd>
                <dd>
                    <a href="#">售后规则</a>
                </dd>
                <dd>
                    <a href="#">缺货赔付</a>
                </dd>
            </dl>

            <dl>
                <dt style="margin-right: 100px;">支付方式</dt>
                <dd>
                    <a href="#">快捷支付</a>
                </dd>
                <dd>
                    <a href="#">信用卡</a>
                </dd>
                <dd>
                    <a href="#">货到付款</a>
                </dd>
            </dl>

            <dl style="text-align: center;margin-left: 115px;">
                <dt style="margin-right: 0px;">商家服务</dt>
                <dd>
                    <a href="#">商家入驻</a>
                </dd>
                <dd>
                    <a href="#">商家中心</a>
                </dd>
                <dd>
                    <a href="#">商家规则</a>
                </dd>
                <dd>
                    <a href="#">物流服务</a>
                </dd>
            </dl>
        </div>
    </div>
</div>
</body>

</html>
