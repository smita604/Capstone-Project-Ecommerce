package TestCases;

import org.openqa.selenium.WebDriver;

import Utilities.*;

public class BaseTest {
	
	static WebDriver driver;
	
	
	//Initializes driver and gets the URL
	public static void driverSetup() 
	{
	
		 driver = WebDriverFactory.getDriver();
		 driver.get(ConfigReader.getBaseUrl());
	     
	}
	
	//laods the config file
	public static void loadConfig() 
	{
		
		ConfigReader.loadProperties();
		
	}
	//closes the driver
	public static void closeDriver() 
	{
		
		WebDriverFactory.quitDriver();
	}
}
