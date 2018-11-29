package com.skss.city_show.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skss.city_show.BaseTest;
import com.skss.city_show.entity.ProductCategory;

public class ProductCategoryDaoTest extends BaseTest{
  @Autowired
   private IproductCategoryDao  productCatagoryDao;
  @Test
	public void testqueryProductCategoryList() throws Exception{
	   long shopId=45;
	  List<ProductCategory> productCategoryList=productCatagoryDao.queryProductCategoryList(shopId);
	  System.out.println("商品类别列表长度：："+productCategoryList.size());
   }
	
	
}
