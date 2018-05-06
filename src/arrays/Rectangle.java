package arrays;

abstract class Rectangle {
	public int h;
	public int w;

	abstract void foo();
}

abstract class Square {
	public int h;
	public int w;

	abstract void foo();

	protected abstract void foo1();
}

class Figure extends Rectangle {

	@Override
	void foo() {
		// TODO Auto-generated method stub
//hashta
	}

}

class Main {

	public static void main(String[] string) {
		String a = "string";
		String b = new String("string");
		String c = a;

		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(b.equals(c));

		// t.equals(c);
	}
}