package com.skss.city_show.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skss.city_show.BaseTest;
import com.skss.city_show.entity.ProductCategory;

public class ProductCategoryDaoTest extends BaseTest{
  @Autowired
   private IproductCategoryDao  productCatagoryDao;
  
	public void testqueryProductCategoryList() throws Exception{
	   long shopId=45;
	  List<ProductCategory> productCategoryList=productCatagoryDao.queryProductCategoryList(shopId);
	  System.out.println("商品类别列表长度：："+productCategoryList.size());
   }
	@Test
	public void testbatchInsertProductCatagory() {
		ProductCategory pc1=new ProductCategory();
		ProductCategory pc=new ProductCategory();
		ProductCategory pc2=new ProductCategory();
		
		pc.setCreateTime(new Date());
		pc.setPriority(25);
		pc.setProductCategoryName("商品类别4");
		pc.setShopId(45L);
		

		pc1.setCreateTime(new Date());
		pc1.setPriority(24);
		pc1.setProductCategoryName("商品类别5");
		pc1.setShopId(45L);
		
		pc2.setCreateTime(new Date());
		pc2.setPriority(23);
		pc2.setProductCategoryName("商品类别6");
		pc2.setShopId(45L);
		
		
		List<ProductCategory>  pushPc = new ArrayList<ProductCategory>();
		pushPc.add(pc);
		pushPc.add(pc1);
		pushPc.add(pc2);
		System.out.println("批量插入的长度："+pushPc.size());
		int a=0;
		try {
			 a=productCatagoryDao.batchInsertProductCatagory(pushPc);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("批量插入报错信息："+e.getMessage());
		}
		
		System.out.println("影响的行数是："+a);
		assertEquals(3, a);
	}
}
