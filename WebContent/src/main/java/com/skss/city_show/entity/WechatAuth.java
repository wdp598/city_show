package com.skss.city_show.entity;

import java.util.Date;

/**
 * @author weidp 微信账号
 */
public class WechatAuth {
	/**
	 * 微信本身ID
	 */
	private Long wechatAuthId;
	/**
	 * 连接微信的id
	 */
	private String openId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 用户对象
	 */
	private PersonInfo personInfo;

	public long getWechatAuthId() {
		return wechatAuthId;
	}

	public void setWechatAuthId(long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

}
