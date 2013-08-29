package framework;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MessageVO;


public class HSQLDBPage extends Page
{
	
	/**
	 * 
	 * 创建查询语句
	 *
	 */
	public void createSelectSql(){
		String resultSql = this.querySql + " LIMIT " + --this.startRecordIndex + "," + this.pageRecordNum;
		System.out.println("createdQuerySql:" + resultSql);
		this.createdQuerySql = resultSql;
	}


	public static void main(String[] args) throws SQLException, IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException
	{
		// TODO Auto-generated method stub
		MySQLPage page = new MySQLPage();
		page.setQuerySql("SELECT * FROM devfw_message WHERE 1=1");
		page.setCountSql("SELECT COUNT(ID) AS n FROM devfw_message");
		page.setPageRecordNum(1);
		page.setCurrentPageIndex(1);
		page.setWrapper(new Wrapper<MessageVO>() {
			@Override
			public MessageVO wrapRecord(ResultSet rs) throws SQLException {
				MessageVO messageVO = new MessageVO();
				messageVO.setId(rs.getInt("ID"));
				messageVO.setSender(rs.getString("SENDER"));
				messageVO.setReceiver(rs.getString("RECEIVER"));
				messageVO.setContent(rs.getString("CONTENT"));
				messageVO.setMsg_time(rs.getString("MSG_TIME"));
				return messageVO;
			}
		});
		page.createPage();
		System.out.println(page.getRecords().size());
		System.out.println(page.getRecordNum());
	}
	
	
}
