package com.oracle.struts.model.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.struts.model.bean.User;

public class UserAction extends ActionSupport{

	private String username;
	private String password;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute(){
		return null;
	}
	public String Login(){
		
		System.out.println("login");
		
		
		ActionContext action=ActionContext.getContext();
		Map session=(Map)action.getSession();
		session.put("user",user);
		
		if(user.getUsername().equals("bigbao")&&user.getPassword().equals("123")){
			return "success";
		}else{
			return "error";
		}
	}
	public String register(){
		System.out.println("register");
		if(username.equals("bigbao")&&password.equals("123")){
			return "success";
		}else{
			return "error";
		}
	}
	public String aaa(){
		System.out.println("aaa");
		return null;
	}
	public String bbb(){
		System.out.println("bbb");
		return null;
	}
}
