package com.mysql.shopping.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.mysql.shopping.model.bean.Address;
import com.mysql.shopping.model.bean.User;

public  class UserDAOimp extends BaseDAOimp implements UserDAO {
	
	//����һ�����ӣ����ӵ����ݿ�
	Connection c=getConnection();	

	@Override
	//���ﶨ������Ը�user����������Userservlet�����ȷ�װһ��user����
	public boolean add(Object obj) {
		User register=(User)obj;
		PreparedStatement  pre=null;
		try {
			//�����û���Ϣ��prepareStatement�������ύ�����ݿ�
			pre=c.prepareStatement("insert into users(UserID,Username,Password,Realname,Sex,Age,image,status) values(?,?,?,?,?,?,?,?)");
			pre.setInt(1, register.getUserID());
			pre.setString(2, register.getUsername());
			pre.setString(3, register.getPassword());
			pre.setString(4, register.getRealname());
			pre.setInt(5, register.getSex().equals("0")?1:0);
			pre.setInt(6, register.getAge());
			pre.setString(7, register.getImage());
			pre.setBoolean(8, register.isStatus());
			//statement �ӿ�����executeUpdate(String sql)��������sql ������ִ�гɹ��ļ�¼������ int
			int n=pre.executeUpdate();
			return n>0?true:false;	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre);
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		User deleter=(User)obj;
		PreparedStatement  pre=null;
		try {
			pre=c.prepareStatement("delete from users(username,userID,password,realname,age,image,status values(?,?,?,?,?,?,?)");
			pre.setString(1, deleter.getUsername());
			pre.setInt(2, deleter.getUserID());
			pre.setString(3, deleter.getPassword());
			pre.setString(4, deleter.getRealname());
			pre.setInt(5, deleter.getAge());
			pre.setBoolean(6, deleter.isStatus());
			pre.setString(7, deleter.getImage());
			pre.setBoolean(8, deleter.isStatus());
			int n=pre.executeUpdate();
			return n>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre);
		return false;
	}

	@Override
	public boolean update(Object obj) {
		User user=null;
		PreparedStatement pre=null;
		try {
			user=(User)obj;
			pre=c.prepareStatement("update users set  username=?,password=?,realname=?,sex=?,age=?,image=? where userid=?");
			pre.setString(1, user.getUsername());
			pre.setString(2, user.getPassword());
			pre.setString(3, user.getRealname());
			pre.setInt(4, user.getSex()=="��"?0:1);
			pre.setInt(5, user.getAge());
			pre.setString(6, user.getImage());
			pre.setInt(7, user.getUserID());
			return pre.executeUpdate()>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Object listAll() {
		return null;
	}

	@Override
	public User login(String username, String password) {
		User user=null;
		PreparedStatement pre=null;
		ResultSet  rs=null;//�������в�ѯ������ص�һ�ֶ��󣬿���˵�������һ���洢��ѯ����Ķ���
		//���ǽ���������������д洢�Ĺ��ܣ���ͬʱ�����в������ݵĹ��ܣ�������ɶ����ݵĸ��µ�
		try {
			pre=c.prepareStatement("select * from users where username=? and password=?");
			pre.setString(1, username);
			pre.setString(2, password);
			rs=pre.executeQuery();//�жϲ�ѯ�Ƿ��з���ֵ
			if(rs.next()){
				user=new User();
				user.setUserID(rs.getInt("UserID"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				user.setRealname(rs.getString("Realname"));
				user.setStatus(rs.getBoolean("status"));
				user.setAge(rs.getInt("Age"));
				user.setImage(rs.getString("Image"));
				user.setSex(rs.getString("Sex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre,rs);
		return user;
	}

	@Override
	public User serchinformation(String userID) {
		User user=null;
		PreparedStatement pre=null;
		ResultSet  rs=null;
		try {
			pre=c.prepareStatement("select * from users where userID=?");
			//���ַ�����ת������ֵ��
			pre.setString(1, userID);
			rs=pre.executeQuery();//�жϲ�ѯ�Ƿ��з���ֵ
			if(rs.next()){
				user=new User();
				user.setUserID(rs.getInt("UserID"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				user.setRealname(rs.getString("Realname"));
				user.setStatus(rs.getBoolean("status"));
				user.setAge(rs.getInt("Age"));
				user.setImage(rs.getString("Image"));
				user.setSex(rs.getString("Sex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getdetailinfo(String userID) {
		User user=null;
		Connection  c=getConnection();
		PreparedStatement  pre=null;
		ResultSet  rs=null;
		Set<Address>  adds=null;
		try {
			pre=c.prepareStatement("select u.*,a.* from users as u,address as a  where a.userid=u.userid and  u.userid=?");
			pre.setInt(1, Integer.parseInt(userID));
			rs=pre.executeQuery();
			while(rs.next()){
				if(user==null)
				{
					adds=new HashSet<>();
					user=new User();
					user.setUserID(rs.getInt("UserID"));
					user.setUsername(rs.getString("Username"));
					user.setPassword(rs.getString("Password"));
					user.setRealname(rs.getString("Realname"));
					user.setStatus(rs.getBoolean("status"));
					user.setAge(rs.getInt("Age"));
					user.setImage(rs.getString("Image"));
					user.setSex(rs.getString("Sex"));
					Address a=new Address();
					a.setAddressId(rs.getInt("addressid"));
					a.setProvince(rs.getString("province"));
					a.setCity(rs.getString("city"));
					a.setArea(rs.getString("area"));
					a.setStreet(rs.getString("street"));
					a.setDetail(rs.getString("detail"));
					a.setTel(rs.getString("tel"));
					a.setUser(rs.getString("user"));
					adds.add(a);
				}
				user.setAdds(adds);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre,rs);
		return user;
	}

	@Override
	public User getUserInfoByUserId(String userid) {
		User user=null;
		Connection c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=c.prepareStatement("select * from users where userid=?" );
			pre.setInt(1, Integer.parseInt(userid));
			rs=pre.executeQuery();
			while(rs.next())
			{
				user=new User();
				user.setUserID(rs.getInt("UserID"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				user.setRealname(rs.getString("Realname"));
				user.setStatus(rs.getBoolean("status"));
				user.setAge(rs.getInt("Age"));
				user.setImage(rs.getString("Image"));
				user.setSex(rs.getString("Sex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}