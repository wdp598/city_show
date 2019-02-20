package com.skss.city_show.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
	/**
	 * 商品类别批量插入
	 * @param productCategoryList
	 * @return int 影响的行数
	 */
	public int batchInsertProductCatagory (List<ProductCategory>   productCategoryList);
	
     /**
      * 删除指定商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     */
    public int deleteProductCatagory(@Param("productCategoryId") long productCategoryId,@Param("shopId") long shopId);
}
