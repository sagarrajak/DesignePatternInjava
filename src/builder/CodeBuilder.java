package builder;

import java.util.HashMap;
import java.util.Map;

class ChunkCode {
	public String className;
	public HashMap<String, String> m = new HashMap<String, String>();
}

public class CodeBuilder {
	public ChunkCode code = new ChunkCode();

	public CodeBuilder(String className) {
		this.code.className = className;
	}

	public CodeBuilder addField(String name, String type) {
		this.code.m.put(name, type);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		String newLine = System.lineSeparator();
		str.append("public class " + this.code.className);
		str.append(newLine);
		str.append("{");
		str.append(newLine);
		for (Map.Entry<String, String> entry : this.code.m.entrySet()) {
			str.append("  public ");
			str.append(entry.getValue());
			str.append(" ");
			str.append(entry.getKey());
			str.append(";");
			str.append(newLine);
		}
		str.append("}");
		str.append(newLine);
		return str.toString();
	}
}

class Demo4 {
	public static void main(String[] args) {
		CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
		System.out.println(cb);
	}
}