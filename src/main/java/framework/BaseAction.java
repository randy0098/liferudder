package framework;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	/**
	 * serialVersionUID
	 * long
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * get Spring bean instance with beanName
	 * 
	 * @param beanName beanName in Spring container
	 * @return return bean instance in Spring container
	 */
//	public Object getBean(String beanName) {
//		return getWebApplicationContext().getBean(beanName);
//	}
}
