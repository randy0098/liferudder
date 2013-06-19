package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javassist.bytecode.ByteArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	private InputStream inputStream;
	
	public InputStream getResult(){
		return inputStream;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() throws Exception {
		System.out.println("login----------------------");
		if (getUsername().equals("hp")
				&& getPassword().equals("randy")) {
			ActionContext.getContext().getSession().put("user", getUsername());
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String query() throws Exception {
		System.out.println("query----------------------");
		return "query";
	}
	
	public String ajaxLogin() throws Exception {
		if (getUsername().equals("hp")
				&& getPassword().equals("randy")) {
			inputStream = new ByteArrayInputStream("登陆成功".getBytes("UTF-8"));
		} else {
			inputStream = new ByteArrayInputStream("登陆失败".getBytes("UTF-8"));
		}
		return "ajax_success";
	}
}