package com.mysql.shopping.admin.action;

import com.mysql.shopping.admin.bean.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {
	private Product p;
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public ProductAction(Product p) {
		super();
		this.p = p;
	}
	public String addproduct()
	{
		System.out.println("准备提交数据");
		//1.获取界面的数�?
		return "addsuccess";
		
	}

}
