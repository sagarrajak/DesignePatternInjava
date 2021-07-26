package builder;

import java.util.ArrayList;
import java.util.Collections;

class HtmlElement {
	public String name, text;
	public ArrayList<HtmlElement> elements = new ArrayList<>();
	public final int indent = 2;
	private final String newLine = System.lineSeparator();

	public HtmlElement() {
	}

	public HtmlElement(String name) {
		this.name = name;
	}

	public HtmlElement(String name, String text) {
		this.name = name;
		this.text = text;
	}

	private String toStringImpl(int indentSize) {
		StringBuilder sb = new StringBuilder();
		String i = String.join("", Collections.nCopies(indent * indentSize, " "));
		sb.append(String.format("%s<%s>%s", i, name, newLine));
		if (text != null && !text.isEmpty()) {
			sb.append(String.join("", Collections.nCopies(indentSize * (indent + 1), " "))).append(text)
					.append(newLine);
		}

		for (HtmlElement e : elements)
			sb.append(e.toStringImpl(indent + 1));

		sb.append(String.format("%s</%s>%s", i, name, newLine));
		return sb.toString();
	}

	@Override
	public String toString() {
		return toStringImpl(this.indent);
	}
}

public class HtmlBuilder {
	private HtmlElement root;

	public HtmlBuilder(String rootName) {
		this.root = new HtmlElement(rootName);
	}

	public HtmlBuilder addChild(String childName, String childText) {
		HtmlElement ele = new HtmlElement(childName, childText);
		this.root.elements.add(ele);
		return this;
	}

	public void clear(String name) {
		this.root = new HtmlElement(name);
	}

	@Override
	public String toString() {
		return this.root.toString();
	}
}

class Demo {
	public static void main(String[] args) {
		HtmlBuilder b = new HtmlBuilder("ul");
		b.addChild("li", "text").addChild("li", "text1").addChild("li", "text2").addChild("li", "text3").addChild("p",
				"tesxt1");
		System.out.println(b.toString());
	}
}
