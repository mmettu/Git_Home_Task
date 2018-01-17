package com.selenium.module62;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WizzAirSearchPage extends BasePage {

	 @FindBy(xpath="//h2[@class='booking-flow__step__title heading heading--1' and text()='Select flights']")
	    private WebElement searchPageHeading;
	    
		public WizzAirSearchPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		public String verifySearchPage(){
			Waiter.hardWait(3000);
			System.out.println("Search Page Opened Successfully");
			return searchPageHeading.getText();		
		}
	
}
