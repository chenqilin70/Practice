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
		
		private Properties  p;//����һ����ֵ�Ե�properties���϶���������ȡ�����ļ��е��������ݿ�Ĳ���
		{
			//��database.properties���涨����Ǵ������ݿ�����֣������������ݿ�
			p=new Properties();
			try {
				InputStream in=this.getClass().getClassLoader().getResourceAsStream("database.properties");
				p.load(in);
				//p.load(new FileInputStream("D://oracle//workspace//fifth-group//WebContent//WEB-INF//database.properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * final�Ļ�ȡ���ӵķ�����
		 * @return
		 */
		public final  Connection  getConnection()
		{
			Connection con=null;
			try {
				//��������
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

