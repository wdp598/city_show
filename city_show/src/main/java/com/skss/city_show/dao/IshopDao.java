package com.skss.city_show.dao;

import com.skss.city_show.entity.Shop;

/**
 * @author weidp
 *店铺
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
	
	/**
	 * 根据店铺id查询店铺
	 * @param shopId
	 * @return NAME
	 */
	public Shop queryShopByShopId(long shopId);
}
