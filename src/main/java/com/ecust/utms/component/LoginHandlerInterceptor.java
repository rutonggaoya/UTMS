package com.ecust.utms.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(getClass());

    List<String> allowedMethod = new LinkedList<String>() {{
        add("POST");
        add("DELETE");
        add("PUT");
    }};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行POST、DELETE、PUT请求
        if(allowedMethod.contains(request.getMethod()))
            return true;

        logger.trace("--->" + request.getRequestURL());
        Object user = request.getSession().getAttribute("loginuser");
        if(user!=null){
            return true;
        }else {
            request.setAttribute("msg","没有权限请登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
