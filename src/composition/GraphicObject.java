package composition;

import java.util.ArrayList;
import java.util.List;

public class GraphicObject {
	
	public GraphicObject() {}
	
	protected String name = "Group";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String color;
	public List<GraphicObject> chidrens = new ArrayList<>();
}
