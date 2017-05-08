
//时间选择弹框效果
$(function(){
//	var timing=new Date(); //获得现在时间
//	var ri=timing.getDate();//日
//	var yue=timing.getMonth()+1;//月份
//	var weekday=["星期日","星期一","星期二","星期三","星期四","星期五","星期六","星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
//	$(".timeListBoxLeft li").eq(0).text("今天"+"("+weekday[timing.getDay()]+")");//今天
//	$(".timeListBoxLeft li").eq(1).text(yue+"月"+(ri+1)+"日"+"("+weekday[timing.getDay()+1]+")");//今天的后1天
//	$(".timeListBoxLeft li").eq(2).text(yue+"月"+(ri+2)+"日"+"("+weekday[timing.getDay()+2]+")");//今天的后2天
//	$(".timeListBoxLeft li").eq(3).text(yue+"月"+(ri+3)+"日"+"("+weekday[timing.getDay()+3]+")");//今天的后3天
//	$(".timeListBoxLeft li").eq(4).text(yue+"月"+(ri+4)+"日"+"("+weekday[timing.getDay()+4]+")");//今天的后4天
//	$(".timeListBoxLeft li").eq(5).text(yue+"月"+(ri+5)+"日"+"("+weekday[timing.getDay()+5]+")");//今天的后5天
//	$(".timeListBoxLeft li").eq(6).text(yue+"月"+(ri+6)+"日"+"("+weekday[timing.getDay()+6]+")");//今天的后6天
	
	//点击日期弹出时间选框效果
	$(".peiSongTime").tap(function(){
		$(".timeTangKuang").toggle();
	})
	
	//选择星期
	$timeListBoxLeftLi=$(".timeListBoxLeft li")//获取左侧li
	$timeListBoxRightLi=$(".timeRightBox li")//获取右侧li
	$timeListBoxRightUl=$(".timeRightBox ul");//获取右侧ul
//	点击今天时
	$timeListBoxLeftLi.eq(0).tap(function(){
		$(".timeListBoxRight").hide();//隐藏右侧具体的时间框
		$(".rightawayBox").show()//显示立即送出选项
		$(".timeRightBox .rightaway").addClass("timeActiveRight");//标记右边具体选择时间为立即送出
		$(this).addClass("timeActive").siblings().removeClass("timeActive");//标记星期
		$newTimeLeft=$timeListBoxLeftLi.children(".timeActive").text();//选择标记好的星期
		$newTimeRight=$timeListBoxLeftLi.children(".timeActiveRight").text();//选择标记好的时间
})
//	点击其他日期
$timeListBoxLeftLi.eq(0).siblings().tap(function(){
	$lIndex=$(this).index();//左边的日期序号
	$timeListBoxRightUl.eq($lIndex+1).show().siblings().hide();//显示与当前左侧选择时间对应的右侧时间框
	$(this).addClass("timeActive").siblings().removeClass("timeActive");//标记星期
	$newTimeLeft=$timeListBoxLeftLi.children(".timeActive").text();//选择标记好的星期
	$newTimeRight=$timeListBoxLeftLi.children(".timeActiveRight").text();//选择标记好的时间
})
	
		//选中时间点
	$timeListBoxRightLi.tap(function(){
	$(this).addClass("timeActiveRight").siblings().removeClass("timeActiveRight");//标记时间
	$(this).parents("ul").siblings().children("li").removeClass("timeActiveRight");
	$(this).children("span").show();//显示钩钩
	$(this).siblings().children("span").has("img").hide(); //隐藏其他钩钩
	
	$newTimeLeft= $(".timeListBoxLeft .timeActive").text();//选择标记好的星期
	$newTimeRight=$(".timeRightBox .timeActiveRight").text();//选择标记好的时间
	
	$(".today").attr("value",$newTimeLeft);//把选中日期放到左边input的value里
	$(".todayBox").text($newTimeLeft)//把选中日期放到左边input的span里显示
	$(".now").attr("value",$newTimeRight);//把时间放到右边input的value里
	$(".nowBox").text($newTimeRight)//把选中日期放到右边input的span里显示
	setTimeout(function(){
		$(".timeTangKuang").hide()//弹框隐藏
	},500)
	
})
	
//	点击送货到家,收货地址栏出现,姓名栏隐藏
$(".toHome").tap(function(){
	$(".nameBox").hide()//隐藏姓名栏
	$(".address").show();//点击送货到家，出现收货地址
	$(".peiSongTime").addClass("noBorderbottom");
	$(".peiSongFei").show();//配送费出现
	$(".addAddress").show();//新增地址栏出现
})
//	点击自提,收货地址栏隐藏,姓名栏出现,配送费隐藏
$(".self").tap(function(){
	$(".nameBox").show()//隐藏姓名栏
	$(".address").hide();//点击送货到家，出现收货地址
	$(".peiSongTime").removeClass("noBorderbottom");
	$(".peiSongFei").hide();//配送费出现
	$(".addAddress").hide();//新增地址栏隐藏
})	
})
//滚动超出了内容界限是引发视图反弹问题
$(function() {
	function bodyScroll(event) {
		event.preventDefault();
	}
	$(".mengceng")[0].addEventListener('touchmove', bodyScroll, false);
	$(".modalMengCeng").each(function(){
		$(this)[0].addEventListener('touchmove', bodyScroll, false);//蒙层防触摸
	}) 
	$(".Go")[0].addEventListener('touchmove', bodyScroll, false);//蒙层防触摸
})

$(function(){
	$(".jifen p img").tap(function(){
		$(".jifen p img").toggle();
	})
})