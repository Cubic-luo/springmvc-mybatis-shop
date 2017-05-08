<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<meta name="description" content="犹太中心">
<meta name="keywords" content="犹太中心">
<meta name="viewport"
	content="width=device-width, initial-scale=1,user-scalable=no">
<title>门店页</title>
<script type="text/javascript" src="js/Zepto1.2.0.js"></script>
<script src="<%=basePath%>js/common.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css" />
</head>
<body>
	<!--顶部开始-->
	<div class="logoBox">
		<!-- 定位开始 -->
		<p class="locationBox">
			<img class="locationImg" src="<%=basePath%>img/location.png" alt=""><span>上海慧谷白猫科技园</span>
		</p>
		<!-- 定位结束 -->
		<!-- logo开始 -->
		<ul class="logo">
			<li class="indexlogo"><img src="<%=basePath%>img/logo.jpg"
				alt=""></li>
			<li class="topContent">
				<h1>小卖部</h1>
				<p>配送费6元&nbsp;|&nbsp;满50元免费配送</p>
				<div id="scroll_div" class="fl">
					<div id="scroll_begin">
						<a href="#">公告：用餐高峰期请提前一个小时下单,用餐高峰期请提前一个小时下单</a>
					</div>
					<div id="scroll_end"></div>
				</div>
			</li>
		</ul>
		<!-- logo结束 -->
	</div>
	<!--顶部结束-->
	<!--商品，评价，商家详情切换开始-->
	<ul class="orderSeat">
		<li class="titleActive">商品</li>
		<li>评价</li>
		<li>商家详情</li>
	</ul>
	<!--商品，评价，商家详情切换结束-->
	<!--商品开始-->
	<div class="shanpinBox">
		<div class="w-menuWrap">
			<!--左边菜单导航开始-->
			<div class="left">
				<ul>
					<c:forEach items="${productsTypeList}" var="productsType">
						<li>
							<p>${productsType.typeName }</p> <span class="listNumber1">0</span>
						</li>
					</c:forEach>
				</ul>
			</div>
			<!--左边菜单导航结束-->
			<!--右边菜开始-->
			<div class="right">
				<c:forEach items="${productsTypeList }" var="productsType">
					<ul>
						<h3>${productsType.typeName}</h3>
						<c:forEach items="${productsType.products}" var="products">

							<li class="container-fluid">
								<!--菜的图片开始-->
								<div class="FoodBoxTop col-xs-3">
									<img class="foodLogo"
										src="<%=basePath%>img/${products.imgUrl}" alt="" />
								</div> <!--菜的图片结束--> <!--右边描述开始-->
								<div class="FoodBoxBottom col-xs-9">
									<h4>${products.name}</h4>
									<p>月售${products.number}份</p>
									<!--价格开始-->
									<div>
										<span class="moneyLogo">￥</span> <span class="foodPrice">${products.price}</span>
										<!--价格结束-->
										<img url="<%=basePath%>shopingCart/${products.id}/reduce"
											class="jianLogo" src="<%=basePath%>img/jian.png" /> <span
											class="numberId${products.id}  foodNumber1"><c:forEach
												items="${sessionScope.shopingCart}" var="productsMap">
												<c:if test="${products.id==productsMap.key}">${productsMap.value.number }</c:if>
											</c:forEach> </span> <img class="jiaLogo"
											url="<%=basePath%>shopingCart/${products.id}/add"
											src="<%=basePath%>img/jia.png" />
									</div>
								</div> <!--右边描述结束-->
							</li>
						</c:forEach>
					</ul>
				</c:forEach>
			</div>
			<!--右边菜结束-->
		</div>
		<!--购物车开始-->
		<div class="shoppingCart">
			<!-- 用户登录后才显示如下代码 ,开始-->
			<sec:authorize access="isAuthenticated()">
				<input type="hidden" name="username"
					value="<sec:authentication property="principal.username" />">
			</sec:authorize>
			<!-- 用户登录后才显示如下代码，结束 -->
			<!--隐藏的部分开始-->
			<div class="shoppingCartHide">
				<p class="shoppingCartHideBtn clearfix">
					<span class="close12">关闭</span> <span>购物车</span> <span
						url='<%=basePath%>shopingCart/clear' class="emptyCart">清除</span>
				</p>
				<div class='content666'>
					<!-- 初始化购物车 -->
					<c:forEach items="${sessionScope.shopingCart}" var="productsMap">
						<div class="shopCartList clearfix">
							<span>${productsMap.value.name}</span> <span>
								${productsMap.value.number}</span> <span>
								￥${productsMap.value.price}</span>
						</div>
					</c:forEach>
				</div>
			</div>
			<!--隐藏的部分结束-->
			<!--显示在底部的部分开始-->
			<div class="shoppingCartShow">
				<span class="cartLogo"> <span class="imgbox1"> <img
						src="img/gouwuche2.png" />
				</span> <span class="listNumber">${sessionScope.amount }</span>
				</span> <span class="moneyLogo"></span> <span class="sumMoney">￥${sessionScope.total }</span>
				<!-- 	<input class="cartGo" type="submit" name="" id="" value="选好了" /> -->
				<a class="cartGo" href="<%=basePath%>shopingCart/confirmation">选好了</a>
			</div>
			<!--显示在底部的部分结束-->
		</div>
		<!--购物车结束-->
		<!-- 底部菜单开始 -->
		<ul class="bottomMenu">
			<li><a href="#"> <img src="img/index1.png" alt="">
					<p>首页</p>
			</a></li>
			<li><a href="<%=basePath%>user/orders"> <img
					src="img/order2.png" alt="">
					<p>订单</p>
			</a></li>
			<li><a href="<%=basePath%>user/center"> <img
					src="img/me2.png" alt="">
					<p>我的</p>
			</a></li>
		</ul>
		<!-- 底部菜单结束 -->
	</div>
	<!-- 商品结束 -->
	<!-- 评论开始 -->
	<div class="discussBox">
		<c:forEach items="${discussList }" var="discuss">
			<c:if test="${discuss.parentId==0 }">
				<div class="container-fluid discussContent">
					<!--评价内容开始-->
					<div class="col-xs-12 discussContentTxt">
						<!-- 对店铺的评论开始 -->
						<p>
							<span class="discussContentPhone"><c:out
									value="${discuss.user.username }" /> </span> <span
								class="discussContentTime"><fmt:formatDate type="both"
									value="${discuss.creatTime }" /></span>
						</p>
						<p class="discussStart">
							<img src="img/xingji1.png" alt="" /> <img src="img/xingji1.png"
								alt="" /> <img src="img/xingji1.png" alt="" /> <img
								src="img/xingji1.png" alt="" /> <img src="img/xingji1.png"
								alt="" />
						</p>
						<p class="discussTXT">
							<c:out value="${discuss.detail }" />
						</p>
						<!-- 对店铺的评论结束 -->
						<!-- 对此评论的回复开始 -->
						<c:forEach items="${discussList }" var="discussReply">
							<c:if
								test="${(discuss.id==discussReply.parentId)&&(discussReply.parentId>0)}">
								<p class="shangjiaRe">商家回复：${discussReply.detail }</p>
							</c:if>
						</c:forEach>
						<!-- 对此评论的回复结束 -->
					</div>
					<!--评价内容结束-->
				</div>
			</c:if>
		</c:forEach>
	</div>
	<!-- 评论结束 -->
	<!-- 商家详情开始 -->
	<div class="shangjiaBox">
		<div class="shangjiaBox1">
			<p class="borderBottom">
				<img src="img/yueshou.png" alt="">月售15478单
			</p>
			<p>
				<img src="img/peisongTime.png" alt="">配送时间：9:00-22:00
			</p>
		</div>
		<div class="shangjiaBox2">
			<p class="borderBottom">
				<img src="img/phone.png" alt="">02182563111<img class="p001"
					src="img/p001.png" alt="">
			</p>
			<p>
				<img src="img/address2.png" alt="">长宁区天山路641号
			</p>
		</div>
	</div>
	<!-- 商家详情结束 -->
	<!--清空购物车弹框开始-->
	<div class="modalOverlay emptyTanKuang">
		<!--弹框蒙层开始-->
		<div class="modalMengCeng"></div>
		<!--弹框蒙层结束-->
		<div class="modalEmptyData">
			<p class="modalEmptyDataHead">确定要清空购物车吗？</p>
			<p>
				<span class="emptyNo">取消</span> <span class="emptyOK">确定</span>
			</p>
		</div>
	</div>
	<!--清空购物车弹框结束-->
	<!--商品水果详情弹框开始-->
	<div class="modalOverlay fruitTanKuang">
		<!--弹框蒙层开始-->
		<div class="modalMengCeng"></div>
		<!--弹框蒙层结束-->
		<div class="fruitTanKuangBody">
			<img class="fruitImg" src="" alt="获取图片失败" title="商品图片" />
		</div>
		<img class="fruitTanKuangClose" src="img/guanbi2.png" alt="" />
	</div>
	<!--商品详情弹框结束-->

	<script type="text/javascript" src="<%=basePath%>js/touch.js"></script>
	<script src="<%=basePath%>js/index.js" type="text/javascript"
		charset="utf-8"></script>

</body>
</html>