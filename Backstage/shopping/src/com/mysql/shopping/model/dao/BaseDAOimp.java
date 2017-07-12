package com.mysql.shopping.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public abstract class BaseDAOimp implements BaseDAO {
		
		private Properties  p;//锟斤拷锟斤拷一锟斤拷锟斤拷值锟皆碉拷properties锟斤拷锟较讹拷锟斤拷锟斤拷锟斤拷锟斤拷取锟斤拷锟斤拷锟侥硷拷锟叫碉拷锟斤拷锟斤拷锟斤拷锟捷匡拷牟锟斤拷锟�
		{
			//锟斤拷database.properties锟斤拷锟芥定锟斤拷锟斤拷谴锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟街ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟捷匡拷
			p=new Properties();
			try {
				InputStream in=this.getClass().getClassLoader().getResourceAsStream("database.properties");
				p.load(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * final锟侥伙拷取锟斤拷锟接的凤拷锟斤拷锟斤拷
		 * @return
		 */
		public final  Connection  getConnection()
		{
			Connection con=null;
			try {
				//锟斤拷锟斤拷锟斤拷锟斤拷
				Class.forName(p.getProperty("driverName"));
				con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		
		
		public  void  disposeResource(Connection  c,PreparedStatement  pre){
			
			if(pre!=null)
			{
				try {
					pre.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public  void  disposeResource(Connection  c,PreparedStatement  pre,ResultSet  rs){
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pre!=null)
			{
				try {
					pre.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}

