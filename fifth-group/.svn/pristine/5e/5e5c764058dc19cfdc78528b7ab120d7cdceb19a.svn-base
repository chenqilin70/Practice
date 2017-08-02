package com.oracle.struts.model.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.mysql.shopping.model.dao.BackstageUserDAOImpyc;
import com.mysql.shopping.model.dao.BackstageUserDAOyc;
import com.mysql.shopping.model.dao.CheckCodeAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import admin.com.oracle.model.bean.BackstageUser;
import admin.com.oracle.model.bean.Identity;

public class UserActionyc extends ActionSupport {
		private BackstageUser user;
		private List<BackstageUser>  users;
		private BackstageUserDAOImpyc  uDAO;
		private String code;
		
		

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public UserActionyc(){
			uDAO=new BackstageUserDAOImpyc();
		}

		public List<BackstageUser> getUsers() {
			return users;
		}

		public void setUsers(List<BackstageUser> users) {
			this.users = users;
		}

		public BackstageUser getUser() {
			return user;
		}

		public void setUser(BackstageUser user) {
			this.user = user;
		}
		
		public String login() throws Exception {
			boolean b=checkCode();
			if(b){
				user=uDAO.login(user.getUsername(),user.getPassword());
				if(user!=null)
					
				ActionContext.getContext().getSession().put("user", user);
				return user==null?"loginFail":"loginSuccess";
				
			}else {
				return "loginFail";
			}
			
			
			
			/*HttpServletRequest request = ServletActionContext.getRequest();
			
			if ("admin".equals(user.getUsername())&&"admin".equals(user.getPassword())) {
				Map session = ActionContext.getContext().getSession();
				session.put("user.username",user.getUsername());
				System.out.println("登录成功，用户名="+user.getUsername());
				return "loginSuccess";
			}
			System.out.println();
			return"loginFail";
			*/
		
			}
		
		public boolean checkCode(){
			//图片路径
		       // String tip = "code.jsp";
		        //从服务端获取session中的验证码
		        String checkcodeServer = (String) ActionContext.getContext().getSession().get("code").toString();
		        System.out.println("----checkcodeServer---"+checkcodeServer);
		        System.out.println("----checkcode----"+code);
		        //将客户端的验证码与服务端的验证码进行比较
		        if(code==null){
		        	return false;
		        }
		        if(code.equals(checkcodeServer)){
		            //tip = "code.jsp";
		        	System.out.println("success");
		           return true;
		        }else{
		        	return false;
				}
		}
		}




		
		
	

