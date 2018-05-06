package collision;

/**
 * 
 * @author sergiogp
 *
 */
public class Point {

	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class TestingPoint {
	public static void change(Point p1, Point p2) {
		p1.x = 100;
		p1.y = 100;
	}

	public static void main(String[] args) {
		Point p1 = new Point(0, 0);
		Point p2 = p1;
		System.out.println("X: " + p1.x + " Y: " + p1.y);
		System.out.println("X: " + p2.x + " Y: " + p2.y);
		System.out.println();
		change(p1, p2);
		System.out.println("X: " + p1.x + " Y:" + p1.y);
		System.out.println("X: " + p2.x + " Y:" + p2.y);
	}
}