package com.mysql.shopping.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.shopping.model.bean.Address;

public class AddressDAOImp extends BaseDAOimp implements AddressDAO {


	@Override
	public boolean add(Object obj) {
		Address addr=(Address) obj;
		Connection conn =getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into address values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, addr.getAddressId());
			ps.setString(2, addr.getProvince());
			ps.setString(3, addr.getCity());
			ps.setString(4, addr.getArea());
			ps.setString(5, addr.getStreet());
			ps.setString(6, addr.getDetail());
			ps.setString(7, addr.getTel());
			ps.setString(8, addr.getUser());
			System.out.println("---"+addr.getUser());
			System.out.println("+++"+Integer.parseInt(addr.getUser()));
			ps.setInt(9, Integer.parseInt(addr.getUser()));
			if(ps.executeUpdate()<1){
				return false;
			};
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			disposeResource(conn, ps);
		}
		return true;
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

	@Override
	public String getAddrDataJson() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
		    ps=conn.prepareStatement("select count(*) addrcount,CITY city "
		    		+ "from address "
		    		+ "WHERE CITY in('海门','鄂尔多斯','招远','舟山','齐齐哈尔','盐城','赤峰','青岛','乳山','金昌','泉州','莱西','日照','胶南','南通','拉萨','云浮','梅州','文登','上海','攀枝花','威海','承德','厦门','汕尾','潮州','丹东','太仓','曲靖','烟台','福州','瓦房店','即墨','抚顺','玉溪','张家口','阳泉','莱州','湖州','汕头','昆山','宁波','湛江','揭阳','荣成','连云港','葫芦岛','常熟','东莞','河源','淮安','泰州','南宁','营口','惠州','江阴','蓬莱','韶关','嘉峪关','广州','延安','太原','清远','中山','昆明','寿光','盘锦','长治','深圳','珠海','宿迁','咸阳','铜川','平度','佛山','海口','江门','章丘','肇庆','大连','临汾','吴江','石嘴山','沈阳','苏州','茂名','嘉兴','长春','胶州','银川','张家港','三门峡','锦州','南昌','柳州','三亚','自贡','吉林','阳江','泸州','西宁','宜宾','呼和浩特','成都','大同','镇江','桂林','张家界','宜兴','北海','西安','金坛','东营','牡丹江','遵义','绍兴','扬州','常州','潍坊','重庆','台州','南京','滨州','贵阳','无锡','本溪','克拉玛依','渭南','马鞍山','宝鸡','焦作','句容','北京','徐州','衡水','包头','绵阳','乌鲁木齐','枣庄','杭州','淄博','鞍山','溧阳','库尔勒','安阳','开封','济南','德阳','温州','九江','邯郸','临安','兰州','沧州','临沂','南充','天津','富阳','泰安','诸暨','郑州','哈尔滨','聊城','芜湖','唐山','平顶山','邢台','德州','济宁','荆州','宜昌','义乌','丽水','洛阳','秦皇岛','株洲','石家庄','莱芜','常德','保定','湘潭','金华','岳阳','长沙','衢州','廊坊','菏泽','合肥','武汉','大庆') "
		    		+ "group by CITY ");
		    rs=ps.executeQuery();
		    StringBuffer sb=new StringBuffer("");
		    sb.append("[");
		    while(rs.next()){
		    	String city=rs.getString("city");
		    	sb.append("{\"name\":\""+city+"\",");
		    	long addrcount=rs.getLong("addrcount");
		    	sb.append("\"value\":"+addrcount+"},");
		    }
		    sb=new StringBuffer(sb.substring(0,sb.length()-1));
		    sb.append("]");
		    return sb.toString();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			disposeResource(conn, ps,rs);
		}
	}

}
