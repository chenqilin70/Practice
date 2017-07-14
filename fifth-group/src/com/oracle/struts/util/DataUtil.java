package com.oracle.struts.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.shopping.model.bean.Address;
import com.mysql.shopping.model.bean.User;
import com.mysql.shopping.model.dao.AddressDAO;
import com.mysql.shopping.model.dao.AddressDAOImp;
import com.mysql.shopping.model.dao.OrderDAO;
import com.mysql.shopping.model.dao.OrderDAOimp;
import com.mysql.shopping.model.dao.UserDAO;
import com.mysql.shopping.model.dao.UserDAOimp;

public class DataUtil {
	private static OrderDAO orderDao=new OrderDAOimp();
	private static UserDAO userDao=new UserDAOimp();
	private static AddressDAO addrDao=new AddressDAOImp();
	private static Random ran=new Random();
	private static ObjectMapper objectMapper=new ObjectMapper();
	public static void main(String[] args) throws ParseException {
		// readyOrder()
		//readyUser();
		readyAddr();
	}
	public static void readyAddr(){
		final String[] addrArr=new String[]{"海门","鄂尔多斯","招远","舟山","齐齐哈尔","盐城","赤峰","青岛","乳山","金昌","泉州","莱西","日照","胶南","南通","拉萨","云浮","梅州","文登","上海","攀枝花","威海","承德","厦门","汕尾","潮州","丹东","太仓","曲靖","烟台","福州","瓦房店","即墨","抚顺","玉溪","张家口","阳泉","莱州","湖州","汕头","昆山","宁波","湛江","揭阳","荣成","连云港","葫芦岛","常熟","东莞","河源","淮安","泰州","南宁","营口","惠州","江阴","蓬莱","韶关","嘉峪关","广州","延安","太原","清远","中山","昆明","寿光","盘锦","长治","深圳","珠海","宿迁","咸阳","铜川","平度","佛山","海口","江门","章丘","肇庆","大连","临汾","吴江","石嘴山","沈阳","苏州","茂名","嘉兴","长春","胶州","银川","张家港","三门峡","锦州","南昌","柳州","三亚","自贡","吉林","阳江","泸州","西宁","宜宾","呼和浩特","成都","大同","镇江","桂林","张家界","宜兴","北海","西安","金坛","东营","牡丹江","遵义","绍兴","扬州","常州","潍坊","重庆","台州","南京","滨州","贵阳","无锡","本溪","克拉玛依","渭南","马鞍山","宝鸡","焦作","句容","北京","徐州","衡水","包头","绵阳","乌鲁木齐","枣庄","杭州","淄博","鞍山","溧阳","库尔勒","安阳","开封","济南","德阳","温州","九江","邯郸","临安","兰州","沧州","临沂","南充","天津","富阳","泰安","诸暨","郑州","哈尔滨","聊城","芜湖","唐山","平顶山","邢台","德州","济宁","荆州","宜昌","义乌","丽水","洛阳","秦皇岛","株洲","石家庄","莱芜","常德","保定","湘潭","金华","岳阳","长沙","衢州","廊坊","菏泽","合肥","武汉","大庆"};
		final List<String> addrList=new ArrayList<>();
		for(String s:addrArr){
			addrList.add(s);
		}
		for(int i=0;i<4;i++){
			addrList.add("深圳");
			addrList.add("上海");
			addrList.add("武汉");
			addrList.add("北京");
			addrList.add("杭州");
			addrList.add("重庆");
		}
		for(int i=0;i<10;i++){
			new Thread(){
				public void run() {
					for(int j=0;j<3000;j++){
						int ranNum=ran.nextInt(addrList.size());
						String user=(ran.nextInt(77745)+7)+"";
						System.out.println("*****"+user);
						addrDao.add(new Address("p", addrList.get(ranNum), "a"+j, "s"+j, "统计测试数据", "110"+j,user));
						System.out.println("插入数据："+j);
					}
				};
			}.start();
			
		}
	}
	public static void readyUser(){
		for(int j=0;j<8;j++){
			final int threadNum=j;
			final Random ran=new Random();
			new Thread(){
				public void run() {
					System.out.println("开启第"+threadNum+"线程");
					for(int i=0;i<10000;i++){
						userDao.add(
								new User(10+(threadNum)*10000+i
										, "kylin"+((threadNum)*10000)+i
										, "1147673588"
										, "陈麒麟"+((threadNum)*10000)+i
										, ran.nextInt(2)+""
										, 13
										, "image/User/title.jpg"
										, true)
								);
						System.out.println("第"+threadNum+"线程插入数据："+i);
					}
				};
			}.start();
			
		}
	}
	public static void getJavaCodeByJson(){
		//userDao.add(new User(9, "kylin", "1147673588", "陈麒麟", "男", 13, "image/User/title.jpg", true));
		InputStream in=DataUtil.class.getClassLoader().getResourceAsStream("address.json");
		int len=-1;
		byte[] buffer=new byte[1024];
		OutputStream out=new ByteArrayOutputStream();
		try {
			while((len=in.read(buffer))!=-1){
				out.write(buffer,0,len);
			}
			JsonNode root=objectMapper.readTree(
					out.toString()
					.replace("name", "\"name\"")
					.replace("value", "\"value\"")
					.replace("'", "\""));
			StringBuffer sb=new StringBuffer();
			sb.append("String[] addrArr=new String[]{");
			for(JsonNode n:root){
				sb.append(n.get("name")+",");
			}
			sb.substring(0,sb.lastIndexOf(","));
			sb.append("};");
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
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
