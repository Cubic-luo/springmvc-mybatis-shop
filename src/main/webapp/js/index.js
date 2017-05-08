//文字横向滚动
$(function() {
	function ScrollImgLeft() {
		var speed = 50;
		var MyMar = null;
		var scroll_begin = document.getElementById("scroll_begin");
		var scroll_end = document.getElementById("scroll_end");
		var scroll_div = document.getElementById("scroll_div");
		scroll_end.innerHTML = scroll_begin.innerHTML;
		function Marquee() {
			if (scroll_end.offsetWidth - scroll_div.scrollLeft <= 0)
				scroll_div.scrollLeft -= scroll_begin.offsetWidth;
			else
				scroll_div.scrollLeft++;
		}
		MyMar = setInterval(Marquee, speed);
		scroll_div.onmouseover = function() {
			clearInterval(MyMar);
		}
		scroll_div.onmouseout = function() {
			MyMar = setInterval(Marquee, speed);
		}
	}
	ScrollImgLeft();
})
// 外卖和超市切换功能,ok
$(function() {
	$(".left li").eq(0).addClass("leftActive")
	$(".orderSeat li").eq(0).tap(function() {
		$(this).addClass("titleActive").siblings().removeClass("titleActive");
		$(".shanpinBox").show();
		$(".discussBox").hide();
		$(".shangjiaBox").hide();
	})
	$(".orderSeat li").eq(1).tap(function() {
		$(this).addClass("titleActive").siblings().removeClass("titleActive");
		$(".shanpinBox").hide();
		$(".discussBox").show();
		$(".shangjiaBox").hide();
	})
	$(".orderSeat li").eq(2).tap(function() {
		$(this).addClass("titleActive").siblings().removeClass("titleActive");
		$(".shanpinBox").hide();
		$(".discussBox").hide();
		$(".shangjiaBox").show();
	})
})
// 滚动监听效果，点击效果
$(function() {
	$(".left li p").click(
			function() {
				var $leftIndex = $(this).parent().index(); // 获取点击的序号
				if ($(this).parents().hasClass("w-menuWrap")) {
					var $rigtIndex = $(".w-menuWrap .right ul").eq($leftIndex); // 获取右边对应的UL
				} else {
					$rigtIndex = $(".c-menuWrap .right ul").eq($leftIndex); // 获取右边对应的UL
				}
				$(this).parent().addClass("leftActive").siblings().removeClass(
						"leftActive"); // 增加活动样式
				var h1 = $(".logoBox").height() + $(".orderSeat").height() // 获取头部那些模块的高度和
				var h2 = $rigtIndex.offset().top // 指定大类offset
				if ($(this).parents().hasClass("w-menuWrap")) {
					var s1 = $(".w-menuWrap .right").scrollTop(); // 获取当前滚动条
					$(".w-menuWrap .right").scrollTop(s1 + h2 - h1);
				} else {
					s1 = $(".c-menuWrap .right").scrollTop(); // 获取当前滚动条
					$(".c-menuWrap .right").scrollTop(s1 + h2 - h1);
				}
			})
})
// 滚动监听，滚动效果
$(function() {
	var h1 = $(".logoBox").height() + $(".orderSeat").height() // 获取头部那些模块的高度和
	var h3 = $(".w-menuWrap .right h3").eq(0).height();

	function scroll66() {
		$(this).children("ul").each(
				function() {
					if ($(this).offset().top < (h1 + h3)) {
						var activeIndex = $(this).index();
						$(".w-menuWrap .left ul li").eq(activeIndex).addClass(
								"leftActive").siblings().removeClass(
								"leftActive");
					}
				})
	}
	// 启动滚动效果
	$(".w-menuWrap .right")[0].ontouchmove = function() {
		$(this).children("ul").each(
				function() {
					if ($(this).offset().top < (h1 + h3)) {
						var activeIndex = $(this).index();
						$(".w-menuWrap .left ul li").eq(activeIndex).addClass(
								"leftActive").siblings().removeClass(
								"leftActive");
					}
				})
	}
})

// 关闭购物车
$(".close12").tap(function() {
	$(".shoppingCartHide").hide(); // 购物车隐藏
	$(".shoppingCart").removeClass('shoppingCartShowActive');
})
// 购物车弹出效果
$(function() {
	var $show = $(".cartLogo");
	var $hide = $(".shoppingCartHide");
	$show.tap(function() {
		$hide.toggle();
		$(".shoppingCart").toggleClass('shoppingCartShowActive');
	})
})

// 滚动超出了内容界限是引发视图反弹问题
$(function() {
	function bodyScroll(event) {
		event.preventDefault();
	}
	$(".logoBox")[0].addEventListener('touchmove', bodyScroll, false);
	$(".orderSeat")[0].addEventListener('touchmove', bodyScroll, false);
	// $(".shoppingCartShow")[0].addEventListener('touchmove', bodyScroll,
	// false);
	$(".modalMengCeng").each(function() {
		$(this)[0].addEventListener('touchmove', bodyScroll, false); // 蒙层防触摸
	})
})
// 设置中间滑动部分的高度
function adjustHeight() {
	var $hTop = $(".logoBox").height() + $(".orderSeat").height() // 获取头部那些模块的高度和
	var $hBottom = $(".shoppingCartShow").height() + $(".bottomMenu").height(); // 获取底部购物车的高度
	var $hBody = $(window).height(); // 获取屏幕高度
	var $Hleft = $hBody - $hTop - $hBottom
	var $Hpinlun = $hBody - $hTop; // 评论框高度
	$(".discussBox").height($Hpinlun); // 设置评论框高度
	$(".shangjiaBox").height($Hpinlun); // 设置商家信息高度
	$(".left").height($Hleft); // 设置左边滑动区域高度
	$(".right").height($Hleft); // 设置右边滑动区域高度
}
$(function() {
	adjustHeight();
})

$(function() {
	function bodyScroll(event) {
		event.preventDefault();
	}
	$(".logoBox")[0].addEventListener('touchmove', bodyScroll, false);
	$(".orderSeat")[0].addEventListener('touchmove', bodyScroll, false);
	// $(".shoppingCartShow")[0].addEventListener('touchmove', bodyScroll,
	// false);
	$(".modalMengCeng").each(function() {
		$(this)[0].addEventListener('touchmove', bodyScroll, false); // 蒙层防触摸
	})
})
// 不在配送范围内提示框
$(function() {
	$(".tipOk").click(function() {
		$(".tipTanKuang").hide();
	})
})

// 超市商品详情弹框弹出，合并后,ok
$(function() {
	// 商品详情弹框弹出
	$(".right ul li .foodLogo").tap(
			function() {
				if ($(this).parents().hasClass('foodNull')) {
					return;
				}
				$(".fruitTanKuang").show(); // 商品详情弹框出现
				var $fruitImg = $(this).attr("src"); // 获取商品图片路径
				$(".fruitTanKuang .fruitTanKuangBody .fruitImg").attr('src',
						$fruitImg); // 把商品图片放入弹框
			})
	// 关闭商品详情弹框
	$(".fruitTanKuangClose").tap(function() {
		$(".fruitTanKuang").hide();
	})
})
//当页面刷新时，已经选择的商品的减号按钮和购物车显示出来， 默认是隐藏的
$(function() {
	for (var i = 0; i < $(".foodNumber1").length; i++) {
		if (parseInt($(".foodNumber1").eq(i).text()) > 0) {
			$(".foodNumber1").eq(i).show();
			$(".foodNumber1").eq(i).siblings().show();
			$(".shoppingCartShow").show();
		}
	}

})
// 增加一个商品到购物车，ajax请求
$(function() {
	// 商品加
	$(".jiaLogo").click(
			function() {

				$(this).siblings(".jianLogo,.foodNumber1").show();
				var url = $(this).attr("url");
				var total = 0;// 购物车商品总价
				var amount = 0;// 购物车商品总数量
				$.ajax({
					type : 'POST',
					url : url,
					dataType : 'json',
					success : function(result) {

						var shopingCart = result.data;
						if (shopingCart) {

							$('.shoppingCartShow').show();// 现实购物车
							$('.shoppingCart').removeClass(
									"shoppingCartShowActive")

						}
						var html = '';
						$(".foodNumber1").text(0);// 单个商品数量清零
						for ( var i in shopingCart) {
							html += '<div class="shopCartList clearfix">'
									+ '<span>' + shopingCart[i].name
									+ '</span>' + '<span>' + 'x'
									+ shopingCart[i].number + '</span>'
									+ '<span>' + '￥' + shopingCart[i].price
									+ '</span>' + '</div>';
							$(".numberId" + shopingCart[i].id).text(
									shopingCart[i].number)

						}
						// 计算购物车总价和总数量
						for ( var i in shopingCart) {
							total += shopingCart[i].number
									* shopingCart[i].price;
							amount += shopingCart[i].number;
						}
						$(".listNumber").html(amount);// 总数量放入购物车
						$('.sumMoney').html('￥' + total);// 总价放入购物车
						$(".content666").html(html);
						if (amount > 0) {
							// 购物车商品总量大于0，则显示购物车
							$(".shoppingCartShow").show();
							adjustHeight();

						} else {
							$(".shoppingCartShow").hide();
							adjustHeight();
						}
					},
					error : function(xhr, type) {
						alert('Ajax error!')
					}
				})

			})
	// 增加一个商品到购物车，ajax请求

	// 商品减
	$(".jianLogo")
			.click(
					function() {
						var url = $(this).attr("url");
						var numberT = parseInt($(this).siblings(".foodNumber1")
								.text());

						if (numberT < 2) {
							$(this).siblings(".foodNumber1").hide();
							$(this).hide();
						}

						var total = 0;// 购物车商品总价
						var amount = 0;// 购物车商品总数量
						$
								.ajax({
									type : 'POST',
									url : url,
									dataType : 'json',
									success : function(result) {
										var shopingCart = result.data;
										if (shopingCart) {
											$('.shoppingCartShow').show();// 现实购物车
										}
										var html = '';
										$(".foodNumber1").text(0);// 单个商品数量清零
										for ( var i in shopingCart) {

											html += '<div class="shopCartList clearfix">'
													+ '<span>'
													+ shopingCart[i].name
													+ '</span>'
													+ '<span>'
													+ shopingCart[i].number
													+ '</span>'
													+ '<span>'
													+ shopingCart[i].price
													+ '</span>' + '</div>';

											$(".numberId" + shopingCart[i].id)
													.text(shopingCart[i].number)

										}
										// 计算购物车总价和总数量
										for ( var i in shopingCart) {
											total += shopingCart[i].number
													* shopingCart[i].price;
											amount += shopingCart[i].number;
										}

										$(".listNumber").text(amount);// 总数量放入购物车
										$('.sumMoney').text(total);// 总价放入购物车
										$(".content666").html(html);
										if (amount > 0) {
											// 购物车商品总量大于0，则显示购物车
											$(".shoppingCartShow").show();
											adjustHeight();

										} else {
											$(".shoppingCartShow").hide();
											adjustHeight();
										}
									},
									error : function(xhr, type) {
										alert('Ajax error!')
									}
								})

						if (amount < 1) {
							$(".shoppingCartHide").hide();
							$(".shoppingCartShow").hide();// 隐藏购物车
						}

					})
	// 清空购物车
	$(".emptyCart").click(function() {
		var url = $(this).attr("url");
		$.ajax({
			type : 'POST',
			url : url,
			dataType : 'json',
			success : function(result) {
				$(".content666").html('');
				$(".foodNumber1").text(0);
				$(".listNumber").text(0);// 总数量放入购物车
				$('.sumMoney').text(0);// 总价放入购物车
				$(".shoppingCartHide").hide();
				$(".shoppingCartShow").hide();// 隐藏购物车
				$(".jianLogo,.foodNumber1").hide();
				adjustHeight();
			},
			error : function(xhr, type) {
				alert('Ajax error!')
			}
		})

	})
})