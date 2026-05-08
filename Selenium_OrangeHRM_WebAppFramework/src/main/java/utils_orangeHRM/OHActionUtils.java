package utils_orangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OHActionUtils {
	
WebDriver driver;
	
	public static void click(WebDriver driver, WebElement element) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.click();
	    } catch (Exception e) {
	        System.out.println("Click failed: " + e.getMessage());
	    }
	}
	    
	public static boolean isDisplayed(WebDriver driver, By locator) {

	    try {
	        return driver.findElement(locator).isDisplayed();
	    } 
	    catch (Exception e) {
	        return false;
	    }
	}
	    
	    
}
