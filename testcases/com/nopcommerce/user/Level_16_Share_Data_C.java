package com.nopcommerce.user;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;
import com.nopcommerce.common.Common_01_Register_End_Uer;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_16_Share_Data_C extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_01_Register_End_Uer.emailAddress;
		validpassword = Common_01_Register_End_Uer.password;

		log.info("Pre.Condition - Step 01: Navigate to Logout link");
		loginPage = homePage.openLoginPage();

		log.info("Pre.Condition - Step 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);

		loginPage.refreshCurrentPage(driver);
		
		log.info("Pre.Condition - Step 05: Verify 'My Account' link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());		
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
	private UserLoginPageObject loginPage;
	private String  emailAddress, validpassword;

}
