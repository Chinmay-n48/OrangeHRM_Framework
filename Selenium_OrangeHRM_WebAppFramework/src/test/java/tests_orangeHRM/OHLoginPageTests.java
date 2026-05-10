package tests_orangeHRM;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_orangeHRM.OHBaseTest;
import pages_orangeHRM.OHHomePage;
import pages_orangeHRM.OHLoginPage;
import utils_orangeHRM.OHActionUtils;
import utils_orangeHRM.OHWaitUtils;

public class OHLoginPageTests extends OHBaseTest {
	
	OHLoginPage login;
	OHActionUtils action;
	OHWaitUtils wait;
	OHHomePage HomePage;

    @BeforeMethod
    public void setupPage() {
        login = new OHLoginPage(driver);
        action = new OHActionUtils();
        wait = new OHWaitUtils(driver);
        HomePage=new OHHomePage(driver);
    }

	    @Test
		//Verify login page loads successfully
		public void TC_LoginPage_001()  {
			String urlText= driver.getCurrentUrl();
			System.out.println(urlText);
			Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", urlText, "Url is not Matched");
			wait.waitForVisibility(login.UsernameField, 20);
            Assert.assertTrue(action.isDisplayed(driver, login.UsernameField), "Username Field is not available");  
            Assert.assertTrue(action.isDisplayed(driver, login.PasswordField), "Password Field is not available");
            Assert.assertTrue(action.isDisplayed(driver, login.LoginBTN),"Submit button is not available");
            Assert.assertTrue(action.isDisplayed(driver, login.ForgotPassword), "ForgotPassowrd Link is not available");
	    }
	    
	    @Test
	    //Verify Username textbox visibility and functionality
	    public void TC_LoginPage_002() throws InterruptedException {
	    wait.waitForVisibility(login.UsernameField, 20);
	    Assert.assertTrue(action.isDisplayed(driver, login.UsernameField), "UsernameField is available");
	    Assert.assertTrue(action.isEnabled(driver, login.PasswordField), "Usernamefield is not enabled");
	    driver.findElement(login.UsernameField).sendKeys("Admin");
	    Thread.sleep(3000);	    	
	    }
	    
	    @Test
	    //Verify Password textbox visibility and masking behavior
	    public void TC_LoginPage_003() {
	    	wait.waitForVisibility(login.PasswordField, 20);
	    	Assert.assertTrue(action.isDisplayed(driver, login.ForgotPassword), "PassWordField is not available");
	    	Assert.assertTrue(action.isEnabled(driver, login.PasswordField), "Passwordfield is not enabled");
	    	driver.findElement(login.PasswordField).sendKeys("admin123");
	    	String type=driver.findElement(login.PasswordField).getAttribute("Type");
	    	Assert.assertEquals(type, "password" ,"Password is not masking");
	    }
	    @Test
	    //Verify login with valid username and valid password
	    public void TC_LoginPage_004() throws InterruptedException {
	    	login.Login("Admin", "admin123");
	    	Thread.sleep(2000);
	    	String Title=driver.findElement(HomePage.PageTitle).getText();
	    	System.out.println(Title);
	    	Assert.assertEquals(Title, "Dashboard" , "Dashboard page is not opened.");
	    	Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", "HomePage URL not matched");
	    }
	    
	    @Test
	    //Verify login using Enter key instead of Login button
	    public void TC_LoginPage_005() {
	    	driver.findElement(login.UsernameField).sendKeys("Admin");
	    	driver.findElement(login.PasswordField).sendKeys("admin123");
            driver.findElement(login.LoginBTN).sendKeys(Keys.ENTER);
            String Title=driver.findElement(HomePage.PageTitle).getText();
	    	System.out.println(Title);
	    	Assert.assertEquals(Title, "Dashboard" , "Dashboard page is not opened.");
	    }
	    
	    @Test
	    //Verify login with blank username and blank password
	    public void TC_LoginPage_006() {
	    	
	    }
}
