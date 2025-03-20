package helpMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementHelper {

    public WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementVisible(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLocator(By locator) {
        waitForElementVisible(locator);
        driver.findElement(locator).click();
    }

    public void clickJsLocator(WebElement locator) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", locator);
    }

    public void fillLocator(By locator, String value) {
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(value);
    }

    public void fillPressLocator(By locator, String value, Keys key) {
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(key);
    }

    public String getTextFromLocator(By locator) {
        return driver.findElement(locator).getText();
    }


}
