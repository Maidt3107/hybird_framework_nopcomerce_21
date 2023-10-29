package javaOOP.overriding;

public class Student extends Person implements IWork{
	@Override
	public void eat() {
		System.out.println("suất cơm 15.000 VND");
	}

	@Override
	public void sleep() {
		System.out.println("ngủ 12 tiếng 1 ngày");
		
	}

	@Override
	public void workingTime() {
		System.out.println("học 3 tiếng 1 ngày");
	}

}
