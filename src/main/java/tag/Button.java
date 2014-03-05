package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;

public class Button extends BaseTag {
	private String caption;
	private String name;
	private String onclick;
	
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	@Override
	public void doTag() throws JspException, IOException
	{
		Grid grid = (Grid)this.getParent();
		grid.getButtons().add(this);
	}


}
