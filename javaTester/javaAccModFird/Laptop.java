package javaAccModFird;

public class Laptop {
	public static void main(String[] args) {
       Computer comp = new Computer();
		
		//property
		comp.ramProductName = "KingTon";
		System.out.println(comp.ramProductName);
		
		//method
		comp.setRamProductName("KingMax");
		System.out.println(comp.ramProductName);
		
		comp.cpuProductName = "Intel";
		System.out.println(comp.cpuProductName);
		
		comp.setCpuProductName("AMD");
		System.out.println(comp.cpuProductName);
		
		comp.vgaSize = 6;
		System.out.println(comp.vgaSize);
		
		comp.setVgaSize(4);
		System.out.println(comp.vgaSize);
	}
}
