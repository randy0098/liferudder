package framework;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AuthorityInterceptor extends MethodFilterInterceptor{
	/**
	 * serialVersionUID
	 * long
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation)
			throws Exception {
		ActionContext context = invocation.getInvocationContext();
		Map session	= context.getSession();
		String user = (String) session.get("user");
		System.out.println("user:"+user);
		if(user!=null && user.equalsIgnoreCase("hp")){
			return invocation.invoke();
		}
		context.put("tip", "您还没登陆");
		return Action.LOGIN;
	}

}
