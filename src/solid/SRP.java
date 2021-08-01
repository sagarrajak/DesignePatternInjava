package solid;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

// single responsibity principle 

class Journal {
	private static int count = 0;
	private final List<String> entries = new ArrayList<>();

	public Journal() {
	}

	public void addEntry(String entry) {
		entries.add(++Journal.count+". "+entry);
	}

	public void removeEntry(int index) {
		entries.remove(index);
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}

	// save journal to file ( bad practice, class should have only one
	// responsibility )
	public void save(String filename) throws FileNotFoundException {
		try (PrintStream out = new PrintStream(filename)) {
			out.println(toString());
		}
	}

}

class Percistance {
	public void saveToFile(Journal journal, String filename, boolean override) throws FileNotFoundException {
		if (override || new File(filename).exists()) {
			try (PrintStream out = new PrintStream(filename)) {
				out.println(journal.toString());
			}
		}
	}

}

public class SRP {
	public static void main(String[] args) throws Exception {
		Journal journal = new Journal();
		journal.addEntry("First entry");
		journal.addEntry("Second entry");
		journal.addEntry("Third entry");
		System.out.println(journal);
		
		Percistance p = new Percistance();
		String filename = "c:\\temp\\journal.txt";
		p.saveToFile(journal, filename, true);
		Runtime.getRuntime().exec("notepad.exe "+filename);
	}
}
