package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAjaxAction extends ActionSupport {
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
	
	public String ajaxLoginTest() throws Exception {
		if (getUsername().equals("hp")
				&& getPassword().equals("randy")) {
			inputStream = new ByteArrayInputStream("登陆成功".getBytes("UTF-8"));
		} else {
			inputStream = new ByteArrayInputStream("登陆失败".getBytes("UTF-8"));
		}
		return SUCCESS;
	}
}