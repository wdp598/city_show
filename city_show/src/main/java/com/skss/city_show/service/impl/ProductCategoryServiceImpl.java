package com.skss.city_show.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skss.city_show.dao.IproductCategoryDao;
import com.skss.city_show.entity.ProductCategory;
import com.skss.city_show.service.IproductCategoryService;
 

@Service
public class ProductCategoryServiceImpl implements IproductCategoryService{
    @Autowired
	IproductCategoryDao iProductCategoryDao;
	
    
    @Override
	public List<ProductCategory> queryProductCategoryList(Long shopId) {
		// TODO Auto-generated method stub
    	return iProductCategoryDao.queryProductCategoryList(shopId);
	}

	 
}
