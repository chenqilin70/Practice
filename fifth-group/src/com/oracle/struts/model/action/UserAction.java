package com.oracle.struts.model.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mysql.shopping.model.dao.BackstageUserDAOImp;
import com.opensymphony.xwork2.ActionSupport;

import admin.com.oracle.model.bean.BackstageUser;
import admin.com.oracle.model.bean.Identity;

public class UserAction extends ActionSupport {
	private BackstageUser user;
	private Set<Identity> identitylist;
	List<BackstageUser> controlusers;


	public List<BackstageUser> getControlusers() {
		return controlusers;
	}

	public void setControlusers(List<BackstageUser> controlusers) {
		this.controlusers = controlusers;
	}

	public Set<Identity> getIdentitylist() {
		return identitylist;
	}

	public void setIdentitylist(Set<Identity> identitylist) {
		this.identitylist = identitylist;
	}

	public BackstageUser getUser() {
		return user;
	}

	public void setUser(BackstageUser user) {
		this.user = user;
	}
	
	public String listidentity(){
		BackstageUserDAOImp b=new BackstageUserDAOImp();
		user=new BackstageUser();
		user.setIdentityid(4);
		identitylist=b.listcontrolidentity(user);
		return "identitylist";
	}
	
	public String listcontroluser(){
		BackstageUserDAOImp b=new BackstageUserDAOImp();
		controlusers=new ArrayList<>();
		BackstageUser u=new BackstageUser(0, "", "", "", "", "", 4, 1, 1, "");
		controlusers=b.getcontroluser(u);
		return "listcontrolsuccess";
		
	}
	
	public String adduser(){
		user.setUserid(0);
		user.setOnline(1);
		BackstageUserDAOImp b=new BackstageUserDAOImp();
		user.setIdentityid(b.getidentityid(user.getPosition()));
		System.out.println(user);
		if(b.add(user)){
			return "addsuccess";
		}else{
			return "adderror";
		}
//		return null;
	}
}
