package com.skss.city_show.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skss.city_show.BaseTest;
import com.skss.city_show.entity.Area;
import com.skss.city_show.entity.PersonInfo;
import com.skss.city_show.entity.Shop;
import com.skss.city_show.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{//如果不继承BaseTest  会报空指针
     @Autowired
	private  IshopDao iShopDao;
     @Test
     @Ignore
     public void insertShop(){
    	 Shop shop=new Shop();
    	 PersonInfo owner=new PersonInfo();
    	 Area area=new Area();
    	 ShopCategory shopCategory=new ShopCategory();
    	 owner.setUserId(1L);
    	 area.setAreaId(1);
    	 shopCategory.setShopCategoryId(1L);
    	 shop.setArea(area);
    	 shop.setShopCategory(shopCategory);
    	 shop.setShopName("测试店铺");
    	 shop.setShopDesc("TEST_desc");
    	 shop.setShopAddr("testAdress");
    	 shop.setPhone("136123456");
    	 shop.setShopImg("testImg");
    	 shop.setCreateTime(new Date());
    	 shop.setEnableStatus(1);
    	 shop.setAdvice("审核中");
    	 int insertRows =iShopDao.insertShop(shop);
    	 assertEquals(1,insertRows);
    	 System.out.println(shop.getShopName());
     }
     @Test
     @Ignore
	public void updateShop(){
    	 Shop shop=new Shop();
    	 shop.setShopId(27L);
    	 shop.setShopName("测试店铺");
    	 shop.setShopDesc("测试描述");
    	 shop.setShopAddr("测试地址");
    	 shop.setPhone("136123456");
    	 shop.setShopImg("testImg");
    	 shop.setCreateTime(new Date());
    	 shop.setLastEditTime(new Date());
    	 shop.setEnableStatus(1);
    	 shop.setAdvice("审核中");
    	 int insertRows =iShopDao.updateShop(shop);
    	 /*assertEquals(1,insertRows);*/
    	 System.out.println(shop.getShopDesc());
		
	}
    
     public void testqueryShopByShopId(){
    	 
    	 Shop shop=new Shop();
    	 Long shopId=(long) 64;
    	 shop=iShopDao.queryShopByShopId(shopId);
    	 System.out.println(shop.getShopName()+"------"+shop.getShopId());
    	 System.out.println(shop.getArea().getAreaName()+"------"+"根据店铺id查询出的区域名称");
    	 System.out.println(shop.getShopCategory().getShopCategoryName()+"------"+"根据店铺id查询出的店铺类别名称");
     }   
     @Test
     public void testqueryShopCount() {
    	 Shop shop=new Shop();
    	 //PersonInfo owner=new PersonInfo();
    	 //owner.setUserId(2L);
    	 //shop.setShopId(8L);
    	 shop.setShopName("好好");
    	 List<Shop> shopList=iShopDao.queryShopList(shop, 0, 10);
    	  //int countShop=iShopDao.queryShopCount(shop);
    	  System.out.println("符合条件的shopList列表大小："+shopList.size());
    	 
     }
     
}
