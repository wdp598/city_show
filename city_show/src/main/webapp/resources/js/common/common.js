/**
 * 随即生成验证码
 */

function changeVerifyCode(img) {
	img.src = "../Kaptcha?" + Math.floor(Math.random() * 100);

}
/***
 * 根据参数获取参数的值
 */
/*
 * function getQueryString(name){ var reg=new
 * RegExp("(^|&)"+name+"=([^&*])(&|$)"); var
 * r=window.location.search.substr(1).match(reg); if(r!=null){ //return
 * decodeURIComponent(r[2]); return decodeURIComponent(r[2]); } return null; }
 */

function getQueryString(name) {
	var url = window.location.href;// url地址
	var params = window.location.search;// url后拼接参数
	var value = "";// 根据参数名返回参数值
	var startIndex = params.indexOf('?' + name + '=')
	// stringObject.indexOf(searchvalue,fromindex)
	var midIndex = params.indexOf('&' + name + '=')
	if (startIndex == 0) {// ?name=value
		var nextAnd = params.indexOf("&", startIndex);
		if (nextAnd == -1) {
			nextAnd = params.length;
		}
		value = params.substring(startIndex + (1 + name.length + 1), nextAnd);																			
	} else {// &name=value
		var nextAnd = params.indexOf("&", midIndex + 1);// 此处加1是过滤掉自身的&
		nextAnd = nextAnd == -1 ? params.length : nextAnd;// 三元运算符
		value = params.substring(midIndex + (1 + name.length + 1), nextAnd);
	}
	return value;
}
