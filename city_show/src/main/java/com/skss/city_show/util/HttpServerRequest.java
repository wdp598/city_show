package com.skss.city_show.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wdp
 * http请求处理工具
 *
 */
public class HttpServerRequest {

	/**
	 * String 转换成int
	 * @param request
	 * @param str
	 * @return 转换失败返回-1，转化成功返回int
	 */
	public static int getInt(HttpServletRequest request,String str){
		try {
			return Integer.decode(request.getParameter(str));//Integer decode(String nm) 将字符串转换为整数。
		} catch (Exception e) {                              //int parseInt(String s) ：将字符串转换成整数。s必须是时进制数组成，否则抛出NumberFormatException异常
			// TODO: handle exception
			return -1;//转化失败返回-1
		}
		}
	
	/**
	 * String 转换成long
	 * @param request
	 * @param str
	 * @return 转换失败返回-1l，转化成功返回long
	 */
	public static long getLong(HttpServletRequest request,String str){
		try {
			return Long.valueOf(request.getParameter(str));//Long.valueOf(String nm) 将字符串转换为长整型。
		} catch (Exception e) {                              
			return -1L;//转化失败返回-1L
		}
		}
	/**
	 * String 转换成double
	 * @param request
	 * @param str
	 * @return 转换失败返回-1d，转化成功返回double
	 */
	public static double getDouble(HttpServletRequest request,String str){
		try {
			return Double.valueOf(request.getParameter(str));//Double.valueOf(String nm) 将字符串转换为double。
		} catch (Exception e) {                              
			return -1D;//转化失败返回-1D
		}
		}
	/**
	 * String 转换成boolean
	 * @param request
	 * @param str
	 * @return 转换失败返回false，转化成功返回boolean
	 */
	public static boolean getBoolean(HttpServletRequest request,String str){
		try {
			return Boolean.valueOf(request.getParameter(str));//Double.valueOf(String nm) 将字符串转换为double。
		} catch (Exception e) {                              
			return false;//转化失败返回false
		}
		}
	/**
	 * @param request
	 * @param str
	 * @return 去掉字符串两边的空格
	 */
	public static String getString(HttpServletRequest request,String str){
		String strRequest=null;
		try {
			 strRequest=request.getParameter(str);
			if(strRequest!=null){
				strRequest=strRequest.trim();
			}
			if("".equals(strRequest)){
				strRequest=null;
			}
			return strRequest;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		
	}
}
