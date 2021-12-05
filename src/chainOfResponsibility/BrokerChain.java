package chainOfResponsibility;

import java.util.*;
import java.util.function.Consumer;

public class BrokerChain {

}

class Events<Args> {
	private int index = 0;
	private Map<Integer, Consumer<Args>> handlers = new HashMap<>();

	public int subscribe(Consumer<Args> handlers) {
		int i = index;
		this.handlers.put(index++, handlers);
		return i;
	}

	public void unsubscribe(int key) {
		this.handlers.remove(key);
	}

	public void fire(Args args) {
		for (Consumer<Args> handler : this.handlers.values())
			handler.accept(args);
	}
}

class Query {
	public String creatureName;

	enum Arguments {
		ATTACK, DEFENCE
	};

	public Arguments arguments;
	public int result;

	public Query(String creatureName, Arguments arguments, int result) {
		super();
		this.creatureName = creatureName;
		this.arguments = arguments;
		this.result = result;
	}
}

class Game {
	public Events<Query> queries = new Events<>();
}

class CreatureNew {
	private Game game;
	public String name;
	public int baseAttack, baseDefence;

	public CreatureNew(Game game, String name, int baseAttack, int baseDefence) {
		super();
		this.game = game;
		this.name = name;
		this.baseAttack = baseAttack;
		this.baseDefence = baseDefence;
	}

	int getAttack() {
		Query q = new Query(name, Query.Arguments.ATTACK, baseAttack);
		game.queries.fire(q);
		return q.result;
	}

	int getDefence() {
		Query q = new Query(name, Query.Arguments.DEFENCE, baseDefence);
		game.queries.fire(q);
		return q.result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Creature{" + "name='" + name + '\'' + ", atttack=" + getAttack() + ", defence=" + getDefence() + '}';
	}
}

class CreatureModifier {
	protected Game game;
	protected CreatureNew creature;

	public CreatureModifier(Game game, CreatureNew creature) {
		super();
		this.game = game;
		this.creature = creature;
	}
}

class DoubleAttackModifier
		extends CreatureModifier implements AutoCloseable  {
	public int token;
	public DoubleAttackModifier(Game game, CreatureNew creature) {
		super(game, creature);
		token = game.queries.subscribe(q -> {
			if (q.creatureName.equals(creature.name) &&
					q.arguments == Query.Arguments.ATTACK) {
				q.result*=2;
			}
		});
	}
	
	
	@Override
	public void close() throws Exception {
		game.queries.unsubscribe(token);
	}
}

class IncreaseDefenceModifier extends CreatureModifier {
	public IncreaseDefenceModifier(Game game, CreatureNew creature) {
		super(game, creature);
		game.queries.subscribe(q -> {
			if (q.creatureName.equals(creature.name)
					&& q.arguments.equals(Query.Arguments.DEFENCE)) {
				q.result+=2;
			}
		});
	}
}


class Demo {
	public static void main(String[] args) {
		Game game = new Game();
		CreatureNew goblin = new  CreatureNew(game, "Goblin", 10, 20);
		DoubleAttackModifier dam = new DoubleAttackModifier(game, goblin);
		new DoubleAttackModifier(game, goblin);
		new DoubleAttackModifier(game, goblin);
		new DoubleAttackModifier(game, goblin);
		new DoubleAttackModifier(game, goblin);
		IncreaseDefenceModifier idm = new IncreaseDefenceModifier(game, goblin);
		System.out.println(goblin);
	}
}
