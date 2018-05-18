package com.skss.city_show.service;

import java.util.List;

import com.skss.city_show.entity.ShopCategory;

public interface IshopCategoryService {
   
	/**
	 * 获取店铺类别
	 * @param ShopCategory
	 * @return  List<ShopCategory>
	 */
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategory);
	
}
