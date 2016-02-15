/**
 * 
 */
package com.agileeagle.gf.im.manager.controller;

import javax.servlet.ServletContextEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * @Title: BeansListener.java
 * 
 * @Package com.agileeagle.core.web.listener
 * 
 * @Description: TODO(用一句话描述该文件用途)
 * 
 * @author jichunfeng
 * 
 * @date 2015年9月6日 下午2:42:54
 * 
 * @version V1.0
 */
public class BeansListener extends ContextLoaderListener {

    private static final Log LOG = LogFactory.getLog(BeansListener.class);

    public void contextInitialized(ServletContextEvent arg0) {
        try {
            super.contextInitialized(arg0);
            if (BeanUtil.isNull()) {
                LOG.info("-----start-------");
                ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
                BeanUtil.init(ac);
                LOG.info("-----end-------");
            }
        } catch (Exception e) {
            LOG.error("", e);
        }
    }

}