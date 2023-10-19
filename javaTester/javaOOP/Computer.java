package javaOOP;

public abstract class Computer {

	// normal method
	public void showComputerPerfomance() {
		System.out.println("Show Computer performance");
	}
	//abstract method
	//khung để cho các class con kế thừa nó phải override lại (implement) lại 
	public abstract void showComputerRam();
}
