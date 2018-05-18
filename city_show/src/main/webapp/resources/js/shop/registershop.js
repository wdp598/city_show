/**
 * 店铺注册时
 * 1先从数据库获取店铺区域，店铺类别展示在页面上供用户选择.
 * 2待用户填入或选择完整信息后 获取信息并提交
 */
$(function() {
	
	var initUrl = '/city_show/shopadmin/getshopinitinfo';
	var registerShopUrl = '/city_show/shopadmin/registershop';
	getShopInitInfo();/*调用自己，使得页面打开即有数据*/
	
	/**
	 * 
	 * 获取店铺区域，店铺类别并展示在页面上
	 */
	function getShopInitInfo() {
		$.getJSON(initUrl, function(data) {/*$.getJSON专门为ajax获取JSON数据*/
			if (data.success) {
				var tempHtml = '';
				var tempAreaHtml = '';
				data.shopCategoryList.map(function(item, index) {/*?????*/
					tempHtml += '<option data-id="' + item.shopCategoryId
							+ '">' + item.shopCategoryName + '</option>';
				});
				data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
							+ item.areaName + '</option>';
				});
				$('#shop-category').html(tempHtml);
				$('#shop-area').html(tempAreaHtml);
			}
		});
	}
	
	
	/**
	 * 获取店铺注册所有信息并提交
	 */
	$('#submit').click(function() {
		var shop = {};
		shop.shopName = $('#shop-name').val();
		if(!shop.shopName){
			/*$.toast('请输入店铺名字！')*/
			alert('请输入店铺名字！')
			return;
		}
		shop.shopAddr = $('#shop-addr').val();
		if(!shop.shopAddr){
			/*$.toast('请输入店铺名字！')*/
			alert('请输入店铺地址！')
			return;
		}
		shop.phone = $('#shop-phone').val();
		if(!shop.phone){
			/*$.toast('请输入店铺名字！')*/
			alert('请输入店铺电话！')
			return;
		}
		shop.shopDesc = $('#shop-desc').val();
		shop.shopCategory = {
			shopCategoryId : $('#shop-category').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		shop.area = {
			areaId : $('#shop-area').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		var shopImg = $('#shop-img')[0].files[0];
		if(!shopImg){
			/*$.toast('请输入店铺名字！')*/
			alert('请上传店铺图片！')
			return;
		}
		
		var formData = new FormData();
		formData.append('shopImg', shopImg);/*图片*/
		formData.append('shopStr', JSON.stringify(shop));/*店铺信息*/
		var verifyCodeActual = $('#shop-captcha').val();
		if (!verifyCodeActual) {
			$.toast('请输入验证码！')
			return;
		}
		formData.append('verifyCodeActual', verifyCodeActual);/*验证码*/
		
		
		/**
		 * 通过ajax提交到后台
		 */
		$.ajax({
			url : registerShopUrl,
			type : 'POST',
			data : formData,/*发送到服务器的数据*/
			contentType : false,
			processData : false,/*要发送的数据不要转换成对象*/
			cache : false,/*不从浏览器缓存中加载请求信息*/
			success : function(data) {
				if (data.success) {
					$.toast('提交成功')
					/*alert("提交成功")*/
				} else {
					$.toast('哈哈提交失败！' + data.errMsg);
				}
				$('#captcha-img').click();/*不论是否成功 都主动调用验证码控件的点击事件方法该变验证码*/
			}
		});
	});

})