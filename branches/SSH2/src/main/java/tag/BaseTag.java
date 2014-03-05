package tag;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BaseTag extends SimpleTagSupport implements DynamicAttributes {
	// 保存每个属性名的集合
	protected ArrayList<String> keys = new ArrayList<String>();
	// 保存每个属性值的集合
	protected ArrayList<Object> values = new ArrayList<Object>();

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException {
		// 添加属性名
		keys.add(localName);
		// 添加属性值
		values.add(value);
	}
}
