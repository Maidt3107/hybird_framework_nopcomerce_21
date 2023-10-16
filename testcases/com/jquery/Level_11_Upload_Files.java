package com.jquery;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObject.jQuery.uploadFile.HomePageObject;
import pageObject.jQuery.uploadFile.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_11_Upload_Files extends BaseTest {
	String csharpFileName = "CSharp.png";
	String javaFileName = "Java.png";
	String rubyFileName = "Ruby.png";
	String[] multipleFilesNames = {csharpFileName,javaFileName,rubyFileName};

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

	}
    @Test
	public void Upload_01_One_File_Per_Time() {
    	//Step 01: Load single file
    	homePage.uploadMultipleFiles(driver, csharpFileName);
    	
    	// Step 02: verify single file loaded success
    	Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
    	
    	//step 03: click to start button 
    	homePage.clickToStartButton();
    	
    	//step 04: verify single file link uploaded success
    	Assert.assertTrue(homePage.isFileLinkUpLoadedByName(csharpFileName));
    	
    	//step 05:verify single file image uploaded success
    	Assert.assertTrue(homePage.isFileImageUpLoadedByName(csharpFileName));
	}
    @Test
   	public void Upload_02_Multiple_File_Per_Time() {
    	homePage.refreshCurrentPage(driver);
    	//Step 01: Load Multiple file
    	homePage.uploadMultipleFiles(driver, multipleFilesNames);
    	
    	// Step 02: verify Multiple file loaded success
       	Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
    	Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
    	Assert.assertTrue(homePage.isFileLoadedByName(rubyFileName));

    	
    	//step 03: click to start button 
    	homePage.clickToStartButton();
    	
    	//step 04: verify Multiple file link uploaded success
    	Assert.assertTrue(homePage.isFileLinkUpLoadedByName(csharpFileName));
    	Assert.assertTrue(homePage.isFileLinkUpLoadedByName(javaFileName));
    	Assert.assertTrue(homePage.isFileLinkUpLoadedByName(rubyFileName));

    	
    	//step 05:verify Multiple file image uploaded success
    	Assert.assertTrue(homePage.isFileImageUpLoadedByName(csharpFileName));
    	Assert.assertTrue(homePage.isFileImageUpLoadedByName(javaFileName));
    	Assert.assertTrue(homePage.isFileImageUpLoadedByName(rubyFileName));

   	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;

}
