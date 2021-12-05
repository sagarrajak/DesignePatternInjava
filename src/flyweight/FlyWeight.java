package flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

class User {
	private String fullName;

	public User(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}

class User2 {
	private ArrayList<String> strings = new ArrayList<String>();
	private int[] names;

	public User2(String name) {
		Function<String, Integer> getOrAdd = (String s) -> {
			int idx = strings.indexOf(s);
			if (idx >= 0)
				return idx;
			else {
				strings.add(name);
				return strings.size() - 1;
			}
		};
		names = Arrays.stream(name.split(" ")).mapToInt(s -> getOrAdd.apply(s)).toArray();
	}
}

class FlyWeight {
	public static void main(String[] args) {
		User2 user2 = new User2("sagar rajak");
		User2 user3 = new User2("sagar kumar");
		User2 user4 = new User2("sheetal kumari");
		User2 user5 = new User2("Sheetal whatever");
	}
}
