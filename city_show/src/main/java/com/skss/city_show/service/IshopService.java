package com.skss.city_show.service;

import java.io.File;
import java.io.InputStream;

import com.skss.city_show.dto.ShopExecution;
import com.skss.city_show.entity.Shop;

public interface IshopService {
 /**
 * @param shop
 * @param inputStreamShopImg,String fileName
 * @return ShopExecution
 * 添加店铺
 */
public ShopExecution addShop(Shop shop,InputStream inputStreamShopImg,String fileName);//InputStream中不能获取到文件名
	
	
}
