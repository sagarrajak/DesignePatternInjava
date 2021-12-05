package decorator;

interface Shape {
	String info();
}

class CircleShape implements Shape {

	public CircleShape(float radious) {
		super();
		this.radious = radious;
	}

	public float getRadious() {
		return radious;
	}

	public void setRadious(float radious) {
		this.radious = radious;
	}

	private float radious;

	public void resize(float factor) {
		this.radious *= factor;
	}

	@Override
	public String info() {
		return "This is circle Shape of radios " + radious;
	}

}

class SquareShape implements Shape {
	private float side;

	public SquareShape(float side) {
		super();
		this.side = side;
	}

	@Override
	public String info() {
		return "this is square shape of side " + side;
	}

	public float getSide() {
		return side;
	}

	public void setSide(float side) {
		this.side = side;
	}

}

class ColorShape implements Shape {
	private Shape shape;
	private String color;

	public ColorShape(Shape shape, String color) {
		super();
		this.shape = shape;
		this.color = color;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String info() {
		return shape.info() + " of color " + color + " ";
	}
}

class TrasparentShape implements Shape {
	private Shape shape;

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public float getTransparancy() {
		return transparancy;
	}

	public void setTransparancy(float transparancy) {
		this.transparancy = transparancy;
	}

	private float transparancy;

	public TrasparentShape(Shape shape, float transparancy) {
		super();
		this.shape = shape;
		this.transparancy = transparancy;
	}

	@Override
	public String info() {
		return shape.info() + " of transparancy " + this.transparancy;
	}
}

class DynamicDecorator {
	public static void main(String[] args) {
		CircleShape cirle = new CircleShape(12);
		SquareShape square = new SquareShape(29);
		
		System.out.println(cirle.info());
		System.out.println(square.info());
		ColorShape redCirle = new ColorShape(cirle, "red");
		ColorShape greenSquare = new ColorShape(square, "green");
		
		System.out.println(redCirle.info());
		System.out.println(greenSquare.info());
		TrasparentShape greenTransparentCircle = new TrasparentShape(greenSquare, (float)0.2);
		System.out.println(greenTransparentCircle.info());
		
	}
}
