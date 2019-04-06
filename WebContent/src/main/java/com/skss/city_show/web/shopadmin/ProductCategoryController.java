package com.skss.city_show.web.shopadmin;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skss.city_show.dto.ProductCategoryExecution;
import com.skss.city_show.dto.Result;
import com.skss.city_show.entity.ProductCategory;
import com.skss.city_show.entity.Shop;
import com.skss.city_show.enums.ProductCategoryStateEnum;
import com.skss.city_show.service.IproductCategoryService;

/**
 * @author Administrator 商品类别
 */
@Controller
@RequestMapping(value = "/shopadmin")
public class ProductCategoryController {

	@Autowired
	IproductCategoryService iProductCategoryService;

	/**
	 * 获取商品类别
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getproductcategorylist", method = RequestMethod.GET)
	@ResponseBody
	private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request) {

		Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");

		List<ProductCategory> productCategoryList = null;
		if (currentShop != null && currentShop.getShopId() > 0) {
			productCategoryList = iProductCategoryService.queryProductCategoryList(currentShop.getShopId());
			return new Result<>(true, productCategoryList);
		} else
			return new Result<>(false, productCategoryList);

	}

	/**
	 * 商品类别批量增加
	 * @param productCategoryList
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addproductcategorys", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> addProductCategorys(@RequestBody List<ProductCategory> productCategoryList,
			HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();
		Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
		for (ProductCategory pc : productCategoryList) {
			pc.setShopId(currentShop.getShopId());
		}

		if (!productCategoryList.isEmpty() && productCategoryList.size() > 0) {
			try {
				ProductCategoryExecution pe = iProductCategoryService.batchInsertProductCatagory(productCategoryList);
				if (pe.getState() == ProductCategoryStateEnum.SUCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", pe.getStateInfo());
				}

			} catch (Exception e) {
				// TODO: handle exception
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
				return modelMap;
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请至少输入一个商品类别");
		}
		return modelMap;

	}

	/**
	 * 删除指定的商品类别
	 * @param productCategoryId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/removeproductcategory", method = RequestMethod.POST)
	@ResponseBody
	private Map<String,Object>  removeProductCategory(Long productCategoryId,HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<>();
		if(productCategoryId!=null&&productCategoryId>0) {
			Shop currentShop=(Shop) request.getSession().getAttribute("currentShop");
			ProductCategoryExecution pe=iProductCategoryService.deleteProductCatagory(productCategoryId, currentShop.getShopId());
			if(pe.getState()==ProductCategoryStateEnum.SUCESS.getState()) {
				 modelMap.put("success", true);
			}else {
				modelMap.put("success", false);
				modelMap.put("errMsg", pe.getStateInfo());
			}
		}else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请至少选择一个商品");
		}
		return modelMap;
		
	}
	
}
