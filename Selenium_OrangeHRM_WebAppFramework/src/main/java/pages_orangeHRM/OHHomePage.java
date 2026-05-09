package pages_orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OHHomePage {
	WebDriver driver;
	
	public By PageTitle=By.xpath("//span//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
	
	public OHHomePage(WebDriver driver) {
        this.driver = driver;
    }

}
