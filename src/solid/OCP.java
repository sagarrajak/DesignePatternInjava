package solid;

import java.util.List;
import java.util.stream.Stream;

enum Color {
	RED, GREEN, BLUE
}

enum Size {
	SMALL, MEDIUM, LARGE, HUGE
}

class Product {
	public String name;
	public Color color;
	public Size size;

	public Product(String name, Color color, Size size) {
		this.color = color;
		this.name = name;
		this.size = size;
	}
}

class ProductFilter {
	// this is wrong we shoud't do this
	public Stream<Product> filterByColor(List<Product> products, Color color) {
		return products.stream().filter(p -> p.color == color);
	}

	// this is wrong we shoud't do this
	public Stream<Product> filterBySize(List<Product> products, Size size) {
		return products.stream().filter(p -> p.size == size);
	}
}

interface Specification<T> {
	boolean isSatisfied(T item);
}

interface Filter<T> {
	Stream<T> filter(List<T> items, Specification<T> spec);
}

class AndSpecification<T> implements Specification<T> {
	Specification<T> first;
	Specification<T> second;

	public AndSpecification(Specification<T> first, Specification<T> second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean isSatisfied(T item) {
		return first.isSatisfied(item) && second.isSatisfied(item);
	}

}

class ColorSpecification implements Specification<Product> {
	private Color color;

	public ColorSpecification(Color color) {
		this.color = color;
	}

	@Override
	public boolean isSatisfied(Product item) {
		return item.color == color;
	}
}

class SizeSpecification implements Specification<Product> {
	private Size size;

	public SizeSpecification(Size size) {
		this.size = size;
	}

	@Override
	public boolean isSatisfied(Product item) {
		return item.size == size;
	}

}

class BetterFilter implements Filter<Product> {

	@Override
	public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
		return items.stream().filter(p -> spec.isSatisfied(p));
	}

}

// Open close principle
// Any Class is open for extension and closed for modification
public class OCP {
	public static void main(String[] args) {
		Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
		Product elephant = new Product("Elephant", Color.RED, Size.HUGE);
		Product tree = new Product("Tree", Color.GREEN, Size.SMALL);

		List<Product> products = List.of(apple, elephant, tree);
		BetterFilter bf = new BetterFilter();
		bf.filter(products, new ColorSpecification(Color.BLUE))
				.forEach(p -> System.out.println("- Blue prodcut " + p.name));

		bf.filter(products, new ColorSpecification(Color.GREEN))
				.forEach(p -> System.out.println("- Green product " + p.name));
		bf.filter(products,
				new AndSpecification<Product>(new ColorSpecification(Color.GREEN), new SizeSpecification(Size.SMALL)))
				.forEach(p -> System.out.println(p.name));
	}
}
