package com.facebook.register;

import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;


public class Level_13_Element_Undisplayed extends BaseTest {
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);

	}
    @Test
	public void TC_01_Verify_Element_Displayed() {
    	loginPage.clickToCreateNewAccountButton();
    	
    	//nếu 1 hàm chỉ mong đợi để verify element displayed thôi - kết hợp cả wait + isDisplayed
    	// waitForElementVisible 
    	//isElementDisplayed
    	
    	verifyTrue(loginPage.isEmailAddressTextboxDisplayed());  	
    	
	}
    @Test
   	public void TC_02_Verify_Element_Undisplayed() {
    	//nếu như mình mong đợi 1 hàm vừa verify displayed / undisplayed thì không được kết hợp  wait
    	    	//isElementDisplayed
    	
    	//verify True - mong đợi Confirm Email display (true)
    	loginPage.enterToEmailAddressTextbox("automationfc@gmail.com");
    	loginPage.sleepInSecond(3);
    	verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
  
    	// verify Failed - mong đợi Confirm Email Undisplay (false)
    	loginPage.enterToEmailAddressTextbox("");
    	loginPage.sleepInSecond(3);
    	//verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
    	
    	//case 2 : element có trong DOM nhưng không visible / displayed
    	verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
   	}
    @Test
   	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
    	loginPage.clickCloseIconAtRegisterForm();
    	loginPage.sleepInSecond(3);
    	// khi close cái form Register đi thì Confirm Email không còn trong DOM nữa
    	//nên hàm findElement sẽ bị fail vì không tìm thấy element
    	//1 - nó sẽ chờ hết timeout của implicit: 30s
    	//2 - nó sẽ đánh fail testcase tại đúng step này luôn
    	//3 - không có chạy các step còn lại nữa 
    	
    	//verify False - mong đợi Confirm Email Undisplayed (false)
    	//isDisplayed: bản chất không kiểm tra 1 element không có trong DOM
        //verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
    	
    	//case 3 : element không có trong DOM
    	verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
       	
   	}
   
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;


}
