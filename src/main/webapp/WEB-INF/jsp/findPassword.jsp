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
		<meta name="description" content="犹太中心">
		<meta name="keywords" content="犹太中心">
		<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
		<title>找回密码</title>
		<script type="text/javascript" src="<%=basePath %>js/Zepto1.2.0.js" ></script>
		<script src="<%=basePath %>js/common.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/base.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/register.css"/>
	</head>
	<body>
		<!-- 登录表单开始 -->
		<form class="registerForm" action="" method="">
			<div>
				<label for="username">用户名</label>
				<input type="text" id="username" placeholder="请输入手机号码">
			</div>
			<div class="codeBox">
				<label for="">验证码</label>
				<input type="text" placeholder="请输入验证码">
				<button type="button" class="getCode">获取验证码</button>
			</div>
			<div>
				<label for="pwd">密&nbsp;&nbsp;&nbsp;码</label>
				<input type="text" placeholder="请输入密码">
			</div>
			<div class="noBorderbottom">
				<label for="pwd">密&nbsp;&nbsp;&nbsp;码</label>
				<input type="text" placeholder="再次输入密码">
			</div>
			<div class="submitBtnBox">
				<input class="submitBtn findPasswordBtn" type="submit" value="提交">
			</div>
		</form>
		<!-- 登录表单结束 -->
		<!-- 忘记密码 -->
		<div class="forgetPwd">
			<span>还没有账号？</span>
			<a class="loginright" href="<%=basePath %>page/register">立即注册</a>
		</div>
		<!-- 忘记密码 -->
		
	</body>
</html>