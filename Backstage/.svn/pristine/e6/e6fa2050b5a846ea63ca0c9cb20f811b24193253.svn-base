package com.mysql.shopping.control.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/CodeServlet")
public class CodeServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置相应的内容类型,不设置缓存，直接刷新
		response.setContentType("image/jpg");
		response.setHeader("pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		//在内存中生成图像
		BufferedImage image=new BufferedImage(200, 30, Image.SCALE_DEFAULT);
		
		//生成画笔，获取图形上下文
		Graphics g=image.getGraphics();
		
		//设置该区域的背景颜色
		g.setColor(Color.white);
		g.fillRect(0, 0, 200, 30);
		
		//设置一个缓存对象
		StringBuffer code=new StringBuffer();
		
		
		//设置干扰线
		for(int m=0;m<50;m++){
		g.drawLine(new Random().nextInt(200), new Random().nextInt(35), 10, 10);
		}
		
		int x=10;
		//随机产生6位数的验证码
		for(int n=0;n<30;n++)
		{
			g.drawRect(new Random().nextInt(200),new Random().nextInt(30),2, 2);
			g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
		}
		for(int n=0;n<6;n++)
		{
			int size=new Random().nextInt(20)+20;//确保字体最小为20
			//设置字体的三个属性name,style,size
			g.setFont(new Font("隶书",Font.ITALIC,size));
			//设置随机的颜色值
			g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
			
			//随机生成1-10之间的随机数
			int randomNum=new Random().nextInt(10);
			
			code.append(randomNum);
			//将生成的验证码存到session中，
			request.getSession().setAttribute("code", code);
			g.drawString(randomNum+"", x, 30);
			x+=size;
			
		}
		
		//用图像io流将该图像写出去,参数为该对象，类型，相应对象的输出流
		ImageIO.write(image, "jpg", response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
	}
}







