package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory  {
	
	 private static WebDriver driver;

	    public static WebDriver getDriver() {
	        if (driver == null) {
	            String browser = ConfigReader.getBrowser();
	            System.out.println("Launching browser: " + browser);

	            if ("chrome".equalsIgnoreCase(browser)) {
	                driver = new ChromeDriver();
	                driver.manage().window().maximize();
	            } else {
	                throw new RuntimeException("Unsupported browser: " + browser);
	            }
	        }
	        return driver;
	    }

	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
}



