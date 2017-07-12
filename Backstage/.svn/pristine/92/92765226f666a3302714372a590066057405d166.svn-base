package com.mysql.shopping.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.shopping.model.bean.Goods;

public class GoodsDAOimp extends BaseDAOimp implements GoodsDAO {

	
	@Override
	public boolean add(Object obj) {
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		return false;
	}

	@Override
	public boolean update(Object obj) {
		return false;
	}

	@Override
	public Object listAll() {
		return null;
	}

	@Override
	public List<Goods>  listAllByProductType(String typeName){
		List<Goods>  gs=new ArrayList<>();
		Connection  c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=c.prepareStatement("select * from product where seris=?");
			pre.setString(1, typeName);
			rs=pre.executeQuery();
			while(rs.next()){
				Goods good=new Goods();
				good.setName(rs.getString("name"));
				good.setProductid(rs.getInt("productid"));
				good.setBrand(rs.getString("brand"));
				good.setDescription(rs.getString("description"));
				good.setBasicprice(rs.getFloat("basicprice"));
				good.setTypeid(rs.getInt("typeid"));
				good.setSeris(rs.getString("seris"));
				good.setImage(rs.getString("image"));
				gs.add(good);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(c, pre,rs);
		return gs;
	}

	
	@Override
	public List<Goods> listgoodbybrand(String brand) {
		List<Goods>  gs=new ArrayList<>();
		Connection  c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=c.prepareStatement("select * from product where brand=?");
			pre.setString(1, brand);
			rs=pre.executeQuery();
			while(rs.next()){
				Goods brand1=new Goods();
				brand1.setName(rs.getString("name"));
				brand1.setProductid(rs.getInt("productid"));
				brand1.setBrand(rs.getString("brand"));
				brand1.setDescription(rs.getString("description"));
				brand1.setBasicprice(rs.getFloat("basicprice"));
				brand1.setTypeid(rs.getInt("typeid"));
				brand1.setSeris(rs.getString("seris"));
				brand1.setImage(rs.getString("image"));
				gs.add(brand1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre);
		return gs;
	}
	
	
	
	@Override
	public List<Goods> listgoodsbyname(String name) {
		List<Goods>  gs=new ArrayList<>();
		Connection  c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=c.prepareStatement("select * from product where name=?");
			pre.setString(1, name);
			rs=pre.executeQuery();
			while(rs.next()){
				Goods gn1=new Goods();
				gn1.setName(rs.getString("name"));
				gn1.setProductid(rs.getInt("productid"));
				gn1.setBrand(rs.getString("brand"));
				gn1.setDescription(rs.getString("description"));
				gn1.setBasicprice(rs.getFloat("basicprice"));
				gn1.setTypeid(rs.getInt("typeid"));
				gn1.setSeris(rs.getString("seris"));
				gn1.setImage(rs.getString("image"));
				gs.add(gn1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre);
		return gs;
	}
	
	
	@Override
	public List<Goods> listgooddetail(String productid) {
		List<Goods> gs=new ArrayList<>();;
		Connection  c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=c.prepareStatement("select * from product where productid=?");
			pre.setString(1, productid);
			rs=pre.executeQuery();
			while(rs.next()){
				Goods gd1=new Goods();
				gd1.setName(rs.getString("name"));
				gd1.setProductid(rs.getInt("productid"));
				gd1.setBrand(rs.getString("brand"));
				gd1.setDescription(rs.getString("description"));
				gd1.setBasicprice(rs.getFloat("basicprice"));
				gd1.setTypeid(rs.getInt("typeid"));
				gd1.setSeris(rs.getString("seris"));
				gd1.setImage(rs.getString("image"));
				gs.add(gd1);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre);
		return gs;
	}
	
	
	
	
	@Override
	public List<Goods> listAllProduct(int page, int count) {
		List<Goods>  gs=new ArrayList<>();
		Connection  c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=c.prepareStatement("select * from product order by productid limit ?,? ");
			//第一个是页码，第二个代表多少条
			pre.setInt(1, (page-1)*count);
			pre.setInt(2, count);
			rs=pre.executeQuery();
		while(rs.next()){
			Goods good=new Goods();
			good.setName(rs.getString("name"));
			good.setProductid(rs.getInt("productid"));
			good.setBrand(rs.getString("brand"));
			good.setDescription(rs.getString("description"));
			good.setBasicprice(rs.getFloat("basicprice"));
			good.setTypeid(rs.getInt("typeid"));
			good.setSeris(rs.getString("seris"));
			good.setImage(rs.getString("image"));
			gs.add(good);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	disposeResource(c, pre,rs);
		return gs;
	}

	@Override
	public int getAllProduct() {
		Connection  c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			//聚合函数
			pre=c.prepareStatement("select count(*) from product");
		    rs=pre.executeQuery();
		    rs.next();
		    return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre, rs);
		return 0;
	}

	@Override
	public Goods addgoodstocar(String productid) {
		Goods gs=new Goods();
		Connection  c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=c.prepareStatement("select * from product where productid=?");
			pre.setString(1, productid);
			rs=pre.executeQuery();
			while(rs.next()){
				gs.setName(rs.getString("name"));
				gs.setProductid(rs.getInt("productid"));
				gs.setBrand(rs.getString("brand"));
				gs.setDescription(rs.getString("description"));
				gs.setBasicprice(rs.getFloat("basicprice"));
				gs.setTypeid(rs.getInt("typeid"));
				gs.setSeris(rs.getString("seris"));
				gs.setImage(rs.getString("image"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre);
		return gs;
	}

	@Override
	public List<Goods> searchGoods(String key) {
		List<Goods>  gs=new ArrayList<>();
		Connection  c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=c.prepareStatement("select * from product where seris like '%"+key+"%' or name like '%"+key+"%' or brand like '%"+key+"%' or description like '%"+key+"%' order by productId" );
			System.out.println(pre);
			rs=pre.executeQuery();
			while(rs.next()){
				Goods good=new Goods();
				good.setName(rs.getString("name"));
				good.setProductid(rs.getInt("productid"));
				good.setBrand(rs.getString("brand"));
				good.setDescription(rs.getString("description"));
				good.setBasicprice(rs.getFloat("basicprice"));
				good.setTypeid(rs.getInt("typeid"));
				good.setSeris(rs.getString("seris"));
				good.setImage(rs.getString("image"));
				gs.add(good);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gs;
	}

	@Override
	public int getAllkeygoods(String key) {
		Connection  c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			//聚合函数
			pre=c.prepareStatement("select count(*) from product where seris like '%"+key+"%' or name like '%"+key+"%' or brand like '%"+key+"%' or description like '%"+key+"%' order by productId");
		    rs=pre.executeQuery();
		    rs.next();
		    return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre, rs);
		return 0;
	}

	@Override
	public List<Goods> listAllkeygoods(String key, int page, int count) {
		List<Goods>  gs=new ArrayList<>();
		Connection  c=getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=c.prepareStatement("select * from product where seris like '%"+key+"%' or name like '%"+key+"%' or brand like '%"+key+"%' or description like '%"+key+"%'  order by productid limit ?,? ");
			//第一个是页码，第二个代表多少条
			pre.setInt(1, (page-1)*count);
			pre.setInt(2, count);
			rs=pre.executeQuery();
		while(rs.next()){
			Goods good=new Goods();
			good.setName(rs.getString("name"));
			good.setProductid(rs.getInt("productid"));
			good.setBrand(rs.getString("brand"));
			good.setDescription(rs.getString("description"));
			good.setBasicprice(rs.getFloat("basicprice"));
			good.setTypeid(rs.getInt("typeid"));
			good.setSeris(rs.getString("seris"));
			good.setImage(rs.getString("image"));
			gs.add(good);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	disposeResource(c, pre,rs);
		return gs;
	}

	@Override
	public ArrayList<String> ajaxSearch(String key) {
		Connection  c=getConnection();
		PreparedStatement pre=null;
		ArrayList<String>  seris=new ArrayList<>();
		ResultSet rs=null;
		try {
			 pre=c.prepareStatement("select name  from product where seris like '%"+key+"%' or name like '%"+key+"%' or brand like '%"+key+"%' or description like '%"+key+"%'  limit 5");
			 rs=pre.executeQuery();
			 while(rs.next()){
				 seris.add(rs.getString(1));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(c, pre, rs);
		return seris;
	}

}
