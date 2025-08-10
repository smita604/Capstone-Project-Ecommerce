package Pages;

import Utilities.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WaitUtil wait;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtil(driver, Duration.ofSeconds(50));
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "signin")
	WebElement signin;
	@FindBy(xpath = "//div[contains(@class,'css-1wa3eu0-placeholder') and normalize-space() = 'Select Username']")
	WebElement login_id;
	@FindBy(xpath = "//div[text()='demouser']")
	WebElement Valid_login_id;
	@FindBy(xpath = "//div[contains(@class,' css-1wa3eu0-placeholder') and normalize-space() = 'Select Password']")
	WebElement login_password;
	@FindBy(xpath = "//div[text()='testingisfun99']")
	WebElement valid_password;
	@FindBy(css = "button[id='login-btn']")
	WebElement login_submit;
	@FindBy(xpath = "//span[text()='demouser']")
	WebElement usernameDisplay;
	@FindBy (xpath= "//h3[text()='Invalid Username']")
	WebElement errorMessage;

	public void Validlogin() {
		signin.click();

		
		  wait.waitForPageLoad();
		  
		  WebElement username = wait.waitForElementClickable(login_id);
		  username.click();
		  WebElement usernameOption = wait.waitForElementVisible(Valid_login_id);
		  usernameOption.click();
		  WebElement password = wait.waitForElementClickable(login_password); 
		  password.click(); 
		  WebElement passwordOption = wait.waitForElementVisible(valid_password);			  
		  passwordOption.click();		 
		wait.waitForElementClickable(login_submit).click();
		wait.waitForPageLoad();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		wait.waitForElementVisible(usernameDisplay);
		System.out.println("User logged in successfully");
	}
	
	public void blankLogin() {
		signin.click();		
		wait.waitForPageLoad();	  
		wait.waitForElementClickable(login_submit).click();
		wait.waitForElementVisible(errorMessage);
		System.out.println("Blank Login");
	}

	/*
	 * public void Invalidlogin() throws InterruptedException { signin.click();
	 * Thread.sleep(5000); //waitUtil.waitForPageLoad();
	 * login_id.sendKeys(ConfigReader.getInvalidUsername());
	 * login_password.sendKeys(ConfigReader.getInvalidPassword());
	 * login_submit.click(); }
	 */

}
