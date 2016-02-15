package com.agileeagle.gf.im.manager.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>Title: 设置中文GBK编码</p>
 * <p>Description:
 *
 *   <!--   //** Set Charater Encoding Of Request -->
 *   <filter>
 *       <filter-name>Set Character Encoding</filter-name>
 *       <filter-class>EncodingFilter</filter-class>
 *       <init-param>
 *           <param-name>encoding</param-name>
 *           <param-value>GBK</param-value>
 *       </init-param>
 *   </filter>
 *
 *   <filter-mapping>
 *       <filter-name>Set Character Encoding</filter-name>
 *       <url-pattern>/*</url-pattern>
 *   </filter-mapping>
 *
 * </p>
 * 
 */
public class EncodingFilter
    implements Filter {
  protected String encoding = null;
  protected FilterConfig filterConfig = null;

  public void destroy() {
    this.encoding = null;
    this.filterConfig = null;
  }

  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    // Select and set (if needed) the character encoding to be used
    // HttpServletRequest request1 = (HttpServletRequest)request;
    // System.out.print("["+request1.getMethod()+"]")

    String encoding = selectEncoding(request);
   
    if (encoding != null) {
      request.setCharacterEncoding(encoding);
    }
    // Pass control on to the next filter
    chain.doFilter(request, response);
  }

  public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
    this.encoding = filterConfig.getInitParameter("encoding");
  }

  protected String selectEncoding(ServletRequest request) {
    return (this.encoding);
  }

}

