package com.huwl.oracle.wechat.catcher.user_catcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;






public class TestWechat {
public static void main(String[] args) {
	try {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-06-30 09:25:17").getTime());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
