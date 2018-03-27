package com.skss.city_show.entity;

import java.util.Date;

/**
 * @author weidp 本地账号
 */
public class LocalAuth {
	/**
	 * 本地账号本身id
	 */
	private Long localAuthId;
	/**
	 * 本地账号用户名
	 */
	private String username;
	/**
	 * 本地账号密码
	 */
	private String password;
	/**
	 * 本地账号创建时间
	 */
	private Date createTime;
	/**
	 * 本地账号修改时间
	 */
	private Date lastEditTime;

	public Long getLocalAuthId() {
		return localAuthId;
	}

	public void setLocalAuthId(Long localAuthId) {
		this.localAuthId = localAuthId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	/**
	 * 用户对象
	 */
	private PersonInfo personInfo;

}
