package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	
	WebDriver driver;
	
	/*
	@FindBy(locator="value")
	WebElement ref_name;
	
	methods that returns the elements{}

*/
	
	@FindBy(id="searchDropdownBox")
	WebElement Category;
	
	public Select getCategory() {
		Select cat = new Select(Category);
		return cat;
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTxtField;
	
	public WebElement getsearchTxtField() {
		return searchTxtField;
	}
	
	@FindBy(id="nav-search-submit-button")
	WebElement MagnifierBtn;
	
	public WebElement getMagnifierBtn() {
		return MagnifierBtn;
	}
	
	@FindBy(id="nav-link-accountList")
	WebElement AccountsandList;
	
	public WebElement getAccountsandList() {
		return AccountsandList;
	}
	
	@FindBy(linkText="Start here.")
	WebElement startHereLnk;
	
	public WebElement getstartHereLnk() {
		return startHereLnk;
	}
	
	@FindAll(@FindBy(className="nav_a"))
	List<WebElement> footerLnks;
	
	public List<WebElement> getfooterLnks(){
		return footerLnks;
	}
	
	@FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']"))
	List<WebElement> AllItems;
	
	public List<WebElement> getAllItems(){
		return AllItems;
	}
	
	public AmazonPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
}
