package com.skss.city_show.service;

import java.io.InputStream;

import org.apache.ibatis.annotations.Param;

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
 * @return Shop
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
	
/**
 * 获取店铺列表，分页查询
 * @param shopCondition shop实体
 * @param rowIndex 从第几条开始
 * @param pageSize 每页的条数
 * @return ShopExecution
 */
public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);





}
