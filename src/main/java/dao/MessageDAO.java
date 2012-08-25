/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import vo.MessageVO;
import framework.BaseDAO;


public class MessageDAO extends BaseDAO
{
	/**
	 * 
	 * 查询短信记录列表
	 *
	 * @return
	 */
	public List<MessageVO> getMessageList(){
		HibernateTemplate template = getHibernateTemplate();
		List<MessageVO> messages = template.find("from MessageVO");
		return messages;
	}
	
	/**
	 * 
	 * 短信记录保存
	 *
	 * @param form
	 * @return
	 */
	public void insertMessage(MessageVO message){
		HibernateTemplate template = getHibernateTemplate();
		template.save(message);
	}
	
	/**
	 * 
	 * 查询单条短信记录
	 *
	 * @return
	 */
	public MessageVO getMessageInfo(int id){
		HibernateTemplate template = getHibernateTemplate();
		MessageVO messageVO = (MessageVO)template.get(MessageVO.class, new Integer(id));
		return messageVO;
	}
	
	
	/**
	 * 
	 * 保存单条短信记录
	 *
	 * @return
	 */
	public void updateMessage(MessageVO message){
		HibernateTemplate template = getHibernateTemplate();
		template.update(message);
	}
	
	/**
	 * 
	 * 删除单条短信记录
	 *
	 * @return
	 */
	public void deleteMessage(String id){
		HibernateTemplate template = getHibernateTemplate();
		template.delete(template.get(MessageVO.class, new Integer(id)));
	}
	
	public static void main(String[] args)
	{
//		DAOController controller = new DAOController();
//		String sql = "SELECT * FROM DEVFW_MESSAGE";
//		ResultSet rs = controller.select(sql);
//		try
//        {
//	        while (rs.next())
//	        {
//	        	String ID = rs.getString("ID");
//	        	String SENDER = rs.getString("SENDER");
//	        	String RECEIVER = rs.getString("RECEIVER");
//	        	String CONTENT = rs.getString("CONTENT");
//	        	String MSG_TIME = rs.getString("MSG_TIME");
//	        	System.out.println("ID:" + ID);
//	        	System.out.println("SENDER:" + SENDER);
//	        	System.out.println("RECEIVER:" + RECEIVER);
//	        	System.out.println("CONTENT:" + CONTENT);
//	        	System.out.println("MSG_TIME:" + MSG_TIME);
//	        	System.out.println("0:"+rs.getString(1));
//	        	System.out.println("######################");
//	        }
//	        controller.close();
//        }
//        catch (SQLException e)
//        {
//	        // TODO Auto-generated catch block
//	        e.printStackTrace();
//        }
		
//		Configuration configuration;
//		SessionFactory sessionFactory;
//		Session session;
//		
//		configuration=new Configuration().configure();
//		sessionFactory = configuration.buildSessionFactory();
//		session = sessionFactory.openSession() ;
//		Transaction tx = session.beginTransaction();
//		MessageVO message = new MessageVO();
//		message.setSender("randy.xia");
//		message.setReceiver("smile.lee");
//		message.setContent("hibernateTest");
//		session.save(message);
//		tx.commit();
//		session.close();
		
		
//		Session session = HibernateUtil.currentSession();
//		Transaction tx = session.beginTransaction();
//		List<MessageVO> messages = session.createQuery("from MessageVO").list();
//		tx.commit();
//		HibernateUtil.closeSession();
		
//		System.out.println(new MessageDAO().getMessageList().get(0).getSender());
	}
}
