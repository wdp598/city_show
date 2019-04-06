package com.skss.city_show.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skss.city_show.dao.IshopCategoryDao;
import com.skss.city_show.entity.ShopCategory;
import com.skss.city_show.service.IshopCategoryService;
@Service
public class ShopCategoryServiceImpl implements IshopCategoryService{
   @Autowired
   private IshopCategoryDao iShopCategoryDao;
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategory) {
		List<ShopCategory> shopCategoryList=iShopCategoryDao.getShopCategoryList(shopCategory);
		
		return shopCategoryList;
	}
	
}
