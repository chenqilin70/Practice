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
		
		//������Ӧ����������,�����û��棬ֱ��ˢ��
		response.setContentType("image/jpg");
		response.setHeader("pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		//���ڴ�������ͼ��
		BufferedImage image=new BufferedImage(200, 30, Image.SCALE_DEFAULT);
		
		//���ɻ��ʣ���ȡͼ��������
		Graphics g=image.getGraphics();
		
		//���ø�����ı�����ɫ
		g.setColor(Color.white);
		g.fillRect(0, 0, 200, 30);
		
		//����һ���������
		StringBuffer code=new StringBuffer();
		
		
		//���ø�����
		for(int m=0;m<50;m++){
		g.drawLine(new Random().nextInt(200), new Random().nextInt(35), 10, 10);
		}
		
		int x=10;
		//�������6λ������֤��
		for(int n=0;n<30;n++)
		{
			g.drawRect(new Random().nextInt(200),new Random().nextInt(30),2, 2);
			g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
		}
		for(int n=0;n<6;n++)
		{
			int size=new Random().nextInt(20)+20;//ȷ��������СΪ20
			//�����������������name,style,size
			g.setFont(new Font("����",Font.ITALIC,size));
			//�����������ɫֵ
			g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
			
			//�������1-10֮��������
			int randomNum=new Random().nextInt(10);
			
			code.append(randomNum);
			//�����ɵ���֤��浽session�У�
			request.getSession().setAttribute("code", code);
			g.drawString(randomNum+"", x, 30);
			x+=size;
			
		}
		
		//��ͼ��io������ͼ��д��ȥ,����Ϊ�ö������ͣ���Ӧ����������
		ImageIO.write(image, "jpg", response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
	}
}







