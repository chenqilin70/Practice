package com.huwl.oracle.servlet;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwl.oracle.bean.Product;


public class ProductServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		File imgs=new File(req.getServletContext().getRealPath("imgs"));
		File[] imgFiles=imgs.listFiles();
		List<Product> list=new ArrayList<>();
		for(File f:imgFiles){
			Product p=new Product();
			String fileName=f.getName();
			p.setName(fileName+"号商品");
			p.setPrice(new Random().nextInt(20)+20);
			p.setImg("http://120.24.244.103:8080/ProductShowerServer/imgs/"+fileName);
			list.add(p);
		}
		ObjectMapper objectMapper=new ObjectMapper();
		String jsonStr=objectMapper.writeValueAsString(list);
		Writer writer=resp.getWriter();
		writer.write(jsonStr);
		writer.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
