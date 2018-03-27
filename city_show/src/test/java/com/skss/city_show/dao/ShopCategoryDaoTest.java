package com.skss.city_show.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skss.city_show.BaseTest;
import com.skss.city_show.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest{

  @Autowired
  private IshopCategoryDao iShopCategoryDao;
	@Test
  public void testShopCategory(){
		ShopCategory shopCategory=new ShopCategory();
		shopCategory.setShopCategoryId(3L);
		ShopCategory shopCategoryParent=new ShopCategory();
		shopCategoryParent.setParent(shopCategory);
		List<ShopCategory> shopCategoryList=iShopCategoryDao.getShopCategoryList(shopCategoryParent);
	
		System.out.println("shopCategory的长度是："+shopCategoryList.size());
		
		
		//System.out.println("shopCategor第二个对象的名字是："+shopCategoryList.get(1).getShopCategoryName());
	for(ShopCategory name:shopCategoryList){
		System.out.println("所有的类别名字:"+name.getShopCategoryName());
	}
		
		
}
}