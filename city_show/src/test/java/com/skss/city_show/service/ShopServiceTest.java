package com.skss.city_show.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skss.city_show.BaseTest;
import com.skss.city_show.dto.ShopExecution;
import com.skss.city_show.entity.Shop;
import com.skss.city_show.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private IshopService shopService;


@Test
public void testAddShop(){
	Shop shop=new Shop();
	 shop.setShopId(27L);
	 shop.setShopName("测试店铺002");
	 shop.setShopDesc("测试描述002");
	 shop.setShopAddr("测试地址002");
	 shop.setPhone("136123002");
	/* shop.setShopImg("testImg001");*/
	 shop.setCreateTime(new Date());
	 shop.setLastEditTime(new Date());
	 shop.setEnableStatus(ShopStateEnum.CHCK.getState());
	 shop.setAdvice("审核中");
	File shopImg=new File("D:/apache-tomcat-8.0.47/Img/xiaohuangren.jpg");
	//将File转换成InputStream
	InputStream shopImgInputStream = null;
	try {
		shopImgInputStream = new FileInputStream(shopImg);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ShopExecution se=shopService.addShop(shop, shopImgInputStream,shopImg.getName());
	/*System.err.println("图片地址是："+shopImg);*/
	assertEquals(ShopStateEnum.CHCK.getState(),se.getState());
}
	
}
