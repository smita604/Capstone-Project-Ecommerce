package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {	
    
	
	WebDriver driver;
    Duration timeout;
    WebDriverWait wait;

    public WaitUtil(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
        this.wait = new WebDriverWait(driver, timeout);
    }

    // ✅ Wait for visibility of element
    public WebElement waitForElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ✅ Wait for element to be clickable
    public WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
   

    // ✅ Wait for full page load (sets a timeout)
    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }


}
