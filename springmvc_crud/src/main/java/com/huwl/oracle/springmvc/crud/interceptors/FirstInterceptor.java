package com.huwl.oracle.springmvc.crud.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aierxuan on 2017/6/18.
 */
public class FirstInterceptor implements HandlerInterceptor{
    /**
     *
     * 在目标方法之前被调用
     * 用于权限 事务 日志等
     */
    public boolean preHandle(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse
            , Object o) throws Exception {

        System.out.println("{FirstInterceptor}-->preHandle");
        return true;
    }

    //在目标方法之后和渲染视图之前被调用
    //用于对请求域中的属性或者视图转向做更改
    public void postHandle(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse
            , Object o
            , ModelAndView modelAndView) throws Exception {

        System.out.println("{FirstInterceptor}-->postHandle");
    }
    //渲染视图之后被调用
    //用于释放资源
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("{FirstInterceptor}-->afterCompletion");
    }
}
