<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!--优先使用最新版本 IE 和 Chrome-->
<meta name="apple-mobile-web-app-title" content="犹太中心">
<!--添加到主屏后的标题（IOS）-->
<meta name="apple-mobile-web-app-capable" content="yes" />
<!--启用 WebApp 全屏模式（IOS）-->
<meta name="apple-touch-fullscreen" content="yes" />
<!--启用 WebApp 全屏模式（IOS）-->
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--禁止百度转码-->
<meta name="format-detection" content="telephone=no" />
<!--关闭电话号码的自动识别-->
<meta content="email=no" name="format-detection" />
<!--关闭邮箱的自动识别-->
<meta name="msapplication-tap-highlight" content="no">
<!--winphone系统a、input标签被点击时产生的半透明灰色背景-->
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1,user-scalable=no">
<title>订单详情</title>
<script src="../js/common.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/dingdanDetai.css" />
</head>
<body style="padding-bottom: 1.2rem;">
	<div class="wrap state">
		<div>订单状态：待支付</div>
	</div>
	<!--订单详情开始-->
	<div class="wrap foodBox">
		<!-- 店铺开始 -->
		<div class="shopBox">
			<img src="../img/shop.png" alt="">小卖部
		</div>
		<!-- 店铺结束 -->
		<c:forEach items="${sessionScope.shopingCart}" var="goodsMap">
			<div class="container-fluid foodList">
				<div class="col-xs-8 foodName">
					<c:out value="${goodsMap.value.name }"></c:out>
				</div>
				<div class="col-xs-2 foodNumber">
					<c:out value="x${goodsMap.value.number }" />
				</div>
				<div class="col-xs-2 foodPrice">
					<c:out value="￥${goodsMap.value.price }" />
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- 订单计价开始 -->
	<div class="wrap">
		<div class="container-fluid foodList allMoney">
			<div class="col-xs-8 foodName"></div>
			<div class="col-xs-4 foodPrice activeColor">
				实付
				<c:out value="￥${sessionScope.total }" />
			</div>
		</div>
	</div>	
	<!-- 底部支付开始 -->
	<div class="payfor">
		<a href="<%=basePath%>">取消</a> <a href="<%=basePath%>shopingCart/payfor">付款</a>
	</div>
	<!-- 底部支付结束 -->
	<script type="text/javascript" src="<%=basePath%>js/Zepto1.2.0.js"></script>
</body>
</html>