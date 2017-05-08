//响应式调节HTML根节点字体大小开始,rem
(function() {
	// deicePixelRatio ：设备像素
	var dpr = window.devicePixelRatio;
	var scale = 1 / dpr;

	//设置meta 压缩界面 模拟设备的高分辨率
	document.querySelector('meta[name="viewport"]').setAttribute('content', 'width=device-width,initial-scale=' + scale + ', maximum-scale=' + scale + ', minimum-scale=' + scale + ', user-scalable=no');
	var reSize = function() {
		var clientWidth = document.documentElement && document.documentElement.clientWidth || document.body.clientWidth || window.innerWidth
		var deviceWidth = clientWidth > 1300 ? 1300 : clientWidth;
		//按照750像素下字体为100px的标准来，得到一个字体缩放比例值 7.5
		document.documentElement.style.fontSize = (deviceWidth / 7.5) + 'px';
	};
	reSize(); //页面未转屏，也就是正常进入时调用一次，调节html字体大小
	//				节流函数开始
	function throttle(method, context) {
		clearTimeout(method.tId);
		method.tId = setTimeout(function() {
			method.call(context);
		}, 50);
	};
	//				节流函数结束
	window.onresize = function() {
		throttle(reSize, window)
	};
})();
