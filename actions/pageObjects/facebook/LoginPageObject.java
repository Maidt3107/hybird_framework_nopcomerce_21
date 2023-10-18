package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver= driver	;
		
		}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TETBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TETBOX);
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TETBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TETBOX, emailAddress);
		
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {		
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TETBOX);
	}

	public void clickCloseIconAtRegisterForm() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
		
	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {	
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TETBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TETBOX);
	}
}
