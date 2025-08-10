package Pages;

import java.time.Duration;
import Pages.*;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtil;

public class CartPage {
	
	int count;
	WebDriver driver;
	WaitUtil wait;


	public CartPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WaitUtil(driver, Duration.ofSeconds(50));
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css= ".bag__quantity") WebElement CartCount;
	@FindBy(css= ".shelf-item__del") List<WebElement> delButtons;
	
	public void getCartCount() {
		
		count = Integer.parseInt(CartCount.getText());
		System.out.println("Total number of items in the cart = "+count);
	}
	
	public void removeItemFromCart() {
		
		for(WebElement removeBtn : delButtons) {
			
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeBtn);
			
		}
		
		System.out.println("All items are removed successfully");
	}

}
