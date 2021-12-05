package proxy;

class Person
{
  private int age;

  public Person(int age)
  {
    this.age = age;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public String drink() { return "drinking"; }
  public String drive() { return "driving"; }
  public String drinkAndDrive() { return "driving while drunk"; }
}

class ResponsiblePerson
{
  private Person person;

  public ResponsiblePerson(Person person)
  {
	  this.person = person;
  }
  
  public String drink() { 
	  if (this.person.getAge() >= 18) {
		  return this.person.drink();
	  } else {
		  return "Too young";
	  }
  }
  
  public String drive() { 
	  if (this.person.getAge() >= 18) {
		  return this.person.drive();
	  } else {
		  return "Too young";
	  }
  }
  
  public String drinkAndDrive() {
	  if (this.person.getAge() >= 18) {
		  return this.person.drinkAndDrive();
	  } else {
		  return "Too young";
	  }
  }
}