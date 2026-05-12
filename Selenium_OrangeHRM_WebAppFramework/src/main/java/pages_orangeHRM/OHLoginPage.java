package pages_orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OHLoginPage {
	WebDriver driver;
	
	public By UsernameField=By.xpath("//input[@name='username']");
	public By PasswordField=By.xpath("//input[@name='password']");
	public By LoginBTN=By.xpath("//button[@type='submit']");
	public By UNFValidationMsg=By.xpath("(//div//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[1]");
	public By PFValidationMsg=By.xpath("(//div//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[2]");
	public By ErrorMsg=By.xpath("//div[@role='alert']");
	public By ForgotPassWodBTN=By.xpath("//div[@class='orangehrm-login-forgot']");
	 
	public OHLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
	public void Login (String UserName, String PassWord) {
		driver.findElement(UsernameField).sendKeys(UserName);
		driver.findElement(PasswordField).sendKeys(PassWord);
		driver.findElement(LoginBTN).click();
		
	}

}
