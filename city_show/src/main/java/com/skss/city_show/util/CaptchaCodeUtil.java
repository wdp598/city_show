package com.skss.city_show.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * 比较输入的验证码与生成的验证码是否一致
 * 
 * @author WDP
 *
 */
public class CaptchaCodeUtil {
	
	static Logger logger=(Logger) LoggerFactory.getLogger(CaptchaCodeUtil.class);
	/**
	 * 比较输入的与图片中生成的否一致
	 * 
	 * @param request
	 * @return
	 */
	public static boolean comparisonCaptchaCode(HttpServletRequest request) {
		
		// 从会话中获取生成的图片验证码
		String getVerifyCodeForImg = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
//输入的验证码从提交的表单里面获取，这里的表单是通过js里面的formData提交的
		String inputVerifyCodeForInput=HttpServerRequestUtil.getString(request, "verifyCodeActual");
		//比较
		try {
			if(!getVerifyCodeForImg.equals(inputVerifyCodeForInput)||getVerifyCodeForImg==null){
				return false;
			}
		} catch (Exception e) {
			logger.info("比较输入的验证码与生成的验证码时出错："+e.getMessage());
			// TODO: handle exception
			return false;
		}
		
		return true;

	}
}
