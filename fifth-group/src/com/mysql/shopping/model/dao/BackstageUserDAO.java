package com.mysql.shopping.model.dao;

import java.util.List;
import java.util.Set;

import admin.com.oracle.model.bean.BackstageUser;
import admin.com.oracle.model.bean.Identity;
import admin.com.oracle.model.bean.Limitbean;

public interface BackstageUserDAO extends BaseDAO {
	public List<Limitbean> listlimit();
	public Set<Identity> listidentity();
	public int getidentityid(String position);
	public String getposition(int id);
	public List<Limitbean> getlimit(int userid);
	public List<BackstageUser> getcontroluser(BackstageUser user);
	public Set<Identity> listcontrolidentity(BackstageUser user);
}
