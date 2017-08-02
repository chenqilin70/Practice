package admin.com.oracle.model.bean;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Text {

	public static void main(String[] args) {
		Configuration  cfg=new Configuration().configure();//创建hibernate读取配置文件的对象，并读取配置
		SessionFactory  sf=cfg.buildSessionFactory();//使用配置对象构造一个sesion工厂
		Session  session=sf.openSession();//在工厂里面拿到一个新的数据库操作对象
		Transaction  tr=session.beginTransaction();
		
		Notice n=new Notice("lalala", "allala", "lalla", new Date().toLocaleString(), 0, "zhang",0);
		
		session.save(n);
		
		tr.commit();
		
	}

}
