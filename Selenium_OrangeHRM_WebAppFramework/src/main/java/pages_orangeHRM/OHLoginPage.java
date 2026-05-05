package pages_orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OHLoginPage {
	WebDriver driver;
	
	public By UsernameField=By.xpath("//input[@name='username']");
	public By PasswordField=By.xpath("//input[@name='password']");
	public By LoginBTN=By.xpath("//button[@type='submit']");
	 
	public OHLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
	public void Login (String UserName, String PassWord) {
		driver.findElement(UsernameField).sendKeys(UserName);
		driver.findElement(PasswordField).sendKeys(PassWord);
		driver.findElement(LoginBTN).click();
		
	}

}
