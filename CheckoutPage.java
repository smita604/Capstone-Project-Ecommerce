package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.*;

public class CheckoutPage {
	@FindBy(css=".shelf-empty") WebElement emptyCart;
	@FindBy(css= ".bag.bag--float-cart-closed") WebElement Cart;
	@FindBy(css= ".buy-btn") WebElement CheckoutButton;
	@FindBy(id= "firstNameInput") WebElement FirstName;
	@FindBy(id= "lastNameInput") WebElement LastName;
	@FindBy(id= "addressLine1Input") WebElement address;
	@FindBy(id= "provinceInput") WebElement State;
	@FindBy(id= "postCodeInput") WebElement PostalCode;
	@FindBy(id= "checkout-shipping-continue") WebElement Submit;
	@FindBy(id="confirmation-message") WebElement message;
	
	WebDriver driver;
	WaitUtil wait;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		wait = new WaitUtil(driver, Duration.ofSeconds(50));
		this.wait= wait;
		PageFactory.initElements(driver, this);
	}
	
	public void checkoutWithoutItems() {
		
		wait.waitForElementClickable(Cart).click();
		//Cart.click();
		String Message = wait.waitForElementVisible(emptyCart).getText();
		System.out.println("user should get "+Message+" message.");			
		
	}
	
	public void checkoutAddingSomeItems() {
		wait.waitForElementClickable(CheckoutButton).click();	
		wait.waitForElementVisible(FirstName).sendKeys(ConfigReader.getFirstName());
		wait.waitForElementVisible(LastName).sendKeys(ConfigReader.getLastName());
		wait.waitForElementVisible(address).sendKeys(ConfigReader.getAddress());
		wait.waitForElementVisible(State).sendKeys(ConfigReader.getState());
		wait.waitForElementVisible(PostalCode).sendKeys(ConfigReader.getPostalCode());
		wait.waitForElementClickable(Submit).click();
		wait.waitForPageLoad();
		wait.waitForElementVisible(message);
		String Message = message.getText();
		System.out.println("User should get "+Message+" message");
	}
	
	

}
