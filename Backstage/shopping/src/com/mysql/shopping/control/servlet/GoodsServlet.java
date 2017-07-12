package com.mysql.shopping.control.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.shopping.model.bean.Goods;
import com.mysql.shopping.model.bean.Page;
import com.mysql.shopping.model.dao.GoodsDAO;
import com.mysql.shopping.model.dao.GoodsDAOimp;


@SuppressWarnings("serial")
@WebServlet(urlPatterns="/GoodsServlet")
public class GoodsServlet extends HttpServlet{
	
	//定义成全局变量
	private GoodsDAO goodsdao;
	@Override
	public void init() throws ServletException {
		goodsdao=new GoodsDAOimp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//定义一个返回值，来判断要查询的商品类型方法名称
		String method=request.getParameter("method");
		switch(method)
		{
			case"listgoodsbyseris":{
				System.out.println("即将进入分类查询方法");
				listgoodsbyseris(request,response);
				break;//这里不要忘了加break否则程序会一直在里面出不来
				}
			case"listgoodbybrand":{
				System.out.println("即将进入品牌查询");
				listgoodbybrand(request,response);
				break;
			}
			case"listgoodsbypage":{
				System.out.println("这里进入分页查询");
				listgoodsbypage(request,response);
				break;
			}
			case"listgooddetail":{
				System.out.println("这里进入了单页查询方法");
				listgooddetail(request,response);
				break;
			}
			case"listgoodsbyname":{
				System.out.println("进入种类查询方法");
				listgoodsbyname(request,response);
				break;
			}
			case"addGoodstoshopcar":{
				System.out.println("将商品添加至购物车");
				addGoodstoshopcar(request,response);
				break;
			}
			case"deleteProduct":{
				deleteProduct(request,response);
				break;
			}
			case"searchGoods":{
				searchGoods(request,response);
				break;
			}
			case "ajaxSearch":
			{
				ajaxSearch(request, response);
				break;
			}
		}
	}
	private void ajaxSearch(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String key=request.getParameter("key");
		key=new String(key.getBytes("ISO8859-1"),"UTF-8");
		ArrayList<String> names=goodsdao.ajaxSearch(key);
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter  out=response.getWriter();
		out.write("<?xml version='1.0' encoding='UTF-8'  ?>");
		out.write("<seris>");
		for (String  name:names) {
			out.write("<name>"+name+"</name>");
		}
		out.write("</seris>");
		out.flush();
	}

	//模糊查询
	private void searchGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String key=request.getParameter("key");
		key=new String(key.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(key);
		String page=request.getParameter("page");
		String count=request.getParameter("count");
		int nowpage=Integer.parseInt(page);
		int firstpage=1;
		int allcount=goodsdao.getAllkeygoods(key);
		int lastpage=(allcount%Integer.parseInt(count)==0)?(allcount/Integer.parseInt(count)):(allcount/Integer.parseInt(count)+1);
		int prepage=(nowpage==1)?1:(nowpage-1);
		int nextpage=(nowpage==lastpage)?lastpage:(nowpage+1);
		
		if(request.getParameter("ajax")==null)
		{
			Page p=new Page(Integer.parseInt(count),nowpage,firstpage,prepage,nextpage,lastpage,allcount);
			List<Goods> gs=goodsdao.listAllkeygoods(key,Integer.parseInt(page), Integer.parseInt(count));
			request.setAttribute("page", p);
			request.getSession().setAttribute("key", key);
			request.setAttribute("gs", gs);
			request.getRequestDispatcher("products.jsp").forward(request, response);
		}
		else
		{
			System.out.println("正在努力加载");
			List<Goods> gs=goodsdao.listAllkeygoods(key,Integer.parseInt(page), Integer.parseInt(count));
			response.setContentType("text/json;charset=utf-8");
			PrintWriter out=response.getWriter();
			JSONArray  pps=new JSONArray();
			try {
				for(Goods g:gs)
				{
					JSONObject  o=new JSONObject();
					o.put("productid", g.getProductid());
					o.put("name", g.getName());
					o.put("seris", g.getSeris());
					o.put("description", g.getDescription());
					o.put("image", g.getImage());
					o.put("brand", g.getBrand());
					o.put("typeid", g.getTypeid());
					o.put("basicprice", g.getBasicprice());
					pps.put(o);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
				out.write(pps.toString());
				out.flush();
				out.close();
		}
	}

	/**删除在购物车的里的商品*/
private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String productid=request.getParameter("productid");
		System.out.println(productid);
		//获取当前购物称里的商品,删除相应的商品
		@SuppressWarnings("unchecked")
		HashMap<Goods, Integer> shoppingcar=(HashMap<Goods, Integer>)request.getSession().getAttribute("shoppingcar");
		float total=Float.parseFloat(request.getSession().getAttribute("total").toString());
		//-1表示的字符序列中的字符第一次出现的索引，如果此方法返回的字符不会发生
		if(productid.indexOf(",")==-1)
		{	//遍历在购物车里的所有商品
			for(Goods g:shoppingcar.keySet())
			{
				if(g.getProductid()==Integer.parseInt(productid))
				{
				System.out.println(g.getProductid());
				System.out.println(Integer.parseInt(productid));
				{
					total-=g.getBasicprice()*shoppingcar.get(g);
					shoppingcar.remove(g);
					break;
				}
				}
			}
		}else
		{
			String[] id=productid.split(",");
			for(String d:id)
			{
				for(Goods g:shoppingcar.keySet())
				{
					if(g.getProductid()==Integer.parseInt(d))
					{
						total-=g.getBasicprice()*shoppingcar.get(g);
						shoppingcar.remove(g);
						break;
					}
				}
			}
		}
		request.getSession().setAttribute("total", total);
		response.sendRedirect("checkout.jsp");
}


   /**将商品添加至购物车的方法*/
   @SuppressWarnings("unchecked")
private void addGoodstoshopcar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		String productid=request.getParameter("productid");
		String count=request.getParameter("count");
		String size=request.getParameter("size");
		String color=request.getParameter("color");
		System.out.println(count);
		System.out.println(size);
		System.out.println(color);
		HttpSession session=request.getSession();
		Goods gs=goodsdao.addgoodstocar(productid);
		HashMap<Goods,Integer> shoppingcar=null;
		float total=0;//添加到购物车所有商品的价格综合
		if(session.getAttribute("shoppingcar")==null)
		{
			shoppingcar=new HashMap<>();
			shoppingcar.put(gs,Integer.parseInt(count));
			total=gs.getBasicprice()*Integer.parseInt(count);
		}else
		{
			//将上面添加d商品金额存下来
			total=Float.parseFloat(session.getAttribute("total").toString());
			shoppingcar=(HashMap<Goods, Integer>)session.getAttribute("shoppingcar");
				//这里判断重复需要在Goodsbeans里面重写hashset和equlas方法来判断传进来的参数或对象是否相等
				//shoppingcar.containsKey是获取在hashmap里面的的key的值
			if(shoppingcar.containsKey(gs))
				{
					shoppingcar.put(gs,shoppingcar.get(gs)+Integer.parseInt(count));
					total+=gs.getBasicprice()*Integer.parseInt(count);
				}else
				{
					
					shoppingcar.put(gs,Integer.parseInt(count));
					total+=gs.getBasicprice()*Integer.parseInt(count);
				}
		}
		session.setAttribute("total", total);//将总额存入session当中
		session.setAttribute("shoppingcar",shoppingcar );
		System.out.println(shoppingcar);
		response.sendRedirect("checkout.jsp");
	}

private void listgoodsbyname(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name=request.getParameter("name");
		name=new String(name.getBytes("ISO8859-1"),"UTF-8");
		List<Goods> good=goodsdao.listgoodsbyname(name);
		System.out.println("这是男装，女装");
		System.out.println(good);
		request.setAttribute("gs", good);
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}

     /**
     *这里是查询耽搁商品的详细信息的方法
     * */
	private void listgooddetail(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String productid=request.getParameter("productid");
		productid=new String(productid.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(productid);
		List<Goods> gs=goodsdao.listgooddetail(productid);
		System.out.println("这里是商品的详细信息");
		System.out.println(gs);
		request.setAttribute("gs", gs);
		request.getRequestDispatcher("single.jsp").forward(request, response);
	}

	private void listgoodsbypage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String page=request.getParameter("page");
		String count=request.getParameter("count");
		int nowpage=Integer.parseInt(page);
		int firstpage=1;
		int allcount=goodsdao.getAllProduct();
		int lastpage=(allcount%Integer.parseInt(count)==0)?(allcount/Integer.parseInt(count)):(allcount/Integer.parseInt(count)+1);
		int prepage=(nowpage==1)?1:(nowpage-1);
		int nextpage=(nowpage==lastpage)?lastpage:(nowpage+1);
		//将需要传入d几个参数封装成一个对象
		Page p=new Page(Integer.parseInt(count),nowpage,firstpage,prepage,nextpage,lastpage,allcount);
		request.setAttribute("page", p);
		List<Goods> gs=goodsdao.listAllProduct(Integer.parseInt(page), Integer.parseInt(count));
		request.setAttribute("gs", gs);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void listgoodbybrand(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String brand=request.getParameter("brand");
		brand=new String(brand.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(brand);
		List<Goods> gs=goodsdao.listgoodbybrand(brand);
		request.setAttribute("gs", gs);
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}

	/**根据商品的类型来查询*/
	private void listgoodsbyseris(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用到方法来查数据库查看该类型的商品是否存在，getParameter，参数为页面提交的参数
		String seris=request.getParameter("seris");
		//这个地方需要转码，取到的值是个中文的值，所以在数据库里面查不到
		seris=new String(seris.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(seris);
		//定义一个商品对象,调用该方法来查询该类型的商品
		List<Goods> gs=goodsdao.listAllByProductType(seris);
		//转发数据
		request.setAttribute("gs", gs);
		//处理完了，分发到下一个JSP页面或者下一个Action继续处理
		//会有forward()和redirect()两种情况，forward()是request中的参数继续传递，redirect()则是重新生成request了。
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}
	
}



















