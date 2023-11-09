package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_15_Extent_V5 extends BaseTest {

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
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
		
		registerPage = homePage.openRegisterPage();
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName  + "'");
		registerPage.inputToFirstnameTextbox(firstName);
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to LastName textbox with value is '" + lastName  + "'");
		registerPage.inputToLastNameTextbox(lastName);
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is '" + emailAddress  + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validpassword  + "'");
		registerPage.inputToPasswordTextbox(validpassword);
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + validpassword  + "'");
		registerPage.inputToConfirmPasswordTextbox(validpassword);
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}
	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system successfully");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Logout link");
		homePage = registerPage.clickToLoginLink();
		loginPage = homePage.openLoginPage();
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox with value is '" + emailAddress  + "'");
		loginPage.inputToEmailTextbox(emailAddress);
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox with value is '" + emailAddress  + "'");
		loginPage.inputToPasswordTextbox(validpassword);
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Logout link");
		homePage = loginPage.clickToLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify 'My Account' link displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage();
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 07: Verify  'Customer Infor' page is displayed");
		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
		
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
