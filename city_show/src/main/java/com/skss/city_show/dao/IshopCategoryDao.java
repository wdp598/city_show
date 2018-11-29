package com.skss.city_show.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skss.city_show.entity.ShopCategory;

/**
 * @author Administrator
 *店铺类别DAO
 */
public interface IshopCategoryDao {

	/**
	 * @param shopCategory
	 * @return List<ShopCategory>
	 */
	public List<ShopCategory> getShopCategoryList(@Param("shopCategory") ShopCategory shopCategory);
	
}
