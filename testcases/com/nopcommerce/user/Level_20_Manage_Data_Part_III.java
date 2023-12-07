package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommrce.data.UserData;

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
import utilities.DataHelper;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_20_Manage_Data_Part_III extends BaseTest {

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = UserData.Register.EMAIL_ADDRESS + generateFakeNumber() + "@fakemail.com";

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioButtonByLabel(driver,"Female");
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + UserData.Register.FIRST_NAME  + "'");
		registerPage.inpuToTextboxByID(driver,"FirstName",UserData.Register.FIRST_NAME);
		
		log.info("Register - Step 03: Enter to LastName textbox with value is '" + UserData.Register.LAST_NAME  + "'");
		registerPage.inpuToTextboxByID(driver,"LastName",UserData.Register.LAST_NAME );
		
		registerPage.selectToDropdownByName(driver,"DateOfBirthDay",UserData.Register.DATE);
		registerPage.selectToDropdownByName(driver,"DateOfBirthMonth",UserData.Register.MONTH);
		registerPage.selectToDropdownByName(driver,"DateOfBirthYear",UserData.Register.YEAR);

		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAddress  + "'");
		registerPage.inpuToTextboxByID(driver,"Email",emailAddress);
		
		registerPage.clickToCheckboxButtonByLabel(driver,"Newsletter");

		log.info("Register - Step 05: Enter to Password textbox with value is '" + UserData.Register.PASSWORD  + "'");
		registerPage.inpuToTextboxByID(driver,"Password",UserData.Register.PASSWORD);

		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + UserData.Register.PASSWORD  + "'");
		registerPage.inpuToTextboxByID(driver,"ConfirmPassword",UserData.Register.PASSWORD);
		
		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		registerPage.clickToButtonByText(driver,"Register");
		
		log.info("Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
		
	} 
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Logout page");
		homePage = registerPage.clickToLoginLink();
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAddress  + "'");
		loginPage.inpuToTextboxByID(driver,"Email",emailAddress);
		
		log.info("Login - Step 03: Enter to Password textbox with value is '" + emailAddress  + "'");
		loginPage.inpuToTextboxByID(driver,"Password",emailAddress);

		log.info("Login - Step 04: Click to Logout link");
		loginPage.clickToButtonByText(driver,"Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Login - Step 05: Verify 'My Account' link displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	}

	@Test
	public void User_03_My_Account() {
		log.info("My Account - Step 01: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage();
		
		log.info("My Account - Step 02: Verify  'Customer Infor' page is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
		
		log.info("My Account - Step 03: Verify  'First Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"FirstName"), UserData.Register.FIRST_NAME);
		
		log.info("My Account - Step 04: Verify  'Last Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"LastName"), UserData.Register.LAST_NAME);
		
		log.info("My Account - Step 05: Verify  'Email' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"Email"), emailAddress);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private String   emailAddress;

}
