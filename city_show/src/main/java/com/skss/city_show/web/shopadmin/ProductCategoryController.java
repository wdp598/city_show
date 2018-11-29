package com.skss.city_show.web.shopadmin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skss.city_show.dto.Result;
import com.skss.city_show.entity.ProductCategory;
import com.skss.city_show.entity.Shop;
import com.skss.city_show.service.IproductCategoryService;

/**
 * @author Administrator
 *商品类别
 */
@Controller
@RequestMapping(value="/shopadmin")
public class ProductCategoryController {
	
	@Autowired
	IproductCategoryService iProductCategoryService;
	
	/**
	 * 商品类别
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getproductcategorylist", method=RequestMethod.GET)
	@ResponseBody
	private  Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request){
		
		Shop currentShop=(Shop)request.getSession().getAttribute("currentShop"); 
		 
		List<ProductCategory> productCategoryList=null;
		if(currentShop!=null&&currentShop.getShopId()>0) {
			productCategoryList=iProductCategoryService.queryProductCategoryList(currentShop.getShopId());
			return new Result<>(true,productCategoryList);
		}
		else return  new Result<>(false,productCategoryList);
			
		
		
		
	}
}
