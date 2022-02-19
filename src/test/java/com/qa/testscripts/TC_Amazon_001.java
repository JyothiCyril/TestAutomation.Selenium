package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utility.ExcelUtility;

public class TC_Amazon_001 extends TestBase{
	
	// @Test:  method below @Test annotation is called as Test case
	
	@Test(dataProvider="getData")
	public void searchItem(String Category, String ItemName) throws IOException {	
		SoftAssert sAssert = new SoftAssert();
		
		AmazonOR.getsearchTxtField().clear();
		AmazonOR.getCategory().selectByVisibleText(Category);		
		AmazonOR.getsearchTxtField().sendKeys(ItemName);
		AmazonOR.getMagnifierBtn().click();
				
		String title = driver.getTitle();
		boolean content = title.contains(ItemName);
		
		if(content) {
		//	Assert.assertTrue(content);
			sAssert.assertTrue(content);
			Reporter.log("Item is searched, the title has " + ItemName,true);
		}else {
			captureScreenshot(driver,"searchItem");
			//Assert.assertTrue(content);
			sAssert.assertTrue(content);
			Reporter.log("Title is not same item name " + title, true);
		}
		
		List<WebElement> allItems = AmazonOR.getAllItems();
		System.out.println("Total no. of items loaded are : " + allItems.size());
		for(WebElement item:allItems) {
			Reporter.log(item.getText(),true);
		}
		
		sAssert.assertAll();
				
	}
	
	// Source the inputs to another method @Test
	@DataProvider
	public String[][] getData() throws IOException{
		String xFile = "D:\\Devlabs\\Global- Batch 1\\Selenium\\TestAutomation.Selenium\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String xSheetName = "Sheet1";
		
		int rowCount = ExcelUtility.getRowCount(xFile, xSheetName);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheetName, rowCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount;i++) {
			for(int j=0; j<cellCount;j++) {
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheetName, i, j);
			}
		}
		
		/*
		Object[][] data = new Object[3][2];
		// Category field
		data[0][0] = "Books" ;
		data[1][0] = "Electronics" ;
		data[2][0] = "Appliances" ;
		
		// Item name
		
		data[0][1] = "Da Vinci Code";
		data[1][1] = "Mobile phones";
		data[2][1] = "Washing Machines";
		
		*/
		return data;
		
	}

}
