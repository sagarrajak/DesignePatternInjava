package adapter;

public interface Moveable {
	double getSpeed();
}

class SomeCar implements Moveable  {
	public double speed;
	
	@Override
	public double getSpeed() {
		return 100;
	}
}



class MoveableAdaper implements Moveable {

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}