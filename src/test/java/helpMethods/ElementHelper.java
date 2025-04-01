package helpMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementHelper {

    public WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementVisible(WebElement locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void clickLocator(By locator) {
        waitForElementVisible(locator);
        driver.findElement(locator).click();
    }

    public void clickLocator(WebElement element) {
        waitForElementVisible(element);
        element.click();
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
        waitForElementVisible(locator);
        return driver.findElement(locator).getText();
    }

    public void validateTextLocator(By locator, String expected){
        waitForElementVisible(locator);
        String actualMessage = driver.findElement(locator).getText();
        Assert.assertEquals(actualMessage, expected);
    }

    public void validateTextContainsElement(WebElement element, String text){
        waitForElementVisible(element);
        Assert.assertTrue(element.getText().contains(text));
    }

    public void validateTextContainsAttribute(WebElement element, String text){
        waitForElementVisible(element);
        Assert.assertTrue(element.getAttribute("value").contains(text));
    }



}
