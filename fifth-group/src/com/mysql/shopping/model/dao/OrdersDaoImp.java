package com.mysql.shopping.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.mysql.shopping.model.bean.Address;
import com.mysql.shopping.model.bean.Orderitems;
import com.mysql.shopping.model.bean.Orders;
import com.mysql.shopping.model.bean.order;

public class OrdersDaoImp extends BaseDAOimp implements OrdersDao {

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
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
	public ArrayList<order> listOrder(int st) {
		ArrayList<order> os=new ArrayList<>();
		order  o=null;
		Address a=null;
		Set<Orderitems>  prm=null;
		Connection  con=getConnection();
		PreparedStatement pre=null;
		ResultSet  rs=null;
		try {
			pre=con.prepareStatement("select o.*,oi.*,a.* ,p.basicprice from orders as o ,orderitems as oi,address as a ,product as p where o.orderid=oi.orderid and o.addressid=a.addressid and oi.productid=p.productid and o.status=?");
			pre.setInt(1,st);
			rs=pre.executeQuery();
			while(rs.next())
			{
				
				o=new order();
					o.setOid(rs.getString("o.orderid"));
					o.setTi(rs.getString("time"));
					o.setSt(rs.getInt("status"));
				a=new Address();
					a.setAddressId(rs.getInt("addressid"));
					a.setProvince(rs.getString("province"));
					a.setCity(rs.getString("city"));
					a.setArea(rs.getString("area"));
					a.setStreet(rs.getString("street"));
					a.setDetail(rs.getString("detail"));
					a.setTel(rs.getString("tel"));
					a.setUser(rs.getString("user"));
					o.setTe(rs.getString("tel"));
					o.setPe(rs.getString("user"));
					o.setAd(a);
					o.setTot(rs.getFloat("basicprice"));
				prm=new HashSet<>();
				Orderitems  item=new Orderitems();
				item.setCount(rs.getInt("count"));
				item.setDiscount(rs.getFloat("discount"));
				item.setOrderid(rs.getString("o.orderid"));
				item.setOrderitemid(rs.getInt("orderitemid"));
				item.setProductid(rs.getInt("productid"));
				prm.add(item);
				o.setPrm(prm);
				os.add(o);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return os;
	
}

	@Override
	public order deleteOrder(String oid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<order> listallorder(String userid) {
		// TODO Auto-generated method stub
		ArrayList<order> os=new ArrayList<>();
		order o=null;
		Address a=null;
		Set<Orderitems>  prm=null;
		Connection con=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=con.prepareStatement("select o.*,oi.*,a.*,p.basicprice from orders as o ,orderitems as oi,address as a ,product as p where o.orderid=oi.orderid and o.addressid=a.addressid and oi.productid=p.productid and o.userid=?");
			pre.setString(1, userid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				o=new order();
				//o.setUserid(rs.getInt("userid"));
				o.setTi(rs.getString("time"));
				o.setSt(rs.getInt("status"));
				o.setOid(rs.getString("o.orderid"));
				a=new Address();
				a.setAddressId(rs.getInt("addressId"));
				a.setProvince(rs.getString("province"));
				a.setCity(rs.getString("city"));
				a.setArea(rs.getString("area"));
				a.setStreet(rs.getString("street"));
				a.setDetail(rs.getString("detail"));
				a.setTel(rs.getString("tel"));
				a.setUser(rs.getString("user"));
				o.setTe(rs.getString("tel"));
				o.setPe(rs.getString("user"));
				o.setAd(a);
				o.setTot(rs.getFloat("basicprice"));
				prm=new HashSet<>();
				Orderitems  item=new Orderitems();
				item.setCount(rs.getInt("count"));
				item.setDiscount(rs.getFloat("discount"));
				item.setOrderid(rs.getString("o.orderid"));
				item.setOrderitemid(rs.getInt("orderitemid"));
				item.setProductid(rs.getInt("productid"));
				prm.add(item);
				o.setPrm(prm);
				os.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return os;
	}
	

	

	}
