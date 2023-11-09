package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_14_Log_ReportNG extends BaseTest {

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
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName  + "'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Register - Step 03: Enter to LastName textbox with value is '" + lastName  + "'");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAddress  + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Register - Step 05: Enter to Password textbox with value is '" + validpassword  + "'");
		registerPage.inputToPasswordTextbox(validpassword);
		
		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + validpassword  + "'");
		registerPage.inputToConfirmPasswordTextbox(validpassword);
		
		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 08: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");

		log.info("Register - Step 09: Click to Logout link");
		homePage = registerPage.clickToLoginLink();

		

	}
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Logout link");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAddress  + "'");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Login - Step 03: Enter to Password textbox with value is '" + emailAddress  + "'");
		loginPage.inputToPasswordTextbox(validpassword);

		log.info("Login - Step 04: Click to Logout link");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: Verify 'My Account' link displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage();
		
		log.info("Login - Step 07: Verify  'Customer Infor' page is displayed");
		verifyFalse(customerInforPage.isCustomerInforPageDisplayed());
		
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
