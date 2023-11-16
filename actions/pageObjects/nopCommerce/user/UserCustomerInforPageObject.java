package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.nopcommerce.user.CustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

	public void clickToNewsletterCheckbox() {
		// TODO Auto-generated method stub

	}


}
