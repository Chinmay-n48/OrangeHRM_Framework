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
            Assert.assertTrue(action.isDisplayed(driver, login.ForgotPassWodBTN), "ForgotPassowrd Link is not available");
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
	    	Assert.assertTrue(action.isDisplayed(driver, login.ForgotPassWodBTN), "PassWordField is not available");
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
	    	login.Login("", "");
	    	Assert.assertEquals(action.getText(driver, login.UNFValidationMsg), "Required", "The validation message text of the username field in not matched");
	    	Assert.assertEquals(action.getText(driver, login.PFValidationMsg), "Required" , "The validation message text of the password field in not matched");	    	
	    }
	    @Test
	    //Verify login with invalid username and valid password
	    public void TC_LoginPage_007(){
	    	login.Login("InvalidUser", "admin123");
	    	wait.waitForVisibility(login.ErrorMsg, 20);
	    	Assert.assertEquals(action.getText(driver, login.ErrorMsg), "Invalid credentials" , "Error Message text is not displayed or matched.");	    	
	    }
	    @Test
	    //Verify login with valid username and invalid password
	    public void TC_LoginPage_008() {
	    	login.Login("Admin", "wrongpass");
	    	wait.waitForVisibility(login.ErrorMsg, 20);
	    	Assert.assertEquals(action.getText(driver, login.ErrorMsg), "Invalid credentials" , "Error message text is not displayed or matched.");
	    }
	    
	    @Test
	    //Verify login with SQL Injection attack input	    
	    public void TC_LoginPage_009() {
	    	login.Login("' OR 1=1 --", "' OR 1=1 --");
	    	wait.waitForVisibility(login.ErrorMsg, 20);
	    	Assert.assertEquals(action.getText(driver, login.ErrorMsg), "Invalid credentials", "Error message text is not displayed or matched.");
	    }
	    
	    @Test
	    //Verify login with XSS attack payload
	    public void TC_LoginPage_010() {
	    	login.Login("<script>alert('xss')</script>", "admin123");
	    	wait.waitForVisibility(login.ErrorMsg, 20);
	    	Assert.assertEquals(action.getText(driver, login.ErrorMsg), "Invalid credentials", "Error message text is not displayed or matched.");
	    }
	    
	    @Test
	    //Verify Forgot Password navigation functionality
	    public void TC_LoginPage_015() {
	    	action.click(driver, login.ForgotPassWodBTN);
	    	Assert.assertTrue(action.isDisplayed(driver, login.ResetPassWordPopup), "Reset Password popup is not displayed");	    	
	    }
	    
	    @Test
	    //Verify password reset request with valid username	    
	    public void TC_LoginPage_016(){
	    	action.click(driver, login.ForgotPassWodBTN);
	    	driver.findElement(login.ResetUserNameField).sendKeys("Test");
	    	action.click(driver, login.ResetPassWordBTN);
	    	wait.waitForVisibility(login.ResetPassWordLinkPopup, 20);
	    	Assert.assertTrue(action.isDisplayed(driver, login.ResetPassWordLinkPopup), "'Reset Password link sent successfully' popup is not displayed");	
	    	String Text=action.getText(driver, login.ResetPassWordLinkPopup);
	    	Assert.assertTrue(Text.contains("Reset Password link sent successfully"), "Popup tile is not matched or available");
	    	Assert.assertTrue(Text.contains("A reset password link has been sent to you via email."), "Popup mesage not matched or available");
	    	Assert.assertTrue(Text.contains("You can follow that link and select a new password."), "Popup message is not matched or available");
	    	Assert.assertTrue(Text.contains("Note:"), "Popup footer message is not matched or available");
	    	Assert.assertTrue(Text.contains("If the email does not arrive, please contact your OrangeHRM Administrator."), "Popup footer message is not matched or available");
	    }
	    @Test
	    //Verify session persistence after browser refresh
	    public void TC_LoginPage_017() {
	    	login.Login("Admin", "admin123");
	    	Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index" , "Url is not matched ");
	    	driver.navigate().refresh();
	    	Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index" , "Url is not matched ");
	    	Assert.assertTrue(action.isDisplayed(driver, HomePage.PageTitle), "Homepage is not opened");	    	
	    }
	    @Test
	    //Verify successful logout functionality
	    public void TC_LoginPage_018(){
	    	login.Login("Admin", "admin123");
	    	wait.waitForVisibility(HomePage.PageTitle, 20);
	    	Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index" , "Url is not matched ");
	    	HomePage.LogOut();
	    	//Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    }	    
}
