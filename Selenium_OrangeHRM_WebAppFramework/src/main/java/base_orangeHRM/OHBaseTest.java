package base_orangeHRM;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OHBaseTest {
	protected WebDriver driver;
    public Properties prop;

    @BeforeMethod
    public void setup() throws Exception{
	
	prop = new Properties();
    FileInputStream fis =new FileInputStream("src/test/resources/config.properties");
    prop.load(fis);
    
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
    driver.get(prop.getProperty("url"));
}
        @AfterMethod
        public void tearDown() {
        driver.quit();
}
    
}
