package tests_orangeHRM;

import org.testng.annotations.BeforeMethod;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;

public class LoginPageTests extends BaseTest {
	
	LoginPage login;
	
	@BeforeMethod
    public void setupPage() {
        login = new LoginPage(driver);
    }

	
	

}
