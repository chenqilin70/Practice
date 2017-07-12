package com.mysql.shopping.control.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.shopping.model.bean.Goods;
import com.mysql.shopping.model.bean.Orders;
import com.mysql.shopping.model.bean.User;
import com.mysql.shopping.model.dao.OrderDAO;
import com.mysql.shopping.model.dao.OrderDAOimp;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/OrderServlet")
public class OrderServlet extends HttpServlet{
	
	private OrderDAO orderdao;
	
	public OrderServlet(){
		
		orderdao=new OrderDAOimp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName=request.getParameter("method");
		
		switch(methodName)
		{
			case("listallorder"):
			{
				listallorder(request,response);
				break;
			}
			case("listOrderById"):
			{
				System.out.println("将订单显示出来");
				listOrderById(request,response);
				break;
			}
			case("addgoodslist"):
			{
				System.out.println("进入订单方法");
				/**生成商品订单的方法*/
				addgoodslist(request,response);
				break;
			}
			default:
			break;
		}
	}
	

	//将该用户的所有订单罗列出来
	private void listallorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String userid=request.getParameter("userid");
		System.out.println("该用户的id为："+userid);
		System.out.println(userid);
		ArrayList<Orders> os=orderdao.listallorder(userid);
		request.setAttribute("os", os);
		request.getRequestDispatcher("orderitem.jsp").forward(request, response);
	}

	//将生成的订单显示出来的方法
	private void listOrderById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId=request.getParameter("orderId");
		Orders o=orderdao.listOrder(orderId);
		request.setAttribute("o", o);
		request.getRequestDispatcher("orderitem.jsp").forward(request, response);
	}
	
	//将购物车购买的东西添加到数据库生成订单的方法
	private void addgoodslist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//分析需要生成订单的信息订单id（数据库自动生成），时间，状态，地址id，用户名id
		String addressid=request.getParameter("addressid");
		System.out.println("收货地址编号:"+addressid);
		//将存入在session的用户id取出
		int userid=((User)request.getSession().getAttribute("Loginuser")).getUserID();
		@SuppressWarnings("deprecation")
		String time=new Date().toLocaleString();//自动获取当前时间
		int statu=1;//代表未发货
		//定义一个订单对象，传给后台数据库
		String message="imform";
		String orderId=UUID.randomUUID().toString();
		Orders o=new Orders(orderId,time,statu,userid,Integer.parseInt(addressid),message);
		//这里传入的object类型，需要对其进行强转,这里返回的是一个boolean类型
		System.out.println("即将进入imp实现类");
		@SuppressWarnings("unchecked")
		boolean savestatu=orderdao.saveorders(o,(HashMap<Goods, Integer>)request.getSession().getAttribute("shoppingcar"));
		if(savestatu)
		{
			System.out.println("插入成功");
			response.sendRedirect("OrderServlet?method=listallorder&userid="+userid);
		}else
		{
			System.out.println("插入失败");
		}
	}
	
	
}
