package com.selenium.module62;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Waiter{
	public static void hardWait(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void waitForElementClickable(WebDriver driver, int timeout, WebElement webElement) {
		new WebDriverWait(driver, timeout).pollingEvery(2, TimeUnit.SECONDS)
				.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public static void waitForElementPresent(WebDriver driver, int timeout, WebElement webElement) {
		new WebDriverWait(driver, timeout).pollingEvery(2, TimeUnit.SECONDS)
				.until(ExpectedConditions.visibilityOf(webElement));
	}
}
