package com.skss.city_show.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skss.city_show.BaseTest;
import com.skss.city_show.dto.ShopExecution;
import com.skss.city_show.entity.Shop;
import com.skss.city_show.entity.ShopCategory;
import com.skss.city_show.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private IshopService shopService;



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


 public void testModfyshop() {
	//Shop shop=new Shop();
	//shop.setShopId(45L);
	Shop shop=shopService.queryShopByShopId(46L);
	shop.setShopName("修改后的店铺名字46");
	shop.setShopImg("F:/magazine-unlock-02-2.3.781-_0b600ad872d7428fbb72af8be63e373a.jpg");
	File shopImg=new File("F:/magazine-unlock-02-2.3.781-_0b600ad872d7428fbb72af8be63e373a.jpg");
    try {
		InputStream inputStreamShopImg=new FileInputStream(shopImg);
		
		ShopExecution shopExection=	shopService.modifyShop(shop, inputStreamShopImg, "magazine-unlock-02-2.3.781-_0b600ad872d7428fbb72af8be63e373a.jpg");
         System.out.println("修改后的图片地址：："+shopExection.getShop().getShopImg());
    
    } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
}

public void testqueryshopbyshopIdservice() {
	Shop shop=shopService.queryShopByShopId(64L);
	System.out.println(shop.getShopName()+shop.getShopId());
	
}
@Test
public void testgetShopList() {
	Shop shopCondition= new Shop();
	ShopCategory shopCategory=new ShopCategory();
	shopCategory.setShopCategoryId(3L);
	
	ShopExecution se=shopService.getShopList(shopCondition, 4, 10);
	System.out.println(se.getShopList().size()+"个店铺");
	System.out.println("店铺总数"+se.getCount());
}


}
		