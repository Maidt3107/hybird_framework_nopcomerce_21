package javaAccModSecond;

import javaAccModFird.Computer;

public class Workstation {
	public static void main(String[] args) {
		Computer comp = new Computer();
		
		comp.vgaSize = 6;
		System.out.println(comp.vgaSize);
		
		comp.setVgaSize(4);
		System.out.println(comp.vgaSize);
		
	}
}
