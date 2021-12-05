package composition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;


interface SomeNeuron extends Iterable<NeuronNet> {
	default void connectTo(SomeNeuron other) {
		for (NeuronNet from: this)
			for(NeuronNet to: other) {
				from.out.add(to);
				to.in.add(from);
			}
	}	
}


class NeuronNet  implements SomeNeuron {
	public ArrayList<NeuronNet> in, out;

	@Override
	public Iterator<NeuronNet> iterator() {
		return Collections.singleton(this).iterator();
	}
	
	@Override
	public void forEach(Consumer<? super NeuronNet> action) {
		action.accept(this);
	}
	
	@Override
	public Spliterator<NeuronNet> spliterator() {
		return Collections.singleton(this).spliterator();
	}
}


@SuppressWarnings("serial")
class NeyuronLayer extends ArrayList<NeuronNet> {}


class NuronDemo {
	public static void main(String[] args) {
		NeuronNet neuron1 = new NeuronNet();
		NeuronNet neuron2 = new NeuronNet();
		
	}
}