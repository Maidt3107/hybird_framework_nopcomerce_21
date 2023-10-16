package com.jquery;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObject.jQuery.dataTable.HomePageObject;
import pageObject.jQuery.dataTable.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_10_DataTable_DataGrid extends BaseTest {
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expecttedAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

	}
	@Test
	public void Table_01() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));

		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("7"));

		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("18"));
	}
	@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.enterToHederTextboxByLabel("Country", "Argentina");
		homePage.enterToHederTextboxByLabel("Females", "338282");
		homePage.enterToHederTextboxByLabel("Males", "349238");
		homePage.enterToHederTextboxByLabel("Total", "687522");
		homePage.sleepInSecond(3);

		homePage.enterToHederTextboxByLabel("Country", "Angola");
		homePage.enterToHederTextboxByLabel("Females", "276880");
		homePage.enterToHederTextboxByLabel("Males", "276472");
		homePage.enterToHederTextboxByLabel("Total", "553353");
		homePage.sleepInSecond(3);

	}

	@Test
	public void Table_03_Enter_To_Header() {
		//đọc dữ liệu của file country.txt ra
		//lưu vào 1 List<String> = Expected Value = expectedAllCountryValues
		
		
		// Actual Value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		
	}
	
	@Test
	public void Table_04_Action_By_Index() { // class 27 topic 73
	
		homePage.openPageURL(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		//nhập vào textbox tại cột Contact Person dòng thứ 2
		homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person","2","Oliver Lahl");
		homePage.enterToTextboxByColumnNameAndRowIndex("Company","1","Bayer Munich");
		
		// select dữ liệu tại cột country dòng thứ 3 
		homePage.selectDropdownByColumnNameAndIndex("Country","3","United Kingdom");
		homePage.selectDropdownByColumnNameAndIndex("Country","1","Japan");
		
		// click vào checkbox tại cột NPO? dòng thứ 1
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?","3");
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?","2");
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?","1");
	
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
