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
	

/**
 * 根据店铺id查询店铺返回基本店铺信息以及区域信息和商店类别信息
 * @param shopId
 * @return NAME
 */
public Shop queryShopByShopId(long shopId);

/**
 * 修改店铺信息，包括对图片的处理
* @param shop
* @param inputStreamShopImg,String fileName
* @return ShopExecution
* 
*/
public ShopExecution modifyShop(Shop shop,InputStream inputStreamShopImg,String fileName);//InputStream中不能获取到文件名
	

}
