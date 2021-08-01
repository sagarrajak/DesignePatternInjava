package solid;

import org.javatuples.Triplet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum Relation {
	PARENT, CHILD, SIBLING
}

class Person {
	private String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}

//Abstraction
interface RelationshipBrowser {
	List<Person> findAllChildrenOf(String name);
}

// Low level module 
class RelationShip implements RelationshipBrowser {
	private List<Triplet<Person, Relation, Person>> relations = new ArrayList<Triplet<Person, Relation, Person>>();

	public void addParentAndChild(Person parent, Person child) {
		relations.add(new Triplet<Person, Relation, Person>(parent, Relation.CHILD, child));
		relations.add(new Triplet<Person, Relation, Person>(child, Relation.PARENT, parent));
	}

	public List<Triplet<Person, Relation, Person>> getRelationShip() {
		return this.relations;
	}

	@Override
	public List<Person> findAllChildrenOf(String name) {
		return this.relations.stream()
				.filter(p -> p.getValue0().getName().equals(name) && p.getValue1() == Relation.CHILD)
				.map(Triplet::getValue2).collect(Collectors.toList());
	}

}

// High level module (wrong implementation) 
class Research {
	public Research(RelationShip relationships) {
		List<Triplet<Person, Relation, Person>> relations = relationships.getRelationShip();
		relations.stream().filter(p -> p.getValue0().getName().equals("John") && p.getValue1() == Relation.CHILD)
				.forEach(p -> System.out.println(" John had child " + p.getValue2().getName()));
		;
	}
}

// High level module (right implementation) 
class Research2 {
	public Research2(RelationshipBrowser browser) {
		List<Person> childs = browser.findAllChildrenOf("John");
		childs.stream().forEach(p -> System.out.println("John child is " + p.getName()));
	}
}

public class DIP {
	public static void main(String[] args) {
		RelationShip relationship = new RelationShip();
		relationship.addParentAndChild(new Person("John"), new Person("Duo"));
		relationship.addParentAndChild(new Person("John"), new Person("Duo2.0"));
		relationship.addParentAndChild(new Person("John"), new Person("Duo3.0"));
//		Research research = new Research(relationship);
		
		Research2 research2 = new Research2(relationship);

	}
}
