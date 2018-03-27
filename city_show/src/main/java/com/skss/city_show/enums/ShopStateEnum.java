package com.skss.city_show.enums;

/**
 * @author wdp
 * @since 20180303 店铺状态int值与店铺状态标志类
 */
public enum ShopStateEnum {
	CHCK(0, "审核中"), OFFLINE(-1, "非法店铺"), SUCESS(1, "操作成功"), PASS(2, "通过认证"), INNER_ERROR(-1001,
			"内部系统错误"), NULL_SHOPID(-1002, "shopId为空"),NULL_SHOP(-1003,"shop信息为空");

	private int state;
	private String stateInfo;

	/**
	 * @param state
	 * @param stateInfo
	 */
	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * @param state
	 * @return 依据传入的state,返回相应的enum值
	 */
	public static ShopStateEnum stateOf(int state) {
		for (ShopStateEnum shopStateEnum : values()) {
			if (shopStateEnum.getState() == state) {
				return shopStateEnum;
			}
		}

		return null;

	}

	public int getState() {
		return state;
	}

	/*public void setState(int state) {
		this.state = state;
	}*/

	public String getStateInfo() {
		return stateInfo;
	}

	/*public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}*/

}
