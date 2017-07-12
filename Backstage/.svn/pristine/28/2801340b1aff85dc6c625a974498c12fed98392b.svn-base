package com.mysql.shopping.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.shopping.admin.bean.Notice;

public class NoticeDAOimp extends BaseDAOimp implements NoticeDAO {

	Connection c=null;
	PreparedStatement pre=null;
	public boolean add(Object obj) {
		Notice n=(Notice)obj;
		c=getConnection();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date=df.format(new Date());
		try {
			pre=c.prepareStatement("insert into notice values(?,?,?,?,null)");
			pre.setString(1, n.getNotice());
			pre.setString(2, n.getHonor());
			pre.setString(3, n.getBest());
			pre.setString(4, date);
			int u=pre.executeUpdate();
			return u>0? true: false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre);
		return false;
		
	}

	public boolean delete(Object obj) {
		return false;
	}

	public boolean update(Object obj) {
		return false;
	}

	public Object listAll() {
		return null;
	}

}
