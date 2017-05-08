<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
		<title>关于我们</title>
		<script src="<%=basePath %>js/common.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/base.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/my.css" />
		<style>
		body{
			background: #fff;
		}
			.aboutusbg{
				width: 100%;
				height: 4.8rem;
			}
			.content{
				padding: 0.28rem 0.4rem;
				font-size: 0.32rem;
				height: 100%;
				line-height: 1.6;
			}
		</style>
	</head>
	<body>
		<img class="aboutusbg" src="<%=basePath %>img/aboutusbg.png" alt="">
		<p class="content">是一家位于上海宁古北的犹太餐厅，由犹太人创立，主营Kosher食品，饮料，酒类，犹太特色点心，主要可群是上海市的犹太人，为上海的犹太人提供地道、正宗的犹太菜肴，食品，让他们在异国他乡也能品尝到来自家乡的味道，所有菜肴均采用复合Kosher认证的食品，完全复合犹太人的饮食标准和饮食习惯，该餐厅也是众多犹太人三五聚会的好场所，深受周遭尤其是古北一代的犹太人欢迎。</p>
		
	</body>
</html>