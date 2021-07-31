package singleton;

public class StaticBlockSingleTon {
	private StaticBlockSingleTon() {
	}

	private static class Impl {
		private static final StaticBlockSingleTon innerStaticInstace = new StaticBlockSingleTon();
		static {
			System.out.println("init");
		}
	}

	public static StaticBlockSingleTon getInstance() {
		return Impl.innerStaticInstace;
	}
}


class Demo12 {
	public static void main(String[] args) {
		StaticBlockSingleTon.getInstance();
	}
}