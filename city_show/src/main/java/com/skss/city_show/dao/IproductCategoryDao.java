package com.skss.city_show.dao;

import java.util.List;

import com.skss.city_show.entity.ProductCategory;

/**
 * @author Administrator
 *商品类别DAO
 */
public interface IproductCategoryDao {
   
	/**
	 * 根据shopId查询商品类别
	 * @param shopId
	 * @return List<Product>
	 */
	public List<ProductCategory> queryProductCategoryList(long shopId);
	
}
