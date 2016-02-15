package com.agileeagle.gf.im.manager.controller;

import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * 操作IM管理器接口
 * 
 * @author songdawei
 * 
 */
@Controller
public class IMOperController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        System.out.println(map);
        System.out.println(request.getParameter("name"));
        ModelAndView model = new ModelAndView();
        model.getModel().put("你好", "好");
        String str = ("{\"code\":\"10001\",\"msg\":\"身份已过期，请重新登录!\",\"obj\":\"abcd1234我是你吧\"}");
        // response.setCharacterEncoding("UTF_8");
        // response.setContentType("text/plain");
        System.out.println(model.getModel());
        PrintWriter writer = response.getWriter();
        response.setContentLength(str.length());
        writer.write(str);
        return model;
    }

}
