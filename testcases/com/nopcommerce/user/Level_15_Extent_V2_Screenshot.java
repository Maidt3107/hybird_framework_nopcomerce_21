package com.nopcommerce.user;

import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_15_Extent_V2_Screenshot extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		validpassword = "123456";

	}

	@Test
	public void User_01_Register(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register' page");
//		registerPage = homePage.openRegisterPage();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName  + "'");
//		registerPage.inputToFirstnameTextbox(firstName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to LastName textbox with value is '" + lastName  + "'");
//		registerPage.inputToLastNameTextbox(lastName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is '" + emailAddress  + "'");
//		registerPage.inputToEmailTextbox(emailAddress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validpassword  + "'");
//		registerPage.inputToPasswordTextbox(validpassword);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + validpassword  + "'");
//		registerPage.inputToConfirmPasswordTextbox(validpassword);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Register' button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify register success message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
//		ExtentManager.endTest();

	}
	@Test
	public void User_02_Login(Method method) {
//		ExtentManager.startTest(method.getName(), "User_02_Login");
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Logout link");
//		homePage = registerPage.clickToLoginLink();
//		loginPage = homePage.openLoginPage();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email textbox with value is '" + emailAddress  + "'");
//		loginPage.inputToEmailTextbox(emailAddress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password textbox with value is '" + emailAddress  + "'");
//		loginPage.inputToPasswordTextbox(validpassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to Logout link");
//		homePage = loginPage.clickToLoginButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My Account' link displayed");
//		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to 'My Account' page");
//		customerInforPage = homePage.openMyAccountPage();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify  'Customer Infor' page is displayed");
//		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
//		ExtentManager.endTest();
//		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	 WebDriver driver;
	 UserHomePageObject homePage;
	 UserRegisterPageObject registerPage;
	 UserLoginPageObject loginPage;
     UserCustomerInforPageObject customerInforPage;
	 String firstName, lastName, emailAddress, validpassword;

}
