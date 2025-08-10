package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.*;
import Utilities.*;

public class CheckoutTest extends BaseTest  {
	
	LoginPage loginPage;
	ProductPage productPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	WaitUtil wait;
	
	
	@BeforeMethod
	public void driverSetting() {
		
		loadConfig();
		driverSetup();
		wait = new WaitUtil(driver, Duration.ofSeconds(15));
				
	}
	
	@Test
	public void checkoutWithoutAddingItems() throws InterruptedException {
		
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		loginPage.Validlogin();
		checkoutPage.checkoutWithoutItems();	
		Thread.sleep(3000);
		
		
	}
	
	@Test
	public void checkoutAddingItems() {
		
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		loginPage.Validlogin();
		productPage.addMultipleItemsToCart();
		checkoutPage.checkoutAddingSomeItems();			
		
	}
	
	
	  @AfterMethod 
	  public void driverClose()
	  { 
		  closeDriver();
	  
	  }

}
