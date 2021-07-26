package builder;

class Person2 {
	public String streetAddress, postcode, city;
	public String companyName, position;
	public int annualIncome;

	public String toString() {
		return "Person{" + "streetAddress='" + streetAddress + '\'' + ", postcode='" + postcode + '\'' + ", city='"
				+ city + '\'' + ", companyName='" + companyName + '\'' + ", position='" + position + '\''
				+ ", annualIncome=" + annualIncome + '}';
	}
}

class Person2Builder {
	protected Person2 person = new Person2();

	public PersonAddressBuilder lives() {
		return new PersonAddressBuilder(this.person);
	}

	public PersonJobBuilder job() {
		return new PersonJobBuilder(this.person);
	}

	public Person2 build() {
		return this.person;
	}
}

class PersonAddressBuilder extends Person2Builder {
	public PersonAddressBuilder(Person2 person) {
		this.person = person;
	}

	public PersonAddressBuilder in(String city) {
		this.person.city = city;
		return this;
	}

	public PersonAddressBuilder withPostcode(String postcode) {
		this.person.postcode = postcode;
		return this;
	}

	public PersonAddressBuilder at(String street) {
		this.person.streetAddress = street;
		return this;
	}
}

class PersonJobBuilder extends Person2Builder {
	public PersonJobBuilder(Person2 person) {
		this.person = person;
	}

	public PersonJobBuilder worksAt(String company) {
		this.person.companyName = company;
		return this;
	}

	public PersonJobBuilder position(String position) {
		this.person.position = position;
		return this;
	}

	public PersonJobBuilder incomeIs(int income) {
		this.person.annualIncome = income;
		return this;
	}
}

class Demo3 {
	public static void main(String[] args) {
		Person2 person = new Person2Builder().lives().at("Birsanagar zone number 3").in("Jamshedput")
				.withPostcode("411034").job().worksAt("Talentica").position("Software developer").incomeIs(20000000)
				.build();
		System.out.println(person);
	}
}
