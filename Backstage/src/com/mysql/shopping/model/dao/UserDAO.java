package com.mysql.shopping.model.dao;

import com.mysql.shopping.model.bean.User;

public interface UserDAO extends BaseDAO{

	public User login(String username,String password);

	public User serchinformation(String userID);

	public User getdetailinfo(String userID);

	public User getUserInfoByUserId(String userid);



}
