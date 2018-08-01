package org.automation.reddit.base;

import org.automation.reddit.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance {
	public WebDriver driver ;
	
	@BeforeMethod
	public void initiateDriverInstance() throws Exception
	{
		if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
			driver = new ChromeDriver();
		}
		else if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver");
			driver = new ChromeDriver();
		}
		else 
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
			driver = new ChromeDriver();
		}
		
		driver.get(Utility.fetchPropertyValue("applicationURL").toString());
	}
	@AfterMethod
	public void closeDriverInstance()
	{
		driver.quit();
	}
}
