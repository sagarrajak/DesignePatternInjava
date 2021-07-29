package prototype;

class Address {
	public String streetAddress, city, country;

	public Address(String streetAddress, String city, String country) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.country = country;
	}

	public Address(Address address) {
		this(address.streetAddress, address.city, address.country);
	}

	@Override
	public String toString() {
		return "Address{" + "streetAddress='" + streetAddress + '\'' + ", city='" + city + '\'' + ", country='"
				+ country + '\'' + '}';
	}
}

class Employee {
	public String firstName, lastName;
	public Address adderess;

	public Employee(String firstname, String lastname, Address address) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.adderess = address;
	}

	public Employee(Employee employee) {
		this(employee.firstName, employee.lastName, new Address(employee.adderess));
	}

	@Override
	public String toString() {
		return "Employee{" + "firstName='" + firstName + '\'' + "lastName='" + lastName + '\'' + ", address=" + adderess
				+ '}';
	}
}

public class CopyConstructor {
	public static void main(String[] args) {
		Employee emp = new Employee("sagar", "rajak", new Address("baner", "Pune", "India"));
		Employee emp2 = new Employee(emp);
		emp2.firstName = "sumit";
		emp2.lastName = "kumar";
		System.out.println(emp2);
		System.out.println();
	}
}
