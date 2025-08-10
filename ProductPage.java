package Pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ConfigReader;
import Utilities.WaitUtil;

public class ProductPage {

	@FindBy(css= ".shelf-item__title") List<WebElement> products;
	@FindBy(css= "div[class='shelf-item__buy-btn']") List<WebElement> buttons;
	@FindBy(xpath = "//p[text()='iPhone 12']") WebElement product1;
	@FindBy(xpath= "//p[@class='title' and text()='iPhone 12']") WebElement productTitleInCart;
	

	WebDriver driver;
	WaitUtil wait;


	public ProductPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WaitUtil(driver, Duration.ofSeconds(50));
		PageFactory.initElements(driver, this);
	}
	
	public void addSingleItemToCartAndVerify() throws InterruptedException {
		
				
				buttons.get(0).click();
				Thread.sleep(3000);
				String name = product1.getText();
				String title= wait.waitForElementVisible(product1).getText();
				Assert.assertEquals(title, name, "Products doesn't match");
				System.out.println(name+ " added successfully");
				System.out.println("Both titles "+name+ " and " +title+" matches");
				
			}
		
	


	public void addMultipleItemsToCart() {
		List<String> productsToAdd = ConfigReader.getProducts();

		for (int i=0; i<products.size();i++) {

			String name = products.get(i).getText();
			if(productsToAdd.contains(name)) {
				WebElement addToCartBtn = buttons.get(i);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
				//addToCartBtn.click();
				System.out.println(name+ " is added to cart: ");
			}
		}
	}

}

