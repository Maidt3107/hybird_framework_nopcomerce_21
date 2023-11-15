package com.nopcommerce.user;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_Uer;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_16_Share_Data_B extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		validpassword = "123456";

		
		log.info("Pre.Condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Pre.Condition - Step 02: Enter to Firstname textbox with value is '" + firstName  + "'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Pre.Condition - Step 03: Enter to LastName textbox with value is '" + lastName  + "'");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Pre.Condition - Step 04: Enter to Email textbox with value is '" + emailAddress  + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre.Condition - Step 05: Enter to Password textbox with value is '" + validpassword  + "'");
		registerPage.inputToPasswordTextbox(validpassword);
		
		log.info("Pre.Condition - Step 06: Enter to Confirm Password textbox with value is '" + validpassword  + "'");
		registerPage.inputToConfirmPasswordTextbox(validpassword);
		
		log.info("Pre.Condition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Pre.Condition - Step 08: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");

		log.info("Pre.Condition - Step 09: Click to Logout link");
		homePage = registerPage.clickToLoginLink();
		
		log.info("Pre.Condition - Step 10: Navigate to Logout link");
		loginPage = homePage.openLoginPage();

		log.info("Pre.Condition - Step 11: Enter to Email textbox with value is '" + emailAddress  + "'");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre.Condition - Step 12: Enter to Password textbox with value is '" + emailAddress  + "'");
		loginPage.inputToPasswordTextbox(validpassword);

		log.info("Pre.Condition - Step 13: Click to Logout link");
		homePage = loginPage.clickToLoginButton();

	}
	@Test
	public void Search_01_Empty_Data() {
		
	}
	
	@Test
	public void Search_02_Relative_Product_Name() {
		
	}
	
	@Test
	public void Search_03_Absolute_Product_Name() {
		
	}

	@Test
	public void Search_04_Parent_Category() {
		
	}

	@Test
	public void Search_05_Incorrect_Manufactorer() {
		
	}

	@Test
	public void Search_06_Correct_Manufactorer() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private String firstName, lastName, emailAddress, validpassword;


}
