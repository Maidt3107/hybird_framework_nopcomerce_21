package javaOOP;

public class Topic_03_Method {
	//non - static
	 void showCarName() {
		System.out.println("Huyndai Tucson");
	}

	static  void showCarColor() {
		System.out.println("White");
	}

	public static void main(String[] args) {
		//gọi vào trong 1 hàm static khác được 
		showCarColor();
		
		// gọi qua instance / object
		Topic_03_Method obj = new Topic_03_Method();
		obj.showCarName();

	}

}
