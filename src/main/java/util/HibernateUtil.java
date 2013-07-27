/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of Hewlett-Packard Co.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2012 All rights reserved. =============================
 */

package util;

import java.io.Serializable;

//只做一次static, final不能被继承
public final class HibernateUtil {
	/*private static SessionFactory sessionFactory;
	private static ThreadLocal session = new ThreadLocal();//相当于MAP

	// 禁止new，私有的构造方法
	private HibernateUtil() {

	}

	//只做一次,或者单利模式，加载时才执行，之后再也不运行了
	static {
		Configuration cfg = new Configuration();
		cfg.configure();//从classpath中读取配置文件
		sessionFactory = cfg.buildSessionFactory();
	}

	public static Session getThreadLocalSesssion(){
		Session s = (Session)session.get();
		if(s == null){
			s = getSession();
			session.set(s);// 放入session
		}
		return s; 
	}
	public static void closeSession(){
		Session s = (Session)session.get();
		if(s == null){
			s.close();
			session.set(null);// 清空
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	static void add(Object entity){
		Session s = null;
		Transaction tx = null;
		try{
		s = HibernateUtil.getSession();
		tx = s.beginTransaction();
		s.save(entity);
		tx.commit();
		}
		finally{
			if(s != null){
				s.close();
			}
		}
	}
	
	static void update(Object entity){
		Session s = null;
		Transaction tx = null;
		try{
		s = HibernateUtil.getSession();
		tx = s.beginTransaction();
		s.update(entity);
		tx.commit();
		}
		finally{
			if(s != null){
				s.close();
			}
		}
	}
	
	static void delete(Object entity){
		Session s = null;
		Transaction tx = null;
		try{
		s = HibernateUtil.getSession();
		tx = s.beginTransaction();
		s.delete(entity);
		tx.commit();
		}
		finally{
			if(s != null){
				s.close();
			}
		}
	}
	
	public static Object get(Class clazz, Serializable id){
		Session s = null;
		try{
			s = HibernateUtil.getSession();
			Object obj = s.get(clazz,id );
			return obj;
		}
		finally{
			if(s != null){
				s.close();
			}
		}
	}*/
	
	
}
