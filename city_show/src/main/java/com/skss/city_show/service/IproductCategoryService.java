package com.skss.city_show.service;

import java.util.List;

import com.skss.city_show.entity.ProductCategory;

/**
 * @author Administrator
 *商品类别
 */
public interface IproductCategoryService {

	/**
	 * 某个商品下所有商品列表
	 * @param shopId
	 * @return List<ProductCategory>
	 */
	public List<ProductCategory> queryProductCategoryList(Long shopId);
}
