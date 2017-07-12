package com.mysql.shopping.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.shopping.model.bean.Goods;
import com.mysql.shopping.model.bean.Orders;

public interface OrderDAO extends BaseDAO{

	public boolean saveorders(Orders o, HashMap<Goods,Integer> orderitmes);

	public Orders listOrder(String orderId);

	public ArrayList<Orders> listallorder(String userid);
	

}
