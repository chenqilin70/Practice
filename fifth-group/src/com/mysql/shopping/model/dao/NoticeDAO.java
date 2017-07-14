package com.mysql.shopping.model.dao;

import java.util.List;

import admin.com.oracle.model.bean.Notice;

public interface NoticeDAO extends BaseDAO{
	public List<Notice> loadAllnotice(int page,int count);
	
	public Notice searchNoticeById(int id);
	
	public List<Notice> selectNotice(int date);

}
