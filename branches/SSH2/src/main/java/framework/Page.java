/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Page {
	// 记录总数
	protected int recordNum;

	// 每页显示记录数量
	protected int pageRecordNum;

	// 页面数量
	protected int totalPage;

	// 当前页面序号
	protected int currentPageIndex;

	// 当前页面的记录集合
	protected ArrayList records = new ArrayList();

	// 本页开始记录序号
	protected int startRecordIndex;

	// 本页截止记录序号
	protected int endRecordIndex;

	// 原始查询语句
	protected String querySql;

	// 生成的实际查询语句
	protected String createdQuerySql;

	// 查询记录数量的sql语句
	protected String countSql;

	// 用来封装记录的对象
	protected Wrapper wrapper;

	public Wrapper getWrapper() {
		return wrapper;
	}

	public void setWrapper(Wrapper wrapper) {
		this.wrapper = wrapper;
	}

	public int getRecordNum() {
		return recordNum;
	}

	public int getPageRecordNum() {
		return pageRecordNum;
	}

	public void setPageRecordNum(int pageRecordNum) {
		this.pageRecordNum = pageRecordNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	public ArrayList getRecords() {
		return records;
	}

	public int getStartRecordIndex() {
		return startRecordIndex;
	}

	public int getEndRecordIndex() {
		return endRecordIndex;
	}

	public String getQuerySql() {
		return querySql;
	}

	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}

	public String getCreatedQuerySql() {
		return createdQuerySql;
	}

	public String getCountSql() {
		return countSql;
	}

	public void setCountSql(String countSql) {
		this.countSql = countSql;
	}

	/**
	 * 
	 * 创建页面
	 * 
	 * @throws SQLException
	 * @throws CloneNotSupportedException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws ClassNotFoundException
	 * 
	 */
	public void createPage() throws SQLException{
		// 设置记录开始和截止序号
		// 记录序号从1开始
		// 当前页序号从1开始
		if (this.currentPageIndex > 0 && this.pageRecordNum > 0) {
			this.startRecordIndex = (this.currentPageIndex - 1) * this.pageRecordNum + 1;
			this.endRecordIndex = this.currentPageIndex * this.pageRecordNum;
			// 生成查询语句
			this.createSelectSql();
			// 查询并保存查询记录结果集
			this.records = this.selectRecords();
			// 获得记录总数和总页数
			this.calculateTotalPage();
		}
	}

	/**
	 * 
	 * 计算得到总页数
	 * 
	 * @return
	 * @throws SQLException
	 */
	public void calculateTotalPage() throws SQLException {
		// 获得记录总数
		this.selectRecordsNum();
		// 获得总页数
		if (this.pageRecordNum != 0) {
			if (this.recordNum % this.pageRecordNum == 0) {
				this.totalPage = this.recordNum / this.pageRecordNum;
			} else {
				this.totalPage = this.recordNum / this.pageRecordNum + 1;
			}
		}
	}

	/**
	 * 
	 * 查询记录总数
	 * 
	 * @throws SQLException
	 * 
	 */
	public void selectRecordsNum() throws SQLException {
		DAOController controller = new DAOController();
		ResultSet rs = controller.selectOne(this.countSql);
		rs.next();
		// 获得记录数量，注意字段序号是从1开始。
		int recordNum = rs.getInt(1);
		controller.close();
		this.recordNum = recordNum;
	}

	/**
	 * 
	 * 查询数据库获得记录列表信息
	 * 
	 * @return
	 * @throws SQLException
	 * @throws CloneNotSupportedException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	private ArrayList selectRecords() throws SQLException {
		DAOController controller = new DAOController();
		ResultSet rs = controller.select(this.createdQuerySql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			list.add(wrapper.wrapRecord(rs));
		}
		controller.close();
		return (ArrayList)list.clone();
	}

	/**
	 * 
	 * 创建查询语句
	 * 
	 */
	public abstract void createSelectSql();

	/**
	 * 
	 * 转到首页
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws CloneNotSupportedException
	 * @throws SQLException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * 
	 */
	public void goToFirst() throws SQLException {
		this.setCurrentPageIndex(1);
		this.createPage();
	}

	/**
	 * 
	 * 转到尾页
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws CloneNotSupportedException
	 * @throws SQLException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * 
	 */
	public void goToLast() throws SQLException {
		// 获得记录总数和总页数
		this.calculateTotalPage();
		this.currentPageIndex = this.totalPage;
		this.createPage();
	}

	/**
	 * 
	 * 下一页
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws CloneNotSupportedException
	 * @throws SQLException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * 
	 */
	public void next() throws SQLException{
		// 获得记录总数和总页数
		this.calculateTotalPage();
		if (this.currentPageIndex < this.totalPage) {
			this.currentPageIndex = this.currentPageIndex + 1;
		} else {
			this.currentPageIndex = this.totalPage;
		}
		this.createPage();
	}

	/**
	 * 
	 * 上一页
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws CloneNotSupportedException
	 * @throws SQLException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * 
	 */
	public void back() throws SQLException{
		if (this.currentPageIndex > 1) {
			this.currentPageIndex = this.currentPageIndex - 1;
		} else {
			this.currentPageIndex = 1;
		}
		this.createPage();
	}

	/**
	 * 
	 * 转到第几页
	 * 
	 * @param pageIndex
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws SQLException
	 * @throws CloneNotSupportedException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 */
	public void go(int pageIndex) throws SQLException {
		// 获得记录总数和总页数
		this.calculateTotalPage();
		if (pageIndex < 1) {
			pageIndex = 1;
		} else if (pageIndex > this.totalPage) {
			pageIndex = this.totalPage;
		}
		this.setCurrentPageIndex(pageIndex);
		this.createPage();
	}

//	public void paging(HttpServletRequest request) throws SQLException {
//		String action1 = request.getParameter("action");
//		String currentPageIndex1 = request.getParameter("currentPageIndex");
//		// 默认显示第一页数据记录
//		String action = "go";
//		String currentPageIndex = "1";
//		if (action1 != null && action1.equalsIgnoreCase("") == false) {
//			action = action1;
//		}
//		if (currentPageIndex1 != null && currentPageIndex1.equalsIgnoreCase("") == false) {
//			currentPageIndex = currentPageIndex1;
//		}
//		paging(action, currentPageIndex);
//	}

	public void pagingDefault(String action, String currentPageIndex) throws SQLException {
		// 默认显示第一页数据记录
		String action1 = "go";
		String currentPageIndex1 = "1";
		if (action != null && action.equalsIgnoreCase("") == false) {
			action1 = action;
		}
		if (currentPageIndex != null
				&& currentPageIndex.equalsIgnoreCase("") == false) {
			currentPageIndex1 = currentPageIndex;
		}
		paging(action1, currentPageIndex1);
	}
	
	public void paging(String action, String currentPageIndex) throws SQLException {
		if (action != null && action.equalsIgnoreCase("goToFirst") == true) {
			this.goToFirst();
		} else if (action != null && action.equalsIgnoreCase("goToLast") == true) {
			this.goToLast();
		} else if (action != null && action.equalsIgnoreCase("back") == true) {
			this.setCurrentPageIndex(Integer.parseInt(currentPageIndex));
			this.back();
		} else if (action != null && action.equalsIgnoreCase("next") == true) {
			this.setCurrentPageIndex(Integer.parseInt(currentPageIndex));
			this.next();
		} else if (action != null && action.equalsIgnoreCase("go") == true) {
			this.go(Integer.parseInt(currentPageIndex));
		}
	}

}
