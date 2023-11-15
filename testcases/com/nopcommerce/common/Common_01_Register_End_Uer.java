package com.nopcommerce.common;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Common_01_Register_End_Uer extends BaseTest {

	@Parameters("browser")
	@BeforeTest(description =  "Create new common User for all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		password = "123456";
		
		log.info("Pre.Condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Pre.Condition - Step 02: Enter to Firstname textbox with value is '" + firstName  + "'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Pre.Condition - Step 03: Enter to LastName textbox with value is '" + lastName  + "'");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Pre.Condition - Step 04: Enter to Email textbox with value is '" + emailAddress  + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre.Condition - Step 05: Enter to Password textbox with value is '" + password  + "'");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Pre.Condition - Step 06: Enter to Confirm Password textbox with value is '" + password  + "'");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Pre.Condition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Pre.Condition - Step 08: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre.Condition - Step 09: Click to Logout link");
		homePage = registerPage.clickToLoginLink();

		driver.quit();
	}


	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String firstName, lastName;
	public static String  emailAddress, password;

}
