package chainOfResponsibility;

class Creature {
	public String name;
	public int attack, defence;

	public Creature(String name, int attack, int defence) {
		super();
		this.name = name;
		this.attack = attack;
		this.defence = defence;
	}

	@Override
	public String toString() {
		return "{ name: " + name + ", attack: " + attack + ", Defence: " + defence + "} ";
	}

}

class CreatureModifer {
	protected Creature creature;
	protected CreatureModifer current, next;

	public CreatureModifer(Creature creature) {
		this.creature = creature;
	}

	public void add(CreatureModifer cm) {
		if (next != null) {
			next.add(cm);
		} else {
			next = cm;
		}
	}

	public void handle() {
		if (next != null)
			next.handle();
	}
}

class DoubleAttackModifer extends CreatureModifer {

	public DoubleAttackModifer(Creature creature) {
		super(creature);
	}

	@Override
	public void handle() {
		System.out.println("Applying Double Defence Modifier");
		this.creature.attack += 2;
		super.handle();
	}
}

class IncreaseDefenceModifer extends CreatureModifer {

	public IncreaseDefenceModifer(Creature creature) {
		super(creature);
	}

	@Override
	public void handle() {
		this.creature.defence += 10;
		System.out.println("Applying Increate Defence");
		super.handle();
	}

}

class NoBonusModifier extends CreatureModifer {

	public NoBonusModifier(Creature creature) {
		super(creature);
	}
	
	@Override
	public void handle() {
		System.out.println("No bonus after that");
	}

}

public class MethodChain {
	public static void main(String[] args) {
		Creature goblin = new Creature("Goblin", 12, 4);
		CreatureModifer root = new CreatureModifer(goblin);
		root.add(new DoubleAttackModifer(goblin));
		root.add(new IncreaseDefenceModifer(goblin));
		root.add(new IncreaseDefenceModifer(goblin));
		root.add(new DoubleAttackModifer(goblin));
		root.add(new NoBonusModifier(goblin));
		root.add(new DoubleAttackModifer(goblin));
		root.handle();
		System.out.println(goblin);
	}
}
