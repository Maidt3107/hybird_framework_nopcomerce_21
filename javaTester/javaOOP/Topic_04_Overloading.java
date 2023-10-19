package javaOOP;

public class Topic_04_Overloading {
	static int plusMethod(int x, int y) {
		return x + y;
	}
	
	static double plusMethod(double x, double y) {
		return x + y;
	}
	public static void main(String[] args) {
		plusMethod(1, 2);
		plusMethod(1.1, 2.2);
	}

}
