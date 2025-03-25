package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pagesLocators.InventoryPageLocators;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    private ElementHelper elementHelper;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void burgerMenuClick() {
        elementHelper.clickLocator(InventoryPageLocators.burgerMenuButton);
    }

    public void logOutClick() {
        burgerMenuClick();
        elementHelper.clickLocator(InventoryPageLocators.logOutButton);
    }

    public void logIn() {
        IndexPage indexPage = new IndexPage(driver);
        String userNameValue = "standard_user";
        String passwordValue = "secret_sauce";
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        indexPage.fillUser(userNameValue);
        indexPage.fillPassword(passwordValue);
        indexPage.validateTestData(userNameValue, passwordValue);
        indexPage.logInClick();
        indexPage.verifyUrl(expectedUrl);
    }

    public void logOut() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logOutClick();
    }

    public void filterButtonClick() {
        elementHelper.clickLocator(InventoryPageLocators.filterButton);
    }

    public void filterAZ() {
        elementHelper.clickLocator(InventoryPageLocators.filterButton);
        elementHelper.clickLocator(InventoryPageLocators.filterAZ);
    }

    public void filterZA() {
        elementHelper.clickLocator(InventoryPageLocators.filterButton);
        elementHelper.clickLocator(InventoryPageLocators.filterZA);
    }

    public void filterLOHI() {
        elementHelper.clickLocator(InventoryPageLocators.filterButton);
        elementHelper.clickLocator(InventoryPageLocators.filterLOHI);
    }

    public void filterHILO() {
        elementHelper.clickLocator(InventoryPageLocators.filterButton);
        elementHelper.clickLocator(InventoryPageLocators.filterHILO);
    }

    public void verifySortingAscending(By locator) {
        elementHelper.waitForElementVisible(locator);
        List<WebElement> elementList = driver.findElements(locator);
        List<String> actualList = new ArrayList<>();

        for (int index = 0; index < elementList.size(); index++) {
            actualList.add(elementList.get(index).getText().trim());
        }

        for (int index = 0; index < actualList.size()-1; index++) {
            Assert.assertTrue(actualList.get(index).compareTo(actualList.get(index + 1)) <= 0);
        }
    }

    public void verifySortingDescending(By locator) {
        elementHelper.waitForElementVisible(locator);
        List<WebElement> elementList = driver.findElements(locator);
        List<String> actualList = new ArrayList<>();

        for (int index = 0; index < elementList.size(); index++) {
            actualList.add(elementList.get(index).getText().trim());
        }

        for (int index = 0; index < actualList.size()-1; index++) {
            Assert.assertTrue(actualList.get(index).compareTo(actualList.get(index + 1)) >= 0);
        }
    }
}
