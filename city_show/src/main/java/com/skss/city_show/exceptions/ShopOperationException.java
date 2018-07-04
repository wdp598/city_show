package com.skss.city_show.exceptions;

public class ShopOperationException extends RuntimeException{
  /**
	 * 操作异常类
	 */
	private static final long serialVersionUID = 7620280921172659303L;

public ShopOperationException(String msg){
	  super(msg);
	  
  }
}
