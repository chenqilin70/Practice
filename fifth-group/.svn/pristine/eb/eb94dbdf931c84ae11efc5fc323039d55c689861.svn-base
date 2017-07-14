package com.oracle.struts.model.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LimitAction extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		HttpServletRequest re=ServletActionContext.getRequest();
		HttpSession se=ServletActionContext.getRequest().getSession();
		String reurl=re.getRequestURL().toString();
		System.out.println(reurl);
		
		if(reurl.contains("!")){
			String actionname=reurl.substring(reurl.lastIndexOf("/")+1, reurl.indexOf("!"));
			String methodname=reurl.substring(reurl.indexOf("!")+1, reurl.lastIndexOf("."));
			System.out.println(actionname);
			System.out.println(methodname);
		}
		// TODO Auto-generated method stub
		return arg0.invoke();
	}

}
