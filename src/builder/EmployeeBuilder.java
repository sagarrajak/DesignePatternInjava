package builder;

class Person {
	public String name;
	public Integer age;
	public Integer salery;
	public String profile;

	@Override
	public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", age='" + age + '\'' + ", salery='" + salery + '\''
				+ ", profile='" + profile + '}';
	}
}

class PersonBuilder<T extends PersonBuilder<T>> {
	protected Person person = new Person();

	public PersonBuilder() {
	}

	public T withName(String name) {
		person.name = name;
		return self();
	}

	public T withAge(Integer age) {
		person.age = age;
		return self();
	}

	protected Person build() {
		return this.person;
	}

	@SuppressWarnings("unchecked")
	protected T self() {
		return (T) this;
	}
}

public class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

	public EmployeeBuilder() {
	}

	public EmployeeBuilder withSalery(Integer salery) {
		this.person.salery = salery;
		return this;
	}

	public EmployeeBuilder withProfile(String profile) {
		this.person.profile = profile;
		return this;
	}

	@Override
	protected EmployeeBuilder self() {
		return this;
	}

	@Override
	protected Person build() {
		// TODO Auto-generated method stub
		return this.person;
	}
}

class Demo2 {
	public static void main(String[] args) {
		//Fluient Interface 
		EmployeeBuilder eb = new EmployeeBuilder();
		Person p = eb.withName("Sagar rajak").withAge(26).withProfile("Developer").withAge(36).build();
		System.out.println(p);
	}
}