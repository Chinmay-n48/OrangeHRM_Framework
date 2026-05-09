package utils_orangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OHWaitUtils {

    WebDriver driver;

    // Constructor
    public OHWaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForVisibility(By locator, int seconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
