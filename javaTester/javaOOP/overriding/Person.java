package javaOOP.overriding;

public abstract class Person {
	//option
	public void eat() {
		System.out.println("suất cơm 20.000 VND");
	}
	//must(template)
	public abstract void sleep();
	
	public final void wail() {
		System.out.println("đi bộ");
	}

	public static void run() {
		System.out.println("đi bộ");
	}
	private  void dating() {
		System.out.println("hẹn hò");
	}

}
