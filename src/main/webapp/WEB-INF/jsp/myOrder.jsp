<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>订单</title>
<script src="../js/common.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="../css/base.css" />
<link rel="stylesheet" type="text/css" href="../css/dingDan.css" />
</head>
<body>


	<div class="dignDanBox">
		<div class="logoBox">
			<img src="../img/logo.jpg" alt="">小卖部 <span>我的订单</span>
		</div>
		<div class="container-fluid orderList">
			<c:forEach items="${orderList }" var="order">
				<div class="col-xs-4">总金额：${order.total }</div>
				<div class="col-xs-8">订单时间：<fmt:formatDate type="both" value="${order.creatTime }"/> </div>
			</c:forEach>
		</div>
	</div>

	<!-- 底部菜单开始 -->
	<ul class="bottomMenu">
		<li><a href="<%=basePath%>"> <img
				src="<%=basePath%>img/index2.png" alt="">
				<p>首页</p>
		</a></li>
		<li><a href="<%=basePath%>user/orders"> <img
				src="<%=basePath%>img/order1.png" alt="">
				<p>订单</p>
		</a></li>
		<li><a href="<%=basePath%>user/center"> <img
				src="<%=basePath%>img/me2.png" alt="">
				<p>我的</p>
		</a></li>
	</ul>
	<!-- 底部菜单结束 -->
	<!-- 评价弹框开始 -->
	<div class="modalOverlay pingjiaTanKuang">
		<!--弹框蒙层开始-->
		<div class="modalMengCeng"></div>
		<!--弹框蒙层结束-->
		<form action="">
			<!-- 弹框内容区域开始 -->
			<div class="modalpingjiaData">
				<h1>评价</h1>
				<p class="xingji">
					<img src="../img/xingji1.png" alt=""> <img
						src="../img/xingji1.png" alt=""> <img
						src="../img/xingji1.png" alt=""> <img
						src="../img/xingji1.png" alt=""> <img
						src="../img/xingji2.png" alt="">
				</p>
				<!-- 评价内容开始 -->
				<textarea placeholder="请输入评价内容"></textarea>
				<!-- 评价内容结束 -->
				<button class="quxiao" type="button">取消</button>
				<button class="sure" type="submit">确定</button>
			</div>
			<!-- 弹框内容区域结束 -->
		</form>
	</div>
	<!--评价弹框结束-->
	<!-- 取消订单弹框开始 -->
	<div class="modalOverlay quxiaoTanKuang">
		<!--弹框蒙层开始-->
		<div class="modalMengCeng"></div>
		<!--弹框蒙层结束-->
		<form action="">
			<!-- 弹框内容区域开始 -->
			<div class="modalquxiaoData">
				<p class="content">确定要取消订单么?</p>
				<button class="quxiaono" type="button">不取消</button>
				<button class="quxiaoyes" type="submit">确定</button>
			</div>
			<!-- 弹框内容区域结束 -->
		</form>
	</div>
	<!--取消订单结束-->
	<script type="text/javascript" src="../js/Zepto1.2.0.js"></script>
	<script src="../js/touch.js" type="text/javascript" charset="utf-8"></script>
	<script>
		$(function() {
			// 评价框
			$(".pingjiaBtn").click(function() {
				$(".pingjiaTanKuang").show();//点击页面评价按钮，弹出弹框
			})
			$(".quxiao").click(function() {
				$(".pingjiaTanKuang").hide();//点击评价框中的取消，弹框隐藏
			})
			$(".sure").click(function() {
				$(".pingjiaTanKuang").hide();//点击评价框中的确定，表单提交，弹框隐藏
			})
			// 取消订单弹框
			$(".no").click(function() {
				$(".quxiaoTanKuang").show();//点击页面取消订单按钮，弹出弹框
			})
			$(".quxiaono").click(function() {
				$(".quxiaoTanKuang").hide();//点击弹框中的取消，弹框隐藏
			})
			$(".quxiaoyes").click(function() {
				$(".quxiaoTanKuang").hide();//点击弹框中的确定，表单提交，弹框隐藏
			})
		})
		$(function() {
			function bodyScroll(event) {
				event.preventDefault();
			}
			$(".modalMengCeng").each(function() {
				$(this)[0].addEventListener('touchmove', bodyScroll, false); //蒙层防触摸
			})

		})
	</script>
</body>
</html>