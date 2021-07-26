import java.util.ArrayList;
import java.util.List;

class Jounal {
	private final List<String> journals = new ArrayList<>();
	private static int count = 0;

	public void addEntry(String text) {
		journals.add("" + (++count) + " : " + text);
	}
}

public class SingleResponsibilityPrinciple {
	public static void main(String[] args) {

	}
}
