package com.oracle.struts.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mysql.shopping.model.bean.User;
import com.mysql.shopping.model.dao.OrderDAO;
import com.mysql.shopping.model.dao.OrderDAOimp;
import com.mysql.shopping.model.dao.UserDAO;
import com.mysql.shopping.model.dao.UserDAOimp;

public class DataUtil {
	private static OrderDAO orderDao=new OrderDAOimp();
	private static UserDAO userDao=new UserDAOimp();
	private static Random ran=new Random();
	public static void main(String[] args) throws ParseException {
		// readyOrder()
		readyUser();
	}
	public static void readyUser(){
		userDao.add(new User(9, "kylin", "1147673588", "陈麒麟", "男", 13, "image/User/title.jpg", true));
	}
	public static void readyOrder(){
		for(int i=0;i<7;i++){
			final int num=i;
			new Thread(){
				public void run() {
					System.out.println(num+"线程启动成功！！");
					for(int j=0;j<1000;j++){
						orderDao.addStatisticalData();
						System.out.println(num+"线程成功插入数据："+j+"条");
					}
				};
			}.start();
		}
	}
}
