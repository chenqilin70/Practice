package com.mysql.shopping.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import admin.com.oracle.model.bean.Notice;



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

	@Override
	public List<Notice> loadAllnotice(int page, int count) {
		List<Notice> nt=new ArrayList<>();
		c=getConnection();
		ResultSet rs=null;
		try {
			pre=c.prepareStatement("select * from notice order by id limit ?,?");
			pre.setInt(1, (page-1)*count);
			pre.setInt(2, count);
			rs=pre.executeQuery();
			while(rs.next()){
				Notice n=new Notice();
				n.setNotice(rs.getString("notice"));
				n.setHonor(rs.getString("honor"));
				n.setBest(rs.getString("best"));
				n.setDate(rs.getString("date"));
				nt.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre, rs);
		return nt;
	}

}
