package com.agileeagle.gf.im.manager.controller;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 统一获取spring中的bean对象<br>
 * 该工具一般在BeansListener监听器中初始化
 * 
 * @author songdawei
 * @version 1.0
 * @date 2008-07-23
 */
public abstract class BeanUtil {
	private static ApplicationContext ac = null;

	/**
	 * 获取springcontext
	 * 
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return ac;
	}

	/**
	 * 私有构造
	 */
	private BeanUtil() {
	}

	/**
	 * 启动spring默认需要加载spring配置文件路径
	 * 
	 * @param config
	 */
	public static void init(String[] config) {
		if (ac == null) {
			ac = new ClassPathXmlApplicationContext(config);
		}
	}

	/**
	 * spring是否启动
	 * 
	 * @return
	 */
	public static boolean isNull() {
		return ac == null ? true : false;
	}

	/**
	 * 启动spring默认需要加载spring配置文件路径
	 * 
	 * @param config
	 */
	public static void init(ApplicationContext _ac) {
		if (ac == null && _ac != null)
			ac = _ac;
	}

	/**
	 * 获取spring应用中的对象
	 * 
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		return (ac == null ? null : ac.getBean(beanName));
	}

	/**
	 * 获取错误信息(暂时不支持国际化)
	 * 
	 * @param code
	 * @param locale
	 * @return
	 */
	public static String getErrorCodeMessage(String code, Locale locale) {
		/*return ac == null ? null : ac.getMessage(String.valueOf(code), null,
				locale);*/
		return ac == null ? null : ac.getMessage(String.valueOf(code), null,
				null);
	}
	
	
	/**
	 * 获取错误信息
	 * 
	 * @param code
	 * @param locale
	 * @return
	 */
	public static String getErrorCodeMessage(String code, Locale locale,Object[] objs) {
		/*return ac == null ? null : ac.getMessage(code,objs, locale);*/
		return ac == null ? null : ac.getMessage(code,objs, null);
	}
}
