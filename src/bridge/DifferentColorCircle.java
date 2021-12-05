package bridge;

interface DrawCircleApi {
	public void drawShape(float radious, int x, int y);
}

class GreenCircle implements DrawCircleApi {
	@Override
	public void drawShape(float radious, int x, int y) {
		System.out.println("This will draw green circle");
	}

}

class RedCircle implements DrawCircleApi {
	@Override
	public void drawShape(float radious, int x, int y) {
		System.out.println("This will draw red circle");
	}
}

abstract class ShapeApi {
	protected DrawCircleApi drawApi;

	protected ShapeApi(DrawCircleApi draw) {
		this.drawApi = draw;
	}

	protected abstract void draw();

	protected abstract double getArea();
}

class CircleShape extends ShapeApi {
	protected float radious;
	protected int x, y;

	protected CircleShape(DrawCircleApi draw, int x, int y, int radious) {
		super(draw);
		this.x = x;
		this.y = y;
		this.radious = radious;
	}

	@Override
	protected void draw() {
		this.drawApi.drawShape(radious, x, y);
	}

	@Override
	protected double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * radious * radious;
	}

}

public class DifferentColorCircle {
	public static void main(String[] args) {
		GreenCircle greenCircle = new GreenCircle();
		RedCircle redCircle = new RedCircle();
		ShapeApi solarApiGreen = new CircleShape(greenCircle, 10, 3, 4);
		ShapeApi solarApiRed = new CircleShape(redCircle, 100, 5, 10);
		solarApiGreen.draw();
		solarApiRed.draw();
	}
}