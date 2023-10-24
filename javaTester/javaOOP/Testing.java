package javaOOP;

public class Testing extends Topic_04_Non_Access_Modifier {

	public static void main(String[] args) {
		//truy cập trực tiếp từ tên class
		// không cần phải tạo instance / object
		//không nên lạm dụng tạo các biến static
		//nên sử dụng nó khi toàn bộ các system sử dụng giá trị này 
		
		System.out.println(Topic_04_Non_Access_Modifier.browserName);
		
		//Khởi tạo các class
		Topic_04_Non_Access_Modifier.sendkeyToElement("Link");
		
		/*
		 * Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		 * System.out.println(topic.colorCar);
		 */
		
		// không báo lỗi trong quá trình compile(trình biên dịch khi mình viết code sai)
		// không đúng convention / không đúng chuẩn / vi phạm chuẩn java nó sẽ báo lỗi ngay)
		
		// 2 loại lỗi
		// lỗi conpiler : trong quá trình viết code sẽ báo lỗi 
		// lỗi runtime: trong quá trình mình run system/ run testcase
	}

}
