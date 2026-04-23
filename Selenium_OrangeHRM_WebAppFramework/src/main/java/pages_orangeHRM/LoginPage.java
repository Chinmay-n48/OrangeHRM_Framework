package pages_orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	
	public By UserNameField = By.name("username");
	public By PasswordField = By.name("password");
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
	public void Login (String user, String pass) {
		driver.findElement(UserNameField).sendKeys(user);
		driver.findElement(PasswordField).sendKeys(pass);
		
	}

}
