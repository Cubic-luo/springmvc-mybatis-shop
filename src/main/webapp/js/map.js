// 控制清除搜索框按钮
$(function() {
		$(".inputBox").bind('input porpertychange', function() {
			if ($(".inputBox").val() != "") {
				$(".clearSearch").show();
			} else {
				$(".clearSearch").hide();
			}
		});
		// 点击清除
		$(".clearSearch").click(function() {
			$(".inputBox").val(""); //清除搜索框内容
			$(this).hide(); //隐藏清除按钮
		})
	})
	// 地图开始
$(function() {
		var mapObj = new AMap.Map('mapContainer', {
			zoom: 20,
			resizeEnable: true,
		})

		// 自动定位
		mapObj.plugin('AMap.Geolocation', function() {
			geolocation = new AMap.Geolocation({
				enableHighAccuracy: true, //是否使用高精度定位，默认:true
				timeout: 10000, //超过10秒后停止定位，默认：无穷大
				maximumAge: 0, //定位结果缓存0毫秒，默认：0
				convert: true, //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
				showButton: true, //显示定位按钮，默认：true
				buttonPosition: 'LB', //定位按钮停靠位置，默认：'LB'，左下角
				buttonOffset: new AMap.Pixel(10, 20), //定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
				showMarker: true, //定位成功后在定位到的位置显示点标记，默认：true
				showCircle: true, //定位成功后用圆圈表示定位精度范围，默认：true
				panToLocation: true, //定位成功后将定位到的位置作为地图中心点，默认：true
				zoomToAccuracy: true //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
			});
			mapObj.addControl(geolocation);
		});
	})
	// 地图结束

// 搜索结果tab 全部，学校，写字楼等的切换
$(function(){
	$(".tab li").click(function(){
		$(this).addClass('tabActive').siblings().removeClass('tabActive');
	})
})
