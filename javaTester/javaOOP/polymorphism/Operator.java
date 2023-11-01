package javaOOP.polymorphism;

public class Operator {
	public void sum(int a, int b) {
		System.out.println(a + b);
	}

	public void sum(double a, double b) {
		System.out.println(a + b);
	}

	public void sum(float a, float b) {
		System.out.println(a + b);
	}

	public void sum(long a, long b) {
		System.out.println(a + b);
	}

	public static void main(String[] args) {
		Operator opr = new Operator();
		
		//trình biên dịch nó sẽ chọn phương thức nào
		opr.sum(5, 8);
		opr.sum(5.18d, 4.34d);
		opr.sum(4.56f, 6.54f);
		opr.sum(500000l, 400000l);

	}

}
