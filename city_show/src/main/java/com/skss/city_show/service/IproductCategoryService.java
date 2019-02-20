package com.skss.city_show.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skss.city_show.dto.ProductCategoryExecution;
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
	
	/**
	 * 批量插入商品类别
	 * @param productCategoryList
	 * @return int
	 */
	public ProductCategoryExecution batchInsertProductCatagory(List<ProductCategory>  productCategoryList) throws RuntimeException;

	/**
	 * 删除指定的商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 */
	public ProductCategoryExecution deleteProductCatagory(@Param("productCategoryId") long productCategoryId,@Param("shopId") long shopId) throws RuntimeException;

}
