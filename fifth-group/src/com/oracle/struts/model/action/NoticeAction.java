package com.oracle.struts.model.action;

import com.mysql.shopping.model.bean.Notice;
import com.mysql.shopping.model.dao.NoticeDAOimp;
import com.opensymphony.xwork2.ActionSupport;

public class NoticeAction extends ActionSupport {
	private Notice n;
	private NoticeDAOimp nip;


	public Notice getN() {
		return n;
	}

	public void setN(Notice n) {
		this.n = n;
	}



	public NoticeAction() {
		nip=new NoticeDAOimp();
	}

	public String addNotice(){
		System.out.println("inter addNotice");
		System.out.println(n);
		return null;
		

	}
	
	
	
	

}
