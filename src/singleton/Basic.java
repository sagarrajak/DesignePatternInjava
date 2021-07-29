package singleton;

import java.io.Serializable;

class SingleTon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private static final SingleTon instance = new SingleTon();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private SingleTon() {
	}

	public static SingleTon getInstace() {
		return instance;
	}

}

public class Basic {
	
	public static void main(String[] args) {
		SingleTon obj1 = SingleTon.getInstace();
		SingleTon obj2 = SingleTon.getInstace();
		
		obj1.setName("test12");
		System.out.println(obj1.getName());
		System.out.println(obj2.getName());
		obj1.setName("test13");
		System.out.println(obj1.getName());
		System.out.println(obj2.getName());
	}
}
