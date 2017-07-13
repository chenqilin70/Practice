package com.oracle.struts.model.action;

import com.mysql.shopping.model.dao.GoodsDAO;
import com.mysql.shopping.model.dao.GoodsDAOimp;
import com.opensymphony.xwork2.ActionSupport;

import admin.com.oracle.model.bean.Product;

@SuppressWarnings("serial")
public class ProductAction extends ActionSupport {
	
	private Product p;
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public GoodsDAO getDao() {
		return dao;
	}
	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	private GoodsDAO  dao;//productDAO
	public ProductAction(){
		dao=new GoodsDAOimp();
	}
	public String addproduct()
	{
		System.out.println(p);
		boolean result=	dao.addProduct(p);
		return result?"addsuccess":"adderror";
	}
	

}
