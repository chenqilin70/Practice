package com.oracle.struts.model.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.mysql.shopping.model.bean.order;
import com.mysql.shopping.model.dao.OrdersDaoImp;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
private order order;
private int st;
private String uid;
ArrayList<order> ao;
private OrdersDaoImp dao;
private String cat;

public order getOrder() {
	return order;
}
public void setOrder(order order) {
	this.order = order;
}
public int getSt() {
	return st;
}
public void setSt(int st) {
	this.st = st;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public ArrayList<order> getAo() {
	return ao;
}
public void setAo(ArrayList<order> ao) {
	this.ao = ao;
}
public OrdersDaoImp getDao() {
	return dao;
}
public void setDao(OrdersDaoImp dao) {
	this.dao = dao;
}
public String getCat() {
	return cat;
}
public void setCat(String cat) {
	this.cat = cat;
}
public String listorder(){
	System.out.println(cat);
	dao=new OrdersDaoImp();
	ArrayList<order>	ab=new ArrayList<order>();
	if(cat==null){
		ao=(ArrayList<order>)(dao.listOrder(1));
		ab=(ArrayList<order>)(dao.listOrder(0));
		ao.addAll(ab);
	}else{
		if(cat.equals("1")){
		    ao=(ArrayList<order>)(dao.listOrder(1));}
			 if(cat.equals("2")){
				ao=(ArrayList<order>)(dao.listOrder(0));
			}
			 if(cat.equals("0")){
				 ao=(ArrayList<order>)(dao.listOrder(1));
					ab=(ArrayList<order>)(dao.listOrder(0));
					ao.addAll(ab);
				}
	}
	
	//System.out.println(ao.toString());
	ServletActionContext.getRequest().setAttribute("ao", ao);
	return "success";
}
}
