package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pagesLocators.IndexLocators;

import java.time.Duration;

import static pagesLocators.IndexLocators.*;

public class IndexPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void logInClick() {
        elementHelper.clickLocator(IndexLocators.logInButton);
    }

    public void waitForElementVisible(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void fillUser(String userNameValue) {
        elementHelper.fillLocator(userNameElement, userNameValue);
    }

    public void fillPassword(String passwordValue) {
        elementHelper.fillLocator(passwordElement, passwordValue);
    }

    public void verifyUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URLs dont match!");
    }

    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = elementHelper.getTextFromLocator(errorMessageElement);
        Assert.assertEquals(actualMessage, expectedMessage, "This is not the expected error message!");
    }

    public void validateTestData(String userNameValue, String passwordValue){
        elementHelper.validateTextContainsAttribute(driver.findElement(userNameElement), userNameValue );
        elementHelper.validateTextContainsAttribute(driver.findElement(passwordElement), passwordValue);
    }

}
