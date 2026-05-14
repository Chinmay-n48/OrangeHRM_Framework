package pages_orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils_orangeHRM.OHActionUtils;

public class OHHomePage {
	WebDriver driver;
	OHActionUtils action;
	
	public By PageTitle=By.xpath("//span//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
	public By UserProfileDD=By.xpath("//li//span[@class='oxd-userdropdown-tab']");
	public By UserProfileDDOptions=By.xpath("//ul[@role='menu']");
	
	public OHHomePage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void LogOut() {
		action.SelectByValueOptionDD(driver, UserProfileDDOptions , UserProfileDD, "About");		
	}

}
