package com.mysql.shopping.model.dao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class CheckCodeAction extends ActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//客户端验证码
    private String checkcode;
    private String time;
    
    public String getCheckcode() {
		return checkcode;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setCheckcode(String checkcode){
        this.checkcode = checkcode;
    }

    /**
     * 验证
     */
    public void check() throws Exception{
        //图片路径
       // String tip = "code.jsp";
        //从服务端获取session中的验证码
        String checkcodeServer = (String) ActionContext.getContext().getSession().get("code").toString();
        System.out.println("----checkcodeServer---"+checkcodeServer);
        System.out.println("----checkcode----"+checkcode);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        //将客户端的验证码与服务端的验证码进行比较
        if(checkcode==null){
        	pw.write("fail");
        }
        if(checkcode.equals(checkcodeServer)){
            //tip = "code.jsp";
        	System.out.println("success");
            pw.write("success"); 
        }else{
        	System.out.println("fail");
        	 pw.write("fail");
		}

        //以IO流的方式将tip变量的值输出到AJAX异步对象中
        pw.flush();
        pw.close();

        
    }

}
