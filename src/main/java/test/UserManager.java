package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.User;

public class UserManager
{

	/**
	 * Description goes here.
	 *
	 * @param args
	 * 
	 * @since 
	 */
	public static void main(String[] args)
	{
		//实例化configuration，这行代码默认加载hibernate.cfg.xml文件
		Configuration conf = new Configuration().configure();
		//以configuration创建sessionfactory
		SessionFactory sf = conf.buildSessionFactory();
		//实例化session
		Session sess = sf.openSession();
		//开始事务
		Transaction tx = sess.beginTransaction();
		
		User user = new User();
		user.setName("test3");
		user.setPass("123456");
		//保存
		sess.save(user);
		//提交事务
		tx.commit();
		//关闭session
		sess.close();
		

	}

}
