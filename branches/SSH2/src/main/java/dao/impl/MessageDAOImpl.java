/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package dao.impl;

import java.util.List;

import vo.MessageVO;
import dao.MessageDAO;
import framework.BaseDAOImpl;

public class MessageDAOImpl extends BaseDAOImpl implements MessageDAO {

	@Override
	public MessageVO get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(MessageVO.class, id);
	}

	@Override
	public Integer save(MessageVO message) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(message);
	}

	@Override
	public void update(MessageVO message) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(message);
	}

	@Override
	public void delete(MessageVO message) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(message);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<MessageVO> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from MessageVO");
	}
}
