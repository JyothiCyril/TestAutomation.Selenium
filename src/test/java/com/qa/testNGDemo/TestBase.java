package com.qa.testNGDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	@BeforeClass
	public void Login() {
		System.out.println("Steps to Login");
	}
	
	@AfterClass
	public void Logout() {
		System.out.println("Steps to logout");
	}
	
	@BeforeTest
	public void setUp() {
		System.out.println("Invoke browser");
	}
	
	@AfterTest	
	public void tearDown() {
		System.out.println("Close the browser");
	}
	
	@BeforeMethod
	public void checkBalance() {
	System.out.println("Step to check the account balance");	
	}
	
	@AfterMethod
	public void acknowledgement() {
		System.out.println("Steps to print the transaction copy");
	}

}
