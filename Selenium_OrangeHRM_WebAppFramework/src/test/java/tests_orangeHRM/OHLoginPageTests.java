package tests_orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ActionUtils;

import base_orangeHRM.OHBaseTest;
import pages_orangeHRM.OHLoginPage;

public class OHLoginPageTests extends OHBaseTest {
	
	OHLoginPage login;

	    @BeforeMethod
	    public void setupPage() {
	        login = new OHLoginPage(driver);
	    }

	    @Test
		//Verify login with valid credentials
		public void TC_OH_LoginPage_001()  {
			login.Login("Admin","admin123");
		}
}
