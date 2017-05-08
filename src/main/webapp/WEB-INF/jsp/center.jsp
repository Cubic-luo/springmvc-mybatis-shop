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
<title>我的</title>
<script src="../js/common.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="../css/base.css" />
<link rel="stylesheet" type="text/css" href="../css/my.css" />
</head>
<body>
	<!-- 登录部分开始 -->
	<div class="login">
		<img class="touxiang" src="<%=basePath%>img/${user.imgUrl}" alt="">
		<!-- 头像 -->
		<div class="username">${user.username }</div>
		<!--登录后，则显示如下内容   结束-->
	</div>
	<!-- 登录部分结束 -->
	<div class="middle">
		<p>
			<a href="<%=basePath%>/aboutUs"><img
				src="<%=basePath%>img/aboutus.png" alt="">关于我们</a>
		</p>
	</div>
	<!-- 注销开始 -->
	<form action="<%=basePath%>logout">
		<input class="zhuxiao" type="submit" value="注销">
	</form>
	<!-- 注销结束 -->
	<!-- 底部菜单开始 -->
	<ul class="bottomMenu">
		<li><a href="<%=basePath%>"> <img
				src="<%=basePath%>img/index2.png" alt="">
				<p>首页</p>
		</a></li>
		<li><a href="<%=basePath%>user/orders"> <img
				src="<%=basePath%>img/order2.png" alt="">
				<p>订单</p>
		</a></li>
		<li><a href="<%=basePath%>user/center"> <img
				src="<%=basePath%>img/me1.png" alt="">
				<p>我的</p>
		</a></li>
	</ul>
	<!-- 底部菜单结束 -->
	<script type="text/javascript" src="../js/Zepto1.2.0.js"></script>
	<script src="../js/touch.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>