package action;

import com.opensymphony.xwork2.ActionContext;

import framework.BaseAction;

public class LoginAction extends BaseAction {
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

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

	public String login() {
		if (getUsername().equals("hp") && getPassword().equals("randy")) {
			ActionContext.getContext().getSession().put("user", getUsername());
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
