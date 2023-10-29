package javaOOP.inheritance;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	

	public static void main(String[] args) {
		Dog dog = new Dog();
		
		dog.setAge(-15); 
		System.out.println(dog.age);
		
		dog.setAge(15); 
		System.out.println(dog.age);
		
		dog.setAge(0); 
		System.out.println(dog.age);
	}
 
}
