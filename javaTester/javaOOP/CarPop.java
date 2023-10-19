package javaOOP;

public class CarPop {
	static String carCompany;
	static String carType;
	static String fuelType;
	static Float mileAge;
	static Double carPrice;

	public static void main(String[] args) {
		carCompany = "Honda";
		carType = "City";
		fuelType = "Petrol";
		mileAge = 200f;
		carPrice = 5000d;
		System.out.println("Car company = " + carCompany);
		System.out.println("Car Type = " + carType);
		System.out.println("Car fuel Type = " + fuelType);
		System.out.println("Car mile Age = " + mileAge);
		System.out.println("Car Price = " + carPrice);
		
		carCompany = "Huyndai";
		carType = "Accent";
		fuelType = "Diesel";
		mileAge = 500f;
		carPrice = 15000d;
		System.out.println("Car company = " + carCompany);
		System.out.println("Car Type = " + carType);
		System.out.println("Car fuel Type = " + fuelType);
		System.out.println("Car mile Age = " + mileAge);
		System.out.println("Car Price = " + carPrice);
		
	}

}
