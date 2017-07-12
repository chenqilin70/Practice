package com.mysql.shopping.control.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.shopping.model.bean.User;
import com.mysql.shopping.model.dao.UserDAO;
import com.mysql.shopping.model.dao.UserDAOimp;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/UserServlet")
//因为在登录，注册，添加和删除都需要用到，所以可以在一个servlvet里面，体现代码的复用性
//用来处理从jsp传过来的页面请求，这里是处理所有与用户有关的方法
public class UserServlet extends HttpServlet {
	
	//如果是本类中对各方法用到的对象，将其声明为 全局变量
	private UserDAO userdao;
	
	@Override
	public void init() throws ServletException {
		userdao=new UserDAOimp();
	}
	
	/**
	 * servlet命名应该跟对象有关，例如处理user的servlet，应该叫做userServlet
	 * 而且为了体现一个servlet组件的复用性，应该是把所有跟这个对象有关的后台方法都定义在
	 * 相关的这个servlet里面，前端通过url传参的方式让后台识别到底调用能个方法。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//getParameter 是用来通过容器的实现接受用post个get方法传递过来的参数的
		//HttpServletRequest 类有 setAttribute() 方法，而没有setParameter() 方法
		String  methodName=request.getParameter("method");
		
		switch(methodName)	
		{
			case"login":{
				login(request,response);
				break;
			}
			case"register":{
				register(request, response);
				break;
			}
			case"information":{
				information(request,response);
				break;
			}
			case"loginoff":{
				loginoff(request,response);
				break;
			}
			case"getdetailinfo":{
				getdetailinfo(request,response);
				break;
			}
			case"updateinfo":{
				try {
					updateinfo(request,response);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
	//修改个人信息
	@SuppressWarnings("unchecked")
	private void updateinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
		request.setCharacterEncoding("utf-8");
		String userid=null,username=null,password=null,realname=null,sex=null,age=null,image=null;
		//判断提交过来的数据是不是按照文件的上传格式
		if(ServletFileUpload.isMultipartContent(request))
		{
			FileItemFactory f1=new DiskFileItemFactory();
			//文件上传处理，保存在磁盘当中
			ServletFileUpload upload=new ServletFileUpload(f1);
			//设置上传文件的大小
			upload.setSizeMax(1024*1024*6);
			List<FileItem> files=upload.parseRequest(request);
			for(FileItem file:files)
			{
				if(file.getFieldName().equals("userid"))
				{
					userid=file.getString();
				}
				//这里是解析字符的方式
				else if(file.getFieldName().equals("username"))
				{
					username=file.getString();
					username=new String(username.getBytes("ISO8859-1"),"UTF-8");
				}else if(file.getFieldName().equals("password"))
				{
					password=file.getString();
				}else if(file.getFieldName().equals("realname"))
				{
					realname=file.getString();
					realname=new String(username.getBytes("ISO8859-1"),"UTF-8");
				}else if(file.getFieldName().equals("sex"))
				{
					sex=file.getString();
				}else if(file.getFieldName().equals("age"))
				{
					age=file.getString();
				}else if(file.getFieldName().equals("image"))
				{
					//处理文件上传的方式，用io流江文件读取到指定的位置
					InputStream in=file.getInputStream();
					@SuppressWarnings("deprecation")
					String path=request.getRealPath("image/upload/");
					//随机生成一个图像名字，避免重复
					String uuidName=UUID.randomUUID().toString();
					StringBuffer  childPath=new StringBuffer("/");
					for(int n=0;n<5;n++)
					{
						childPath.append(uuidName.charAt(n)+"/");
					}
					String  fileName=uuidName+".jpg";
					File newPath=new File(path+childPath);
					if(!newPath.exists())newPath.mkdirs();
					File  f2=new File(newPath,fileName);
					OutputStream out=new FileOutputStream(f2);
					byte[] bytes=new byte[1024*1024];
					int len=-1;
					while((len=in.read(bytes))!=-1)
					{
						out.write(bytes,0,len);
					}
					out.flush();
					out.close();
					in.close();
					image="image/upload"+childPath+fileName;
				}
			}
		}
		System.out.println("文件读取完毕");
		System.out.println(userid);
		System.out.println(username);
		System.out.println(image);
		System.out.println(realname);
		System.out.println(sex);
		System.out.println(age);
		System.out.println(password);
		User user=new User(Integer.parseInt(userid),username,password,realname,sex,Integer.parseInt(age),image,true);
		System.out.println(user);
		boolean reback=userdao.update(user);
		User newuser=userdao.serchinformation(userid);
		request.getSession().setAttribute("Loginuser", newuser);
		if(reback)
		{
			request.setAttribute("rebackupdate", "<b style='color:green'>修改成功</b>");
		}
		else
		{
			request.setAttribute("rebackupdate", "<b style='color:red'>修改失败</b>");
		}
		request.setAttribute("user", newuser);
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}

	//获取用户详细信息，包括users和address两张表的信息
	private void getdetailinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID=request.getParameter("userID");
		User user=userdao.getdetailinfo(userID);
		request.setAttribute("user", user);
		if(request.getParameter("editOrder")==null)
		{
			
		}else
		{
			request.getRequestDispatcher("ordercart.jsp").forward(request, response);
		}
	}

	//处理用户退出的方法
	private void loginoff(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		request.getSession().removeAttribute("Loginuser");
		response.sendRedirect("index.jsp");
	}
	
	//处理查询用户详细信息的方法
	private void information(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		String userID=request.getParameter("userID");
		User myself=userdao.serchinformation(userID);
		System.out.println(myself);
		request.getSession().setAttribute("Loginuser", myself);
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}
	//处理用户注册的方法
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//这里是获取注册表单传过来的数据
		request.setCharacterEncoding("UTF-8");//设置所有传过来的参数都以utf-8的格式传过来
		//request.getParameter接受在注册jsp里面传过来的username参数
		String username=request.getParameter("username").toString();
		//字符集转换成string类型
		username=new String(username.getBytes("ISO8859-1"),"UTF-8");
		String password=request.getParameter("password");
		String realname=request.getParameter("realname").toString();
		realname=new String(realname.getBytes("ISO8859-1"),"UTF-8");
		String sex=request.getParameter("sex");
		sex=new String(sex.getBytes("ISO8859-1"),"UTF-8");
		String age=request.getParameter("age");
		@SuppressWarnings("unused")
		String status=request.getParameter("status");//这里默认的状态为true
		System.out.println(username);
		
		//因为dao方法里面要求的是一个user对象，但是重表单上取得是单独的属性
		//所以我们先封装一个user对象，在使用
		User  willRegisterUser=new User(0, username, password,realname, sex, Integer.parseInt(age),"image/User/title.jpg",true);
		
		//调用dao执行注册功能，将数据添加到数据库，并返回一个boolean类型的值
		boolean  registerResult=userdao.add(willRegisterUser);
		//根据注册dao方法返回的结果，跳转页面
			if(registerResult)
			{
				request.getRequestDispatcher("account.jsp").forward(request, response);;
				request.setAttribute("Message", "注册成功！欢迎使用");
			}else
			{
				request.getRequestDispatcher("register.jsp");
			}
	}
	//处理用户登录的方法
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//为了能够让页面显示为中文不是乱码
		String code=request.getParameter("code");//获取登陆传过来的参数
		String systemCode=request.getSession().getAttribute("code").toString();//这个是获取的页面的验证码
		if(code.equals(systemCode))//比较这两个值是否相同
		{ 
			//获取在上个表单里面的用户名和密码的值
			String u=request.getParameter("username").toString();
			u=new String(u.getBytes("ISO8859-1"),"UTF-8");
			//这里也需要对用户名进行转码，否则中文注册不能登陆
			String p=request.getParameter("password");
			//调用到方法来查数据库查看该用户是否存在
			UserDAO  dao=new UserDAOimp();//定义一个userdao对象，来调用这里面的方法
			User user=dao.login(u, p);//定义一个user对象
			System.out.println("用户编号："+user.getUserID());
			if(user!=null)
			{
				//如何获得的值是null，则说明没有选中
				if(request.getParameterValues("remmima")!=null)
				{
					//判断记住密码之后，将用户名和密码存在 cookied里面
					//cookie是通过键值对来存储的
					Cookie username=new Cookie("username", u);
					username.setMaxAge(60*60*24);
					//设置cookie的域，防止与其他的域发动冲突
					Cookie password=new Cookie("password", p);
					//设置cookie保存的时间
					password.setMaxAge(60*60);
					//将这两个对象发送给客户端
					response.addCookie(username);
					response.addCookie(password);
				}else
				{
					System.out.println("不保存密码了");
					Cookie password=new Cookie("password","");
					password.setMaxAge(0);
					response.addCookie(password);
				}
				request.getSession().setAttribute("Loginuser",user);
				response.sendRedirect("index.jsp");
			}
			else
			{
				request.setAttribute("errorMessage", "用户名或密码错误");
				request.getRequestDispatcher("account.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errorMessage", "验证码错误!请重新输入");
			request.getRequestDispatcher("account.jsp").forward(request, response);
		}
	}
}
		
