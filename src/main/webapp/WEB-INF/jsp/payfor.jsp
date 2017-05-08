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
<meta name="apple-mobile-web-app-title" content="">
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
<title>支付订单</title>
<script type="text/javascript" src="../js/Zepto1.2.0.js"></script>
<script src="<%=basePath%>js/common.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/payfor.css" />
</head>
<body>
	<form action="<%=basePath%>shopingCart/submit" method="post">
		<p class="money">
			支付金额 <span><c:out value="￥${sessionScope.total}" /></span>
		</p>
		<p class="style">支付方式</p>
		<div class="styleList">
			<!-- 支付宝 -->
			<p>
				<img class="logo" src="<%=basePath%>img/zhifubao.png" alt="">
				支付宝 <input checked="checked" name="payStyle" type="radio"
					id="zhifubao"> <label class="zhifubaoLb" for="zhifubao">
					<img style="display: none;" src="<%=basePath%>img/no.png" alt="">
					<img src="<%=basePath%>img/yes.png" alt="">
				</label>
			</p>
			<!-- 微信 -->
			<p>
				<img class="logo" src="<%=basePath%>img/weixin.png" alt=""> 微信
				<input name="payStyle" type="radio" id="weixin"> <label
					class="weixinLb" for="weixin"> <img
					src="<%=basePath%>img/no.png" alt=""> <img
					style="display: none;" src="<%=basePath%>img/yes.png" alt="">
				</label>
			</p>
			<!-- 餐到付款 -->
			<p>
				<img class="logo" src="<%=basePath%>img/can.png" alt=""> 现金 <input
					name="payStyle" type="radio" id="can"> <label class="canLb"
					for="can"> <img src="<%=basePath%>img/no.png" alt="">
					<img style="display: none;" src="<%=basePath%>img/yes.png" alt="">
				</label>
			</p>
		</div>
		<button class="submit" type="submit">确认支付
			${sessionScope.total }</button>
	</form>
	<script type="text/javascript">
		$(function() {
			// 选择支付宝
			$(".zhifubaoLb").click(function() {
				$(this).children('img').eq(0).hide().siblings().show();
				$(".weixinLb").children('img').eq(1).hide().siblings().show();
				$(".canLb").children('img').eq(1).hide().siblings().show();
			})
			// 选择微信
			$(".weixinLb").click(
					function() {
						$(this).children('img').eq(0).hide().siblings().show();
						$(".zhifubaoLb").children('img').eq(1).hide()
								.siblings().show();
						$(".canLb").children('img').eq(1).hide().siblings()
								.show();
					})
			// 选择餐到付款
			$(".canLb").click(
					function() {
						$(this).children('img').eq(0).hide().siblings().show();
						$(".zhifubaoLb").children('img').eq(1).hide()
								.siblings().show();
						$(".weixinLb").children('img').eq(1).hide().siblings()
								.show();
					})
		})
	</script>
</body>
</html>