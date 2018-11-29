package com.skss.city_show.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * shop导航类
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="shopadmin",method={RequestMethod.GET})
public class ShopAdminController {
	
/**
 * 注册或编辑店铺信息的访问路由
 * @return shop/registerShop
 */
@RequestMapping(value="/shopoperation")
	public String shopoperation(){
		return "shop/registerShop";
	}
	
/**
 * 店铺列表的路由
 * @return shop/shopList
 */
@RequestMapping(value="/shoplist")
	public String shopList() {
		return "shop/shopList";
	}
	
/**
 * 单个shop页面管理
 * @return shop/shopmanagement
 */
@RequestMapping(value="/shopmanagement")
   public String shopManagement() {
	   
	   return "shop/shopmanagement";
   }

/**
 * 商品类别管理
 * @return shop/productcategorymanagement 
 * 
 */
@RequestMapping(value="/productcategorymanagement",method={RequestMethod.GET})
public String productCategoryManagement() {
	return "shop/productcategorymanagement";
}

}
