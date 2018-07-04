package com.skss.city_show.dao;

import static org.junit.Assert.*;

import java.util.Date;

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
     @Test
     public void queryShopByShopId(){
    	 
    	 Shop shop=new Shop();
    	 Long shopId=(long) 64;
    	 shop=iShopDao.queryShopByShopId(shopId);
    	 System.out.println(shop.getShopName()+"------"+shop.getShopId());
    	
     }   
    
}
