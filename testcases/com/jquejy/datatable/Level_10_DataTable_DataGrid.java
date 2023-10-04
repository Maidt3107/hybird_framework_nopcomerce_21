package com.jquejy.datatable;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;

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
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
