package com.skss.city_show.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skss.city_show.BaseTest;
import com.skss.city_show.entity.ShopCategory;

public class ShopCategoryServiceTest extends BaseTest{
@Autowired
private IshopCategoryService iShopCategoryService;
   @Test
	public void testShopCategory(){
		List<ShopCategory> shopCategoryList=new ArrayList<ShopCategory>();
		shopCategoryList=iShopCategoryService.getShopCategoryList(new ShopCategory());
	for(ShopCategory shopCategory:shopCategoryList){
		System.out.println("shopCategoryService测试结果："+shopCategory.getShopCategoryName());
	}
		
   }
	
	
}
