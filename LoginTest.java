package TestCases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.*;




public class LoginTest extends BaseTest {
	
	LoginPage loginPage;
	
	
	@BeforeMethod
	public void driverSetting() {
		
		loadConfig();
		driverSetup();
		
				
	}
	@Test
	public void validLoginTest(){
		loginPage = new LoginPage(driver);
		loginPage.Validlogin();	
		
	}
	
	@Test
	public void blankLoginTest(){
		loginPage = new LoginPage(driver);
		loginPage.blankLogin();
		
	}
	
	  @AfterMethod
	  public void driverClose()
	  { 
		  closeDriver();
		  
	  }
	 

}
