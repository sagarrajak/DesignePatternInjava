package proxy;

class Property<T> {
	private T value;

	public Property(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}

class Creature {
	public int getAgility() {
		return agility.getValue();
	}

	public void setAgility(int agility) {
		this.agility.setValue(agility);
	}

	private Property<Integer> agility = new Property<Integer>(19);

}

public class PropertyProxy {

}
