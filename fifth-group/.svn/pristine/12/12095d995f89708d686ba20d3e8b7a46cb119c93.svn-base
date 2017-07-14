package com.mysql.shopping.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import admin.com.oracle.model.bean.BackstageUser;

public class BackstageUserDAOImp extends BaseDAOimp implements BackstageUserDAO {

	@Override
	public boolean add(Object obj) {
		BackstageUser user=(BackstageUser)obj;
		//获取一个连接
		Connection c=getConnection();
		PreparedStatement pre=null;
		try {
			pre=c.prepareStatement("insert into USERMANAGE values(?,?,?,?,?,?,?,?)");
			pre.setInt(1, Integer.valueOf(user.getID()));
			pre.setString(2, user.getUsername());
			pre.setString(3, user.getPassword());
			pre.setString(4, user.getRealname());
			pre.setString(5, user.getEmail());
			pre.setString(6, user.getSex());
			pre.setInt(7, user.getAge());
			pre.setInt(8, user.getIdentity());
			int i=pre.executeUpdate();
			if(i==0){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		disposeResource(c, pre);
		return false;
		
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object listAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Set<String> listidentity(){
		//获取一个连接
		Connection c=getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		Set<String> se=null;
		try {
			pre=c.prepareStatement("select * from IDENTITY");
			res=pre.executeQuery();
			se=new HashSet<>();
			while(res.next()){
				se.add(res.getString("POSITION"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disposeResource(c,pre,res);
		return se;
	}

}
