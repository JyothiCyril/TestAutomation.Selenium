package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_003 extends TestBase{

	@Test
	public void ValidateFooterLinks() {
		List<WebElement> AllLinks = AmazonOR.getfooterLnks();
		
		int count =  AllLinks.size();
		
		Assert.assertEquals(count, 50);
		
		System.out.println("Total no. of links present on the footer page are : " + count);
		
		for(WebElement link:AllLinks) {
			Reporter.log(link.getText(),true);
		}
		
		
	}
}
