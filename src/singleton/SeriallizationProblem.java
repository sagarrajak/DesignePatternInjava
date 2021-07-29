package singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeriallizationProblem {

	static void saveToFile(SingleTon obj, String fileName) throws Exception {
		try (FileOutputStream out = new FileOutputStream(fileName);
				ObjectOutputStream objStr = new ObjectOutputStream(out)) {
			objStr.writeObject(obj);
		}
	}

	static SingleTon readFromFile(String fileName) throws Exception {
		try (FileInputStream inStr = new FileInputStream(fileName);
				ObjectInputStream objStr = new ObjectInputStream(inStr)) {
			return (SingleTon) objStr.readObject();
		}
	}

	public static void main(String[] args) throws Exception {
		SingleTon obj = SingleTon.getInstace();
		obj.setName("123");
		saveToFile(obj, "singleTon.bin");
		SingleTon obj2 = readFromFile("singleTon.bin");
		System.out.println(obj == obj2);
		obj2.setName("test123");
		System.out.println(obj.getName());
		System.out.println(obj2.getName());
	}
}
