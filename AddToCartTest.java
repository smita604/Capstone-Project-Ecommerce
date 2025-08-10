package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.*;
import Utilities.*;

public class AddToCartTest extends BaseTest {
	
	LoginPage loginPage;
	ProductPage productPage;
	CartPage cartPage;
	WaitUtil wait;
	
	@BeforeMethod
	public void driverSetting() {
		
		loadConfig();
		driverSetup();
		
				
	}
	@Test
	public void addSingleItemToCartAndVerify() throws InterruptedException {
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		loginPage.Validlogin();
		productPage.addSingleItemToCartAndVerify();
		
	}
	
	@Test
	public void addMultipleToCart() {
		
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		loginPage.Validlogin();
		productPage.addMultipleItemsToCart();
		
		
	}
	@Test
	public void getCartCount() {
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
		loginPage.Validlogin();
		productPage.addMultipleItemsToCart();		
		cartPage.getCartCount();
	}
	@Test
	public void removeItemsFromCart() throws InterruptedException {
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
		loginPage.Validlogin();
		productPage.addMultipleItemsToCart();
		Thread.sleep(3000);
		cartPage.removeItemFromCart();
		Thread.sleep(3000);		
	}
	
	
	  @AfterMethod
	  public void driverClose()
	  { 
		  closeDriver();
	  
	  }
	 
	
	

}
