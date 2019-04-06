package com.skss.city_show.dto;

import java.util.List;

import com.skss.city_show.entity.Shop;
import com.skss.city_show.enums.ShopStateEnum;

/**
 * @author wdp 操作店铺的返回类型
 *    结果状态state
 *    状态标志stateInfo
 *    店铺的数量count
 *    店铺shop
 *    店铺列表shopList
 */
public class ShopExecution {
	/**
	 * 结果状态
	 */
	private int state;
	/**
	 * 状态标志 以文字的形式告知结果状态
	 */
	private String stateInfo;
	/**
	 * 店铺的数量
	 */
	private int count;
	/**
	 * 正在操作的店铺
	 */
	private Shop shop;
	/**
	 * 店铺列表
	 */
	private List<Shop> shopList;

	public ShopExecution() {
	}

	/**
	 * @param shopStateEnum
	 *            操作失败 返回状态与状态信息
	 */
	public ShopExecution(ShopStateEnum shopStateEnum) {
		this.state = shopStateEnum.getState();
		this.stateInfo = shopStateEnum.getStateInfo();

	}

	/**
	 * @param shopStateEnum
	 * @param shop
	 *操作成功 返回状态，状态信息，添加成功的单个shop实体
	 */
	public ShopExecution(ShopStateEnum shopStateEnum, Shop shop) {
		this.state = shopStateEnum.getState();
		this.stateInfo = shopStateEnum.getStateInfo();
		this.shop = shop;
	}

	/**
	 * @param shopStateEnum
	 * @param shopList
	 * 操作成功 返回状态，状态信息，添加成功的shop实体列表
	 */
	public ShopExecution(ShopStateEnum shopStateEnum, List<Shop> shopList) {
		this.state = shopStateEnum.getState();
		this.stateInfo = shopStateEnum.getStateInfo();
		this.shopList = shopList;

	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
}
