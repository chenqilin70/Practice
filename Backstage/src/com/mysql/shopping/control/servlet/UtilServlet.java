package com.mysql.shopping.control.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/UtilServlet")
public class UtilServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName=request.getParameter("method");
		switch(methodName)
		{
			case("processChat"):
			{
				System.out.println("已经传到后台了");
				processChat(request,response);
				break;
			}
		}
	}

	//这是客服聊天技术
	private void processChat(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		String username=request.getParameter("username");
		@SuppressWarnings("deprecation")
		String date=new Date().toLocaleString();
		String words=request.getParameter("words");
		String fullMessage="\""+username+"\": "+date+"\r\n"+words;
		System.out.println(fullMessage);
		request.getServletContext().setAttribute("message",fullMessage);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.write(fullMessage);
		out.flush();
	}

	
}
