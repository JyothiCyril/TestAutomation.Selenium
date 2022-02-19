package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonPages;

public class TestBase {
	WebDriver driver;
	AmazonPages AmazonOR;

	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setUp(String Browser, String Url) {
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Software\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(); // browser gets invoked.	
			
		}else if(Browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\Selenium Software\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		}else if(Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Selenium Software\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}else if(Browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium Software\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
				
		driver.get(Url);
		AmazonOR = new AmazonPages(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.close(); // browser instance gets closed

	}
	
	
	public void captureScreenshot(WebDriver driver, String tName) throws IOException {
		// take screenshot of the browser / driver
		// store in png format in Screenshots folder
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is captured");
		
	}

}
