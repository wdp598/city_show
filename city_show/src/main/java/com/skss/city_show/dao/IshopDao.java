package com.skss.city_show.dao;

import com.skss.city_show.entity.Shop;

/**
 * @author weidp
 *注册店铺
 */
public interface IshopDao {
/**
 * 新增店铺
 * @param shop
 * @return int
 */
	public int insertShop(Shop shop);
	
	/**
	 * 更新店铺信息
	 * @param shop
	 * @return int
	 */
	public int updateShop(Shop shop);
}
