/**
 * registershop
 */
alert("进入js")
$(function(){
	  var initUrl="/city_show/shopadmin/getshopinitinfo";//获取店铺类别与店铺区域的路径
	  var registerShopUrl="/city_show/shopadmin/registershop";//店铺注册的路径
	  getInitShopInfo();
	    function getInitShopInfo(){
	    	
	    	$.getJSON(initUrl,function(data){
	    		alert(registerShopUrl)
	    		alert("得到的数据是："+data)
	    		if(data.success){
	    			var tempShopCategoryHtml="";
	    			var tempAreaHtml="";
	    			data.shopCategoryList.map(function(item,index){//遍历map
	    				tempShopCategoryHtml+='<option data-id="'+item.shopCategoryId+'">'+item.shopCategoryName+'</option>';//店铺类别
	    				tempAreaHtml+='<option data-id="'+item.areaId+'">'+item.areaName+'</option>';//店铺区域
	    			});
	    			$('#shop-category').html(tempShopCategoryHtml);
	    			$('#area').html(tempAreaHtml);
	    		}
	    	});
	    }
	    /**
    	 *点击提交后，提交到后台处理
    	 */
    	$('#submit').click(function(){
    		var shop={};
    		shop.shopName=$('#shop-name').val();
    		//获取被选中的下拉列表
    		shop.shopCategory={
    				shopCategoryId:$('#shop-category').find('option').not(function(){
    					return !this.selected;//双重否定表肯定
    				}).data('id')
    		};
    		shop.area={
    				areaId:$('#area').find('option').not(function(){
    					return !this.selected;
    				}).data('id')
    		};
    		shop.shopAddr=$('#shop-addr').val();
    		shop.phone=$('#shop-phone').val();
    		//文件流选取
    		var shopImg=$('#shop-img')[0].files[0];
    		shop.shopDesc=$('#shop-desc').val();
    		var formData=new FormData();
    		formData.append('shopImg',shopImg);
    		formData.append('shopStr',JSON.stringify(shop));
    		$.ajax({
    			url:registerShopUrl,
    			type:'POST',
    			data:formData,
    			contentType:false,//传文件和文本信息
    			proceesData:false,
    			cache:false,
    			success:function(data){
    				if(data.success){
    					$.toast("提交成功");
    				}else{
    					$.toast("提交失败"+data.errMsg);
    				}
    				/**/
    			}
    		});
    	});
})




