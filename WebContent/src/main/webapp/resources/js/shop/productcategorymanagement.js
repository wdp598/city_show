/**
 * 商品类别
 */
$(function() {
	var listUrl = "/city_show/shopadmin/getproductcategorylist";
	var addUrl = "/city_show/shopadmin/addproductcategorys";
	var deleteUrl = "/city_show/shopadmin/removeproductcategory";
	getList()
/**
 * 获取商品类别列表
 */	
function getList() {
  $.getJSON(listUrl,function(data) {
	if (data.success) {
	  var dataList = data.data;
		$('.category-wrap').html('');
		 var tempHtml = '';
			dataList.map(function(item, index) {
			 tempHtml += ''
			         + '<div class="row row-product-category now">'
					 + '<div class="col-33 product-category-name">'
					 + item.productCategoryName
					 + '</div>'
					 + '<div class="col-33">'
					 + item.priority
					 + '</div>'
					 + '<div class="col-33"><a href="#" class="button delete" data-id="'
					 + item.productCategoryId
					 + '">删除</a></div>'
					 + '</div>';
			});
			  $('.category-wrap').append(tempHtml);
			  //$('.category-wrap').html(tempHtml);
	}
});
}
	/**
	 * 动态新增商品类别行
	 */
$('#new').click(function(){//点击一次“新增”就增加一行
	var tempHtml='<div class="row row-product-category temp">'
		+'<div class="col-33"><input class="category-input category" type="text" placeholder="类别名称"/></div>'
		+'<div class="col-33"><input class="category-input priority" type="text" placeholder="权重"/></div>'
		+'<div class="col-33"><a href="#" class="button delete">删除<a/></div>'
		+'</div>';
	/*$('.category-wrap').html(tempHtml);*/
	$('.category-wrap').append(tempHtml);
});
	//点击“提交”，将新增的商品类别提交到后台
$('#submit').click(function(){
	var productCategoryList=[];
	$('.temp').map(function(index,item){//遍历div
		var tempObj={};
		tempObj.productCategoryName=$(item).find('.category').val();
		tempObj.priority=$(item).find('.priority').val();
		if(tempObj.productCategoryName&&tempObj.priority){
			productCategoryList.push(tempObj);
		}
	})	;
	//提交
$.ajax({
	  url:addUrl,
     type:'POST',
     data:JSON.stringify(productCategoryList),//以字符串的形式传递到后台
     contentType:'application/json',
     success:function(data){
    	 if(data.success){
    		 $.toast("提交成功");
    		 getList();
    	 }else{
    		 $.toast("提交失败");
    	 }
     }   
})	
});
/**
 * 删除指定商品类别
 */
//事件绑定--没有提交到后台的删除方式
$('.category-wrap').on('click','.row-product-category.temp.delete',function(e){
	console.log($(this).parent().parent());
	$(this).parent().parent().remove();
});
//事件绑定--在数据中的商品类别删除方式
$('.category-wrap').on('click','.row-product-category.now.delete',function(e){
	var target=e.currentTarget;
	$.confirm('确定吗？',function(){
		$.ajax({
			url:removeproductcategory,
			type:'POST',
			data:{productCategoryId:target.dataset.id},
			dataType:'json',
			success:function(data){
				if(data.success){
					$.toast("删除成功");
					getList();
				}else{
					$.toast("删除失败");
				}
			}
		})
	})
});



});