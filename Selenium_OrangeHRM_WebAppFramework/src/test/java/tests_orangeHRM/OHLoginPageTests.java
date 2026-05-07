package tests_orangeHRM;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ActionUtils;

import base_orangeHRM.OHBaseTest;
import pages_orangeHRM.OHLoginPage;
import utils_orangeHRM.OHActionUtils;

public class OHLoginPageTests extends OHBaseTest {
	
	OHLoginPage login;
	OHActionUtils action;

	    @BeforeMethod
	    public void setupPage() {
	        login = new OHLoginPage(driver);
	    }

	    @Test
		//Verify login page loads successfully
		public void TC_Login_UI_001()  {
			//login.Login("Admin","admin123");
			String urlText= driver.getCurrentUrl();
			System.out.println(urlText);
			Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", urlText, "Url is not Matched");
			boolean b=action.isDisplayed(driver, login.UsernameField);
            Assert.assertTrue(b , "Username Field is not available");
            
	    }
}
