package com.skss.city_show.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skss.city_show.entity.Shop;

/**
 * @author weidp 店铺
 */
public interface IshopDao {
	/**
	 * 新增店铺
	 * 
	 * @param shop
	 * @return int
	 */
	public int insertShop(Shop shop);

	/**
	 * 更新店铺信息
	 * 
	 * @param shop
	 * @return int
	 */
	public int updateShop(Shop shop);

	/**
	 * 根据店铺id查询店铺
	 * 
	 * @param shopId
	 * @return NAME
	 */
	public Shop queryShopByShopId(long shopId);

	/**
	 * 分页查店铺列表，可输入：店铺名称（模糊查询），店铺状态，店铺类别，区域，店铺拥有者owner
	 * 
	 * @param shopCondition
	 *            查询的条件
	 * @param rowIndex
	 *            从第几开始取
	 * @param pageSize
	 *            每页的数量
	 * @return  List<Shop>
	 */
	public List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);// 有多个参数时，加上@Param时为了能准确的取到参数的值
	
	/**
	 * 符合查询条件的数量
	 * @param shopCondition 查询的条件
	 * @return int 符合查询条件的数量
	 */
	public int queryShopCount(@Param("shopCondition") Shop shopCondition);
	
	
	
}
