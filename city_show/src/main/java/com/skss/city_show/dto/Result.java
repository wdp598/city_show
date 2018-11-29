package com.skss.city_show.dto;

/**
 * @author Administrator
 *封装json对象，所有返回结果都使用它
 * @param <T>
 */
public class Result<T> {

	/**
	 * 是否返回成功
	 */
	private boolean success;
	
	/**
	 * 成功时返回的数据
	 */
	private T data;
	
	/**
	 * 错误信息
	 */
	private String errorMsg;
	
	/**
	 * 状态码
	 */
	private int errorCode;

	public Result() {}
	
	/**
	 * 成功时的构造器
	 * @param boolean  是否返回成功
	 * @param T 成功时返回的数据
	 */
	public Result (boolean success,T data) {
		this.success=success;
		this.data=data;
	}
	
	/**
	 * 错误是的构造器
	 * @param boolean success 是否返回成功
	 * @param int errorCode  状态码
	 * @param String errorMsg 错误信息
	 */
	public Result(boolean success,int errorCode,String errorMsg) {
		this.success=success;
		this.errorCode=errorCode;
		this.errorMsg=errorMsg;
		
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
}
