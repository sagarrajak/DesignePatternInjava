package singleton;

public class LazySingleTon {
	private static LazySingleTon instance;

	private LazySingleTon() {}

	// with
	public static synchronized LazySingleTon getInstance() {
		if (instance == null) {
			instance = new LazySingleTon();
		}
		return instance;
	}
}