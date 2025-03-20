package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
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

    public void logInClick(){
        elementHelper.clickLocator(IndexLocators.logInButton);
    }

    public void waitForElementVisible(WebElement locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void fillUser(String userNameValue){
        elementHelper.fillLocator(userNameElement, userNameValue);
    }

    public void fillPassword(String passwordValue){
        elementHelper.fillLocator(passwordElement, passwordValue);
    }

    public void verifyUrl(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL-ul curent nu este cel așteptat!");
    }

    public void waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
