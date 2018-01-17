package com.selenium.module62;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindFlightsUsingSingltonPatternTest {
	private static final String START_URL = "https://wizzair.com/";
	private static final String originCountry = "Belgium";
	private static final String originAirport = "Brussels Charleroi CRL";
	private static final String destinationCountry1 = "Germany";
	private static final String destinationResult = "There is no result for this search.! :(";
	private static final String destinationCountry2 = "Hungary";
	private static final String destinationAirport = "Budapest BUD";
	private static final String homePageText = "Explore your travel opportunities with WIZZ!";
	private static final String passengersCount ="1 adult 1 child";
	private static final String searchPageHeading ="SELECT FLIGHTS";
	public WebDriver driver;
	public WizzAirHomePage homePage;
	public WizzAirSearchPage searchPage;	

	@BeforeClass
	public void openBrowser() {
		driver=SingletonDriverManager.getWebDriverInstance();		
		driver.manage().window().maximize();
		driver.get(START_URL);
		homePage = new WizzAirHomePage(driver);
	}

	@Test(priority =0)
    public void addImplicitly() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homePage = new WizzAirHomePage(driver);
    }
    @Test(priority =1)
    public void verifyHomePage(){    
    	Assert.assertEquals(homePage.verifyHomePage(), homePageText, "Home page not opened Successfully");
    }
    @Test(priority =2)
    public void verifyOriginValue(){
    	Assert.assertEquals(homePage.originField(originCountry), originAirport,"Wrong Airport value taken" );
    }
    @Test(priority =3)
    public void verifyDestinationValueNegative(){
    	Assert.assertEquals(homePage.destinationFieldNegative(destinationCountry1), destinationResult, destinationCountry1+" Country had Airports");
    }
    @Test(priority =4)
    public void verifyDestinationValue(){
    	Assert.assertEquals(homePage.destinationField(destinationCountry2), destinationAirport, "Wrong Airport value taken for country "+destinationCountry2);
    }
    @Test(priority =5)
    public void selectDepartureDate(){
    	Assert.assertEquals(true, homePage.selectDepartureDate());
    }
    @Test(priority =6)
    public void selectReturnDate(){
    	Assert.assertEquals(true, homePage.selectReturnDate());
    }
    @Test(priority =7)
    public void verifyPassengers(){
    	Assert.assertEquals(homePage.selectPassengers(), passengersCount, "Wrong Passengers count ");
    }
    @Test(priority =8)
    public void verifySearchPage(){
    	Assert.assertEquals(homePage.performSearch().verifySearchPage(), searchPageHeading, "Search Page Not opened successfully ");
    }	
	
	@AfterClass
	public void afterClass() {
		SingletonDriverManager.closeWebBrowser();
	}
	
	
}
