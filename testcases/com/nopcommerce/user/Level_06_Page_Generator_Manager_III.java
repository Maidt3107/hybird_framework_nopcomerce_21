package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager_III extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		invalidEmail = "afc@afc.com@.vn";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
		validpassword = "123456";
		incorrectPassword = "654321";

		System.out.println("Pre-Condition -Step 01 : Click to Register link ");
		registerPage = homePage.openRegisterPage();

		// 2
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Pre-Condition -Step 02 : Input to required fields ");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validpassword);
		registerPage.inputToConfirmPasswordTextbox(validpassword);

		System.out.println("Pre-Condition -Step 03 : Click to Register button ");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition -Step 04 : Verify success message displaed ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-Condition -Step 05 : Click to Logout link ");
		homePage = registerPage.clickToLoginLink();

	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Empty_Data -Step 01 : Click to Login  link ");
		loginPage = homePage.openLoginPage();

		System.out.println("Login_01_Empty_Data -Step 02 : Click to Login  button ");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnSuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnSuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnSuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Valid_Email_Password() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validpassword);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		myAccountPage = homePage.openMyAccountPage();

		myAccountPage.clickToNewsletterCheckbox();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject myAccountPage;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validpassword, incorrectPassword;

}
