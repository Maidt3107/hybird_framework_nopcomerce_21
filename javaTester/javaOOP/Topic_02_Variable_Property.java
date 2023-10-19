package javaOOP;

public class Topic_02_Variable_Property {
	static int studentNumber;
	static float studentPrice;
	static String studentCountry;
	static boolean studentStatus;
	
	// Access modifier
	// data type
	// variable name
	// variable value
	private String studentName = "Automation FC";// biến toàn cục (Global variable)
	
	//static variale:  dùng và gán lại được trong cùng package
	public static String studentAddress = "Ho Chi Minh";
	// dùng trong phạm vi class này ( cho tất cả instance/ object dùng )
	private static String studentPhone = "0123456789";
	
	// final variable: không cho phép gán lại / không override lại 
	// cố định dữ liệu không đượcphép thay đổi trong quá trình chạy
	final String country = "Viet Nam";
	
	// static final variable: hằng số
	// nó không được ghi đè
	// có thể truy cập rộng rãi cho tất cả các instance/thread
	static final float PI_NUMBER = 3.1423544f;

	// access modifier : defaut
	int studentID = 10056;

	// hàm (method) - static
	public static void main(String[] args) {
		// local variable - biến cục bộ : hàm / block code / contructor
		String studentName = "Automation FC";

		if (studentName.startsWith("Automation")) {
			// local variable - biến cục bộ : block code
			int number = 100;
		}
		studentAddress = "Da Nang";
		studentPhone = "0987654321";
		
		//local variable : bắt buộc phải khởi tạo mới được sử dụng
//		 int studentNumber = 1;
//		 float studentPrice = 2;
//		 String studentCountry= "City";
//		 boolean studentStatus= false;
		
		System.out.println(studentNumber);
		System.out.println(studentCountry);
		System.out.println(studentStatus);
		System.out.println(studentPrice);

	}

	// contructor
	public Topic_02_Variable_Property() {
		// local variable - biến cục bộ : hàm / block code / contructor
		String studentName = "Automation FC";
	}

	// hàm (method) - non static
	public void display() {
		// local variable - biến cục bộ : hàm
		String studentName = "Automation FC";
	}

}
