package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_05_This_Super extends BaseOOP {
	private WebDriver driver;
	 private long longTimeout = 45;
	
	 public Topic_05_This_Super() {
		 super("Chrome");
		 System.out.println("Contructor tai class con");
	 }
	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
	
	}
	public void clickToElement() {
		//không dùng super nó sẽ gọi qua hàm ở class con (hiện tại)
		setImplicitWait();
		
		// gọi qua hàm ở lớp cha
		super.setImplicitWait();
		
		
	}

	public static void main(String[] args) {
		Topic_05_This_Super topic = new Topic_05_This_Super();
		
	}

}
