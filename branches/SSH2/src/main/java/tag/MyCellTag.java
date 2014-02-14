package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyCellTag extends SimpleTagSupport{
	private String caption;
	private String property;
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public void doTag() throws JspException, IOException {
		System.out.println("MyCellTag:start");
		System.out.println("caption:"+caption);
		System.out.println("property:"+property);
		MyGridTag grid = (MyGridTag)this.getParent();
		grid.getChildren().add(this);
		System.out.println("MyCellTag:end");
	}
}
