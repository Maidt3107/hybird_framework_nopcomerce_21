package javaBasic;

import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

@Listeners(commons.MethodListener.class)
public class Topic_17_Assert extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		System.out.println("Assert 01 - Pass");
		String loginPageUrl = driver.getCurrentUrl();
		verifyEquals(loginPageUrl, "https://www.facebook.com/");
		
		System.out.println("Assert 02 - Failed");
		String loginPageTitle= driver.getTitle();
		verifyEquals(loginPageTitle, "Facebook - log in or sign up...");
		
		System.out.println("Assert 03 - Pass");
		verifyTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
		
		System.out.println("Assert 04 - Failed");
		verifyTrue(driver.findElement(By.xpath("//input[@name='login_source']")).isDisplayed());
		
		System.out.println("Assert 05 - Pass");
		verifyTrue(driver.findElement(By.xpath("//div[@id='reg_pages_msg']")).isDisplayed());
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
