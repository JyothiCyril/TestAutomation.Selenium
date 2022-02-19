package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_002 extends TestBase{
	
	
	@Test
	public void registration() throws IOException {
		
		WebElement ele = AmazonOR.getAccountsandList();
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		
		AmazonOR.getstartHereLnk().click();
		
		boolean contains = driver.getTitle().contains("Registration");
		if(contains) {
			Reporter.log("User is navigated to registration page",true);
			Assert.assertTrue(contains);
		}else {
			captureScreenshot(driver,"registration");
			Reporter.log("User is not navigated to registration page",true);
			Assert.assertTrue(contains);
		}
		
	}

}
