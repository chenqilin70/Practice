package com.mysql.shopping.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1.编写过滤器的第一步，编写过滤器类
public class Sessioncheck implements Filter {
	@Override
	public void destroy() {

	}
	//3.这里是书写过滤规则的代码，部署需要拦截的请求
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//将过滤器传给的参数转换为request对象
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		String requestParamter=request.getQueryString();
		String requestURI=request.getRequestURI();
		//分析需要拦截的情况：当未登陆时，个人信息，我的订单
		if(requestURI.contains("OrderServlet"))//是否包含该uri里面是否包含OrderServlet
		{
			if(request.getSession().getAttribute("Loginuser")==null)
			{
				response.sendRedirect("account.jsp");
				System.out.println("必须登录之后才能查看订单");
			}
			else
			{
				arg2.doFilter(arg0, arg1);
			}
		}else if(requestURI.contains("UserServlet")&&requestParamter.contains("information"))
		{
			if(request.getSession().getAttribute("Loginuser")==null)
			{
				response.sendRedirect("account.jsp");
			}else
			{
				arg2.doFilter(arg0, arg1);
			}
		}else
		{
			arg2.doFilter(arg0, arg1);
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
