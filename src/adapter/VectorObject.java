package adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VectorObject extends ArrayList<Line> {
}

class VectorRectangle extends VectorObject {
	public VectorRectangle(int width, int height, int x, int y) {
		add(new Line(new Point(x, y), new Point(x + width, y)));
		add(new Line(new Point(x, y), new Point(x, y + height)));
		add(new Line(new Point(x, y + height), new Point(x + width, y + height)));
		add(new Line(new Point(x + width, y + height), new Point(x + width, y)));
	}
}

class LineToPointAdapter extends ArrayList<Point> {
    private static int count = 0;
	public LineToPointAdapter(Line line) {
		  System.out.println(
			      String.format("%d: Generating points for line [%d,%d]-[%d,%d] (no caching)",
			        ++count, line.start.x, line.start.y, line.end.x, line.end.y));
	    int left = Math.min(line.start.x, line.end.x);
	    int right = Math.max(line.start.x, line.end.x);
	    int top = Math.min(line.start.y, line.end.y);
	    int bottom = Math.max(line.start.y, line.end.y);
	    int dx = right - left;
	    int dy = line.end.y - line.start.y;

	    if (dx == 0)
	    {
	      for (int y = top; y <= bottom; ++y)
	      {
	        add(new Point(left, y));
	      }
	    }
	    else if (dy == 0)
	    {
	      for (int x = left; x <= right; ++x)
	      {
	        add(new Point(x, top));
	      }
	    }
	}
}

class Demo100 {
	private final static List<VectorObject> vectorObjects = new ArrayList<>(
			Arrays.asList(new VectorRectangle(100, 200, 100, 100), new VectorRectangle(200, 200, 300, 300)));

	public static void DrawPoint(Point p) {
		System.out.println("x");
	}
	
	public static void Draw() {
		for (VectorObject obj: vectorObjects) { 
			for (Line line: obj) { 
				LineToPointAdapter ltpAdp = new LineToPointAdapter(line); 
				ltpAdp.forEach(Demo100::DrawPoint);
			}
		}
	} 
	
	public static void main(String[] args) {
		Demo100.Draw();
	}
}