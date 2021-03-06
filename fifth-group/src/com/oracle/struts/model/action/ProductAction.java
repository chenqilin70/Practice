package com.oracle.struts.model.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.mysql.shopping.model.bean.Goods;
import com.mysql.shopping.model.dao.GoodsDAO;
import com.mysql.shopping.model.dao.GoodsDAOimp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import admin.com.oracle.model.bean.Product;
import admin.com.oracle.model.bean.productPage;

@SuppressWarnings("serial")
public class ProductAction extends ActionSupport {
	
	private GoodsDAO  dao;
	public GoodsDAO getDao() {
		return dao;
	}
	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	public ProductAction(){
		dao=new GoodsDAOimp();
	}
	
	/**
	 * 这是商品管理添加商品的方法
	 * */
	public String addproduct()
	{
		System.out.println(p.getImage());
		boolean result=	dao.addProduct(p);
		return result?"addsuccess":"adderror";
	}
	
	/**
	 * 这是商品管理查询商品信息的方法
	 * */
	private productPage pg;
	List<Goods> ps;
	List<Goods> allps;
	public List<Goods> getAllps() {
		return allps;
	}
	public void setAllps(List<Goods> allps) {
		this.allps = allps;
	}

	private int selectid;
	public int getSelectid() {
		return selectid;
	}
	public void setSelectid(int selectid) {
		this.selectid = selectid;
	}
	public productPage getPg() {
		return pg;
	}
	public void setPg(productPage pg) {
		this.pg = pg;
	}
	public List<Goods> getPs() {
		return ps;
	}
	public void setPs(List<Goods> ps) {
		this.ps = ps;
	}

	/**
	 * 查询所有商品的方法
	 * */
	//注意action里面定义的属性一定要提供get和set方法来取，不然jsp取不到值
	Set<String> brands=new HashSet<String>();
	List<String> brand=new ArrayList<String>();
	Set<String> seris=new HashSet<String>();
	List<String> seriss=new ArrayList<String>();
	public List<String> getSeriss() {
		return seriss;
	}
	public void setSeriss(List<String> seriss) {
		this.seriss = seriss;
	}
	public Set<String> getSeris() {
		return seris;
	}
	public void setSeris(Set<String> seris) {
		this.seris = seris;
	}
	public Set<String> getBrands() {
		return brands;
	}
	public void setBrands(Set<String> brands) {
		this.brands = brands;
	}
	public List<String> getBrand() {
		return brand;
	}
	public void setBrand(List<String> brand) {
		this.brand = brand;
	}
	public String selectproduct(){
		int page=pg.getPage();
		int value=pg.getValue();
		int counts=dao.getAllProduct();
		int nowpage=page;
		int firstpage=1;
		int lastpage=(counts/pg.getValue()==0)?(counts/pg.getValue()):(counts/pg.getValue()+1);
		int prexpage=(nowpage==1)?1:(nowpage-1);
		int nextpage=(nowpage==((counts/pg.getValue()==0)?(counts/pg.getValue()):(counts/pg.getValue()+1))?((counts/pg.getValue()==0)?(counts/pg.getValue()):(counts/pg.getValue()+1)):(nowpage+1));
		ps=dao.listAllProduct(nowpage, 12);
		allps=dao.listAllProduct();
		/**遍历出所有的品牌*/
		Set<String> ALLbrand=new HashSet<String>();
		for(Goods p:allps)
		{
			ALLbrand.add(p.getBrand());
		}
		brands.addAll(ALLbrand);
		for(String brand2:brands)
		{
			brand.add(brand2);
		}
		
		/**遍历出所有的系列*/
		Set<String> ALLseris=new HashSet<String>();
		for(Goods p:allps)
		{
			ALLseris.add(p.getSeris());
		}
		seris.addAll(ALLseris);
		
		for(String seris1:seris)
		{
			seriss.add(seris1);
		}
		System.out.println(seriss);
		ServletActionContext.getRequest().setAttribute("seriss", seriss);
		ServletActionContext.getRequest().setAttribute("brand", brand);
		productPage pg=new productPage(page,value,counts,nowpage,lastpage,nextpage,prexpage,firstpage);
		ServletActionContext.getRequest().setAttribute("pg", pg);
		ServletActionContext.getRequest().setAttribute("ps", ps);
		if(ps!=null)
		{
			return "selectsuccess";
		}else
		{
			return "selecterror";
		}
	}
	
	/**
	 * 按照品牌和系列来查询商品信息
	 * */
	private String chosebrand;
	private String choseseris;
	public String getChoseseris() {
		return choseseris;
	}
	public void setChoseseris(String choseseris) {
		this.choseseris = choseseris;
	}
	public String getChosebrand() {
		return chosebrand;
	}
	public void setChosebrand(String chosebrand) {
		this.chosebrand = chosebrand;
	}
	public String selectbybrand() throws Exception{
		chosebrand=new String(chosebrand.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(chosebrand);
		ps=dao.getallbrand(chosebrand);
		ServletActionContext.getRequest().setAttribute("ps", ps);
		System.out.println(ps);
		if(ps!=null)
		{
			return "selectsuccess";
		}else
		{
			return "selecterror";
		}
	}
	public String selectbyseris() throws Exception{
		choseseris=new String(choseseris.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(choseseris);
		ps=dao.getallseris(choseseris);
		ServletActionContext.getRequest().setAttribute("ps", ps);
		if(ps!=null)
		{
			return "selectseris";
		}else
		{
			return "selecterror";
		}
	}
	/**
	 * 按照价格来查询商品的方法
	 * */
	public String selectbyprice(){
		int id=selectid;
		System.out.println(id);
		if(id==1)
		{
			ps=dao.listByprice(0,120);
		}else if(id==2)
		{
			ps=dao.listByprice(120,200);
		}else if(id==3)
		{
			ps=dao.listByprice(200,300);
		}else if(id==4)
		{
			ps=dao.listByprice(300,1000);
		}
		ServletActionContext.getRequest().setAttribute("ps", ps);
		System.out.println(ps);
		return "success";
	}
	
	/**
	 * 这是商品管理获取单一商品信息的方法
	 * */
	private String productid;
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getproduct(){
		System.out.println("id为："+productid);
		Goods update=dao.updateProduct(productid);
		ServletActionContext.getRequest().setAttribute("update", update);
		System.out.println(update);
		if(update!=null)
		{
			return "getsuccess";
		}else
		{
			return "geterror";
		}
	}
	public String checkproduct(){
		System.out.println("id为："+productid);
		Goods update=dao.updateProduct(productid);
		ServletActionContext.getRequest().setAttribute("update", update);
		System.out.println(update);
		if(update!=null)
		{
			return "checksuccess";
		}else
		{
			return "checkerror";
		}
	}
	
	/**
	 * 这是商品管理更改商品信息的方法
	 * */
	private Product p;
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public String updateproduct(){
		System.out.println(p);
		boolean updateresult=dao.updateproduct(p);
		System.out.println(updateresult);
		return updateresult?"updatesuccess":"updateerror";
	}
	
	/**
	 * 这是商品管理删除商品信息的方法
	 * */
	public String deleteproduct(){
		System.out.println("马上删除"+productid);
		//多选传过来是字符串，下面是解析字符串的方法
		String[] ids=productid.split(",");
		for(int i=0;i<ids.length;i++)
		{
			@SuppressWarnings("unused")
			boolean deleteproduct=dao.deleteproduct(ids[i]);
		}
		return "deletesuccess";
	}
	
	/**
	 * 这是导出数据的方法
	 * */
	public String outputdata(){
		
	    return "excel";
	}
	
	/**
	 * 国际化的方法
	 * */
	private String request;
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String execute()
	{
		//定义一个加载资源文件的对象
		Locale locale=Locale.getDefault();
		if(request.equals(null)||request.equals(""))
		{
			//这里两个值要注意，根据定义的配置文件来的，前后要对应
			locale=new Locale("en","US");
		}else if(request.equals("zh"))
		{
			locale=new Locale("zh","CN");
		}else if(request.equals("en"))
		{
			locale=new Locale("en","US");
		}
		ActionContext.getContext().setLocale(locale);  
	    ServletActionContext.getRequest().getSession().setAttribute("WW_TRANS_I18N_LOCALE", locale); 
	    System.out.println(locale);
	    return "request";
	}
}
