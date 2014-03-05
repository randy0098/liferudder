package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;

public class Cell extends BaseTag {
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
		Grid grid = (Grid)this.getParent();
		grid.getCells().add(this);
	}
}
