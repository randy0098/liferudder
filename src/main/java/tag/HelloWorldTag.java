package tag;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class HelloWorldTag extends SimpleTagSupport
{
	public void doTag()throws JspException,
		IOException
	{
		getJspContext().getOut().write("Hello World1 "
			+ new java.util.Date());
	}
}
