package javaOOP;

public class Topic_04_Non_Access_Modifier {
	// static : variable/ method
	// dùng cho tất cả các instance / object
	// phạm vi cho toàn bộ system sử dụng nó
	// có thể override được
	static String browserName = "Chrome";

	// non static
	String serverName = "Testing";
	
	//hằng số
	final String colorCar = "Red";

	public static void main(String[] args) {
		System.out.println(browserName);

		browserName = "Firefox";
		System.out.println(browserName);
		/*
		 * Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		 * System.out.println(topic.serverName);
		 * 
		 * // không được phép gán lại giá trị System.out.println(topic.colorCar);
		 * 
		 * topic.clickToElement("Button");
		 */
		
		sendkeyToElement("Link");
	}

	// non - static
	public void clickToElement(String elementName) {
		System.out.println(elementName);

	}

	// static
	public static  void sendkeyToElement(String elementName) {
		System.out.println(elementName);

	}
	// final
	public final void setCarName() {
		
	}
}