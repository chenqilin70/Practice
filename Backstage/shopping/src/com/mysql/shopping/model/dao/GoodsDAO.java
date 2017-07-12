package com.mysql.shopping.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.mysql.shopping.model.bean.Goods;

public interface GoodsDAO {

	public List<Goods>  listAllByProductType(String typeName);

	public List<Goods> listAllProduct(int page, int count);

	public int getAllProduct();

	public List<Goods> listgoodbybrand(String brand);

	public List<Goods> listgooddetail(String productid);

	public List<Goods> listgoodsbyname(String name);

	public Goods addgoodstocar(String productid);

	public List<Goods> searchGoods(String key);

	public int getAllkeygoods(String key);

	public List<Goods> listAllkeygoods(String key, int parseInt, int parseInt2);

	public ArrayList<String> ajaxSearch(String key);



}