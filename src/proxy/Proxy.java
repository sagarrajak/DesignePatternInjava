package proxy;

interface Driveable {
	void drive();
}

class Car implements Driveable {
	protected Driver driver;

	public Car(Driver driver) {
		this.driver = driver;
	}

	@Override
	public void drive() {
		System.out.println("");

	}

}

class Driver {
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int age;

	public Driver(int age) {
		this.age = age;
	}
}

class CarProxy extends Car {

	public CarProxy(Driver driver) {
		super(driver);
	}

	@Override
	public void drive() {
		if (this.driver.getAge() >= 18) {
			super.drive();
		} else {
			System.out.println("Driver is too young");
		}
		super.drive();
	}

}

class Demo {
	public static void main(String[] args) {
		CarProxy car = new CarProxy(new Driver(9));
		car.drive();

	}
}