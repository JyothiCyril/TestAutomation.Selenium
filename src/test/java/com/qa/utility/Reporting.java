package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports xReports;
	public ExtentTest xTest;


	// LOC for the configuration of extent reporting will be performed at the start of test suite execution.
	// 1. Create a brand new HTML file in the reports folder --> Type / location / Filename
	// 2. HTML file should be casted as Extent Report

	public void onStart(ITestContext testContext) {
		String dateStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Automation-Report" + dateStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+repName);
		htmlReporter.config().setDocumentTitle("Automation report");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);

		xReports = new ExtentReports();
		xReports.attachReporter(htmlReporter);
		xReports.setSystemInfo("QA Name", "JyothiCyril");
		xReports.setSystemInfo("hostName", "localhost");
		xReports.setSystemInfo("OS", "WINDOWS");	  


	}


	public void onFinish(ITestContext testContext) {		  
		xReports.flush();
	}

	// method to read / listen the results of @Test methods 
	// make an entry into the HTML report of type extent.


	public void onTestSuccess(ITestResult tr) {		  
		xTest =  xReports.createTest(tr.getName());
		xTest.log(Status.PASS, "Test is passed");
		xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));	   
	}


	public void onTestFailure(ITestResult tr) {
		xTest =  xReports.createTest(tr.getName());
		xTest.log(Status.FAIL, "Test is failed");
		xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		xTest.log(Status.FAIL, tr.getThrowable());
		
		String SSPath = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png" ; 
		
		File file = new File(SSPath);
		
		if(file.exists()) {
			try {
				xTest.fail("Screenshot for test failed is : " +  xTest.addScreenCaptureFromPath(SSPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	public void onTestSkipped(ITestResult tr) {

		xTest =  xReports.createTest(tr.getName());
		xTest.log(Status.SKIP, "Test is skipped");
		xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));	   
	}

}
