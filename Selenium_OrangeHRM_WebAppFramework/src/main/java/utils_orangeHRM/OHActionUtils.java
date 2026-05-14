package utils_orangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OHActionUtils {
	
WebDriver driver;
	
	public static void click(WebDriver driver, By locator) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(locator));
	        driver.findElement(locator).click();
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
	
	public static boolean isEnabled(WebDriver driver, By locator) {
		try {
			return driver.findElement(locator).isEnabled();
		}
		catch(Exception e){
			return false;
		}
	}
	
	public static String getText(WebDriver driver, By locator) {
		try {
			
		return driver.findElement(locator).getText();
	}
		catch(Exception e){
			 System.out.println("Failed to get text: " + e.getMessage());
		        return "text not extracted";		
		}
	}
	
	public static void SelectByValueOptionDD(WebDriver driver, By options, By locator, String Value) {			
		try {
			WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Click dropdown
	        wait.until(
	                ExpectedConditions.elementToBeClickable(locator))
	                .click();

	        // Wait for options
	        wait.until(
	                ExpectedConditions.visibilityOfAllElementsLocatedBy(options));

	        List<WebElement> allOptions =
	                driver.findElements(options);

	        for (WebElement option : allOptions) {

	            String actualValue =
	                    option.getText().trim();

	            if (actualValue.equalsIgnoreCase(Value.trim())) {

	                wait.until(
	                        ExpectedConditions.elementToBeClickable(option));

	                option.click();

	                System.out.println("Clicked: " + actualValue);

	                return;
		        }
		    }	
		    System.out.println("Dropdown value selected");
		}
		catch(Exception e) {
	        	 System.out.println("Unable to select dropdown value");
	             e.printStackTrace();	        
		}
		
	}
}
