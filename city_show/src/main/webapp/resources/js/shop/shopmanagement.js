/**
 * 进人单个页面管理
 */

$(function(){
	var shopId=getQueryString("shopId");
	var shopInfoUrl="/city_show/shopadmin/getshopmanagementinfo?shopId=" + shopId
	$.getJSON(shopInfoUrl,function(data){
		if(data.redirect){
			window.location.href=data.url;
		}else if(data.shopId!=undefined&&data.shopId!=null){
			shopId=data.shopId;
		}
		$("#shopInfo").attr('href','/city_show/shopadmin/shopoperation?shopId='+shopId);
	});
		
});