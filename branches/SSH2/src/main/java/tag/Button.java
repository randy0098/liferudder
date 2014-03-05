package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class Button extends BaseTag {
	private String caption;

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Override
	public void doTag() throws JspException, IOException
	{
		JspWriter out = getJspContext().getOut();
		//此处只是简单地输出每个属性
		out.println("<ol>");
		for( int i = 0; i < keys.size(); i++ )
		{
			String key = keys.get( i );
			Object value = values.get( i );
			out.println( "<li>" + key + " = " + value + "</li>" );
		}
		out.println("</ol>");
	}


}
