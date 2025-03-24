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
        String userNameValue = "problem_user";
        String passwordValue = "secret_sauce";
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        indexPage.fillUser(userNameValue);
        indexPage.fillPassword(passwordValue);
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

    public void verifySorting(By locator, By sortButton) {
        driver.findElement(sortButton).click();

        List<String> sortedList = new ArrayList<>();
        List<WebElement> sortedElements = driver.findElements(locator);

        for (int i = 0; i < sortedElements.size(); i++) {
            sortedList.add(sortedElements.get(i).getText());
        }

        for (int i = 0; i < sortedElements.size(); i++) {
            sortedList.add(sortedElements.get(i).getText());
            Assert.assertEquals(sortedList.get(i), sortedList.get(i++), "Lista NU este ordonată");
        }
    }

    public void verifySortingBackwards(By locator, By sortButton) {
        driver.findElement(sortButton).click();

        List<String> sortedList = new ArrayList<>();
        List<WebElement> sortedElements = driver.findElements(locator);

        for (int index = sortedElements.size(); index > sortedElements.size(); index--) {
            sortedList.add(sortedElements.get(index).getText());
        }

        for (int index = 0; index < sortedElements.size(); index++) {
            sortedList.add(sortedElements.get(index).getText());
            Assert.assertEquals(sortedList.get(index), sortedList.get(index++), "Lista NU este ordonată");
            System.out.println(sortedElements.get(index));
        }
    }


}
