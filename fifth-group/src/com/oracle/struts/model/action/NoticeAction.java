package com.oracle.struts.model.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.mysql.shopping.model.dao.NoticeDAOimp;
import com.opensymphony.xwork2.ActionSupport;

import admin.com.oracle.model.bean.Notice;

public class NoticeAction extends ActionSupport {
	private Notice n;
	private NoticeDAOimp dao;
	private List<Notice> notices;
	private int id;
	private String message;
	private int date;
	
	
	
	
	

	
	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	public Notice getN() {
		return n;
	}

	public void setN(Notice n) {
		this.n = n;
	}



	public NoticeAction() {
		dao=new NoticeDAOimp();
	}

	public String addNotice(){
		System.out.println("inter addNotice");
		System.out.println(n);
		boolean re=dao.add(n);
		notices=dao.loadAllnotice(1, 20);
		System.out.println(notices);
		return re==true?"addSuccess":"addFail";

	}
	
	public String loadAllnotice(){
		System.out.println("inter loadAllnotice");
		notices=dao.loadAllnotice(1, 20);
		System.out.println(notices);
		ServletActionContext.getRequest().setAttribute("n", notices);
		return notices!=null?"selectAllsuccess":"selectAllfail";

	}
	
	public String updateNotice(){
		System.out.println("inter updateNotice");
		System.out.println(n);
		boolean re=dao.update(n);
		return re?"updateSuccess":"updateFail";
		
	}
	
	public String searchNoticeById(){
		System.out.println("inter searchNoticeById");
		System.out.println("id  "+id);
		n=dao.searchNoticeById(id);
		System.out.println(n);
		
		return "searchidSuccess";
	}
	
	public String deleteNotice(){
		System.out.println("inter deleteNotice");
		System.out.println(id);
		boolean re=dao.delete(id);
		if(re){
			message="删除成功";
			return "deleteSuccess";
		}else{
			message="删除失败";
			return "deleteFail";
		}
	}
	
	public String selectNotice(){
		System.out.println("inter selectNotice");
		System.out.println(date);
		notices=dao.selectNotice(date);
		System.out.println(notices);
		
		return notices!=null?"selectSuccess":"selectFail";
	}
	
	
	
	

}
