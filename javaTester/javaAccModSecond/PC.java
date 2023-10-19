package javaAccModSecond;

import javaAccModFird.Computer;

public class PC extends Computer {

	public void showCPUProductName() {
		cpuProductName = "Intel";
		System.out.println(cpuProductName);
		
		setCpuProductName("AMD");
		System.out.println(cpuProductName);
		
		vgaSize = 6;
		System.out.println(vgaSize);
		
		setVgaSize(4);
		System.out.println(vgaSize);
	}

}
