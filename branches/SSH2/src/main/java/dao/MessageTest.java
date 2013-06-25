package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.MessageVO;

public class MessageTest {
	public void create(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		MessageVO message = new MessageVO();
		message.setSender("xf3");
		message.setReceiver("randy3");
		message.setContent("hi3");
		session.save(message);
		tx.commit();
		session.close();
		sf.close();
	}
	
	public void update(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		MessageVO message = new MessageVO();
		message.setId(1);
		//这样做把其它字段置成空了有问题！
		message.setContent("hi2");
		session.update(message);
		tx.commit();
		session.close();
		sf.close();
	}
	
	public void query(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		MessageVO message = (MessageVO) session.get(MessageVO.class, 1);
		System.out.println(message.getContent());
		tx.commit();
		session.close();
		sf.close();
	}
	
	public void delete(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		MessageVO message = new MessageVO();
		message.setId(1);
		session.delete(message);
		tx.commit();
		session.close();
		sf.close();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		new MessageTest().update();
//		new MessageTest().query();
//		new MessageTest().delete();
		new MessageTest().create();
	}

}
