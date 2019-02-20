package com.skss.city_show.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skss.city_show.dao.IproductCategoryDao;
import com.skss.city_show.dto.ProductCategoryExecution;
import com.skss.city_show.entity.ProductCategory;
import com.skss.city_show.enums.ProductCategoryStateEnum;
import com.skss.city_show.service.IproductCategoryService;
 

@Service
public class ProductCategoryServiceImpl implements IproductCategoryService{
    @Autowired
	IproductCategoryDao iProductCategoryDao;
	
    
    /* (non-Javadoc)
     * @see com.skss.city_show.service.IproductCategoryService#queryProductCategoryList(java.lang.Long)
     */
    @Override
	public List<ProductCategory> queryProductCategoryList(Long shopId) {
		// TODO Auto-generated method stub
    	return iProductCategoryDao.queryProductCategoryList(shopId);
	}


	/* (non-Javadoc)
	 * @see com.skss.city_show.service.IproductCategoryService#batchInsertProductCatagory(java.util.List)
	 */
	@Override
	public ProductCategoryExecution batchInsertProductCatagory(List<ProductCategory> productCategoryList) 
			throws RuntimeException {
		if(!productCategoryList.isEmpty()&&productCategoryList.size()>0) {
			
			try {
				int effctedNum=iProductCategoryDao.batchInsertProductCatagory(productCategoryList);
				if(effctedNum<=0) {
				  throw	new RuntimeException( "店铺类别批量插入失败");
				}else {
					return new ProductCategoryExecution(ProductCategoryStateEnum.SUCESS);
				}
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("店铺类别批量插入失败:"+e.getMessage());
			}
		}else {
			return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);	
		}		
	}


	@Override
	@Transactional
	public ProductCategoryExecution deleteProductCatagory(long productCategoryId, long shopId) {
		try {
			 int effectNum=iProductCategoryDao.deleteProductCatagory(productCategoryId, shopId);
			 if(effectNum<=0) {
				 new RuntimeException();
				  System.out.println("删除指定上商品失败");
			 }else {
				 return  new ProductCategoryExecution(ProductCategoryStateEnum.SUCESS);
			 }
		} catch (Exception e) {
			// TODO: handle exception
			 new RuntimeException();
			  System.out.println("删除指定上商品是发生异常："+e.getMessage());
				
		}
		return null;
	}

	 
}
