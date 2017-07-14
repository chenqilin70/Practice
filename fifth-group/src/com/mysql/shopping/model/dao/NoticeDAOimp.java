package com.mysql.shopping.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import admin.com.oracle.model.bean.Notice;



public class NoticeDAOimp extends BaseDAOimp implements NoticeDAO {

	Connection c=null;
	PreparedStatement pre=null;
	public boolean add(Object obj) {
		Notice n=(Notice)obj;
		c=getConnection();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date=df.format(new Date());
		try {
			pre=c.prepareStatement("insert into notice values(?,?,?,?,null,?)");
			pre.setString(1, n.getNotice());
			pre.setString(2, n.getHonor());
			pre.setString(3, n.getBest());
			pre.setString(4, date);
			pre.setString(5, n.getPerson());
			int u=pre.executeUpdate();
			return u>0? true: false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre);
		return false;
		
	}

	public boolean delete(Object obj) {
		int id=(int)obj;
		Connection c=getConnection();
		PreparedStatement pre=null;
		try {
			pre=c.prepareStatement("delete from notice where id=?");
			pre.setInt(1, id);
			int n=pre.executeUpdate();
			return n>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre);
		return false;
	}

	public boolean update(Object obj) {
		Notice nt=(Notice)obj;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date=df.format(new Date());
		Connection c=getConnection();
		PreparedStatement pre=null;
		String sql="update notice set notice=? , honor=? , best=? , date=? ,person=? where id=?";
		try {
			pre=c.prepareStatement(sql);
			pre.setString(1, nt.getNotice());
			pre.setString(2, nt.getHonor());
			pre.setString(3, nt.getBest());
			pre.setString(4, date);
			pre.setString(5, nt.getPerson());
			pre.setInt(6, nt.getId());
			
			return pre.executeUpdate()>0?true:false;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre);
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
			pre=c.prepareStatement("select * from notice order by id desc limit ?,? ");
			pre.setInt(1, (page-1)*count);
			pre.setInt(2, count);
			rs=pre.executeQuery();
			while(rs.next()){
				Notice n=new Notice();
				n.setNotice(rs.getString("notice"));
				n.setHonor(rs.getString("honor"));
				n.setBest(rs.getString("best"));
				n.setDate(rs.getString("date"));
				n.setId(rs.getInt("id"));
				n.setPerson(rs.getString("person"));
				nt.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre, rs);
		return nt;
	}

	@Override
	public Notice searchNoticeById(int id) {
		Notice n=new Notice();
		Connection c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		String sql="select * from notice where id=?";
		try {
			pre=c.prepareStatement(sql);
			pre.setInt(1,id);
			rs=pre.executeQuery();
			while(rs.next()){
				n.setNotice(rs.getString("notice"));
				n.setHonor(rs.getString("honor"));
				n.setBest(rs.getString("best"));
				n.setDate(rs.getString("date"));
				n.setId(rs.getInt("id"));
				n.setPerson(rs.getString("person"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre, rs);
		return n;
	}
	
	public List<Notice> selectNotice(int date){
		int selectdate=-date;
		List<Notice> nt=new ArrayList<>();
		Connection c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		 String nowdate=df.format(new Date());
		 System.out.println(nowdate);
		 
		 Date date1=new Date();//取时间 
		 try {
			date1=df.parse(nowdate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	     Calendar   calendar   =   new   GregorianCalendar(); 
	     calendar.setTime(date1); 
	     calendar.add(calendar.DATE,selectdate);//把日期往后增加天.整数往后推,负数往前移动 
	     date1=calendar.getTime();   //这个时间就是日期往后推天的结果
	     System.out.println(date1);
	     
	     String date2=df.format(date1);
	     System.out.println(date2);
		
		
		
		try {
			pre=c.prepareStatement("select * from notice where date BETWEEN ? AND ? order by id desc");
			pre.setString(1,date2);
			pre.setString(2,nowdate);
			rs=pre.executeQuery();
			while(rs.next()){
				Notice n=new Notice();
				n.setNotice(rs.getString("notice"));
				n.setHonor(rs.getString("honor"));
				n.setBest(rs.getString("best"));
				n.setPerson(rs.getString("person"));
				n.setDate(rs.getString("date"));
				n.setId(rs.getInt("id"));
				nt.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre, rs);
		return nt;
	}

}
