/**
 * 商品类别
 */
$(function() {
	var listUrl = "/city_show/shopadmin/getproductcategorylist";
	var addUrl = "/city_show/shopadmin/addproductcategorys";
	var deleteUrl = "/city_show/shopadmin/removeproductcategory";
	getList()
	
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

});