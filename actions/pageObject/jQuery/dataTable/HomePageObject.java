package pageObject.jQuery.dataTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);

	}

	public void enterToHederTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);

	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	
	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size = " + totalPage);

		List<String> allRowValuesAllPage = new ArrayList<String>();
		
		//nếu muốn không lưu trùng dữ liệu thì dùng Set
		Set<String> allRowValueUniqueAllPage = new HashSet<String>();

		//duyệt qua tất cả các page number (paging)
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			
			// get text của all row mỗi page đưa vào ArrayList
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW__COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValuesAllPage.add(eachRow.getText());			
				
			}

		}
		//in tất cả các giá trị row ra - tất cả các page
		for(String value : allRowValuesAllPage) {
			System.out.println(value);
		}
		return allRowValuesAllPage;

	}

	public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSend) {
		int columnIndex = getElementSize(driver,HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName) + 1;
		
		waitForElementVisible(driver,  HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_COLUMN_INDEX, rowIndex,String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_COLUMN_INDEX, valueToSend, rowIndex.valueOf(columnIndex));
		
	}

	public void selectDropdownByColumnNameAndIndex(String columnName, String rowIndex, String dropdpwnItem) {
		int columnIndex = getElementSize(driver,HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName) + 1;
		
		waitForElementClickable(driver,HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_COLUMN_INDEX, rowIndex,String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_COLUMN_INDEX, rowIndex,String.valueOf(columnIndex));
		
	}

	public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
		int columnIndex = getElementSize(driver,HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName) + 1;
		waitForElementClickable(driver,HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_COLUMN_INDEX, rowIndex,String.valueOf(columnIndex));
		
		checkToElement(driver,HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_COLUMN_INDEX, rowIndex,String.valueOf(columnIndex));
		
	}

	

}
