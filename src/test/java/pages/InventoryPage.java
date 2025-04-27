package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
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
        elementHelper.clickJsLocator(driver.findElement(InventoryPageLocators.burgerMenuButton));
        LoggerUtility.infoTest("The clicks the burger menu");
    }

    public void logOutClick() {
        burgerMenuClick();
        elementHelper.clickLocator(InventoryPageLocators.logOutButton);
        LoggerUtility.infoTest("The user clicks the log out button");
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

        LoggerUtility.infoTest("The user fill in the fields and log in");
    }

    public void logOut() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logOutClick();
    }

    public void filterButtonClick() {
        elementHelper.clickLocator(InventoryPageLocators.filterButton);
        LoggerUtility.infoTest("The user clicks the sorting button");
    }

    public void filterAZ() {
        elementHelper.clickLocator(InventoryPageLocators.filterButton);
        elementHelper.clickLocator(InventoryPageLocators.filterAZ);
        LoggerUtility.infoTest("The user click sorting AZ");
    }

    public void filterZA() {
        elementHelper.clickLocator(InventoryPageLocators.filterButton);
        elementHelper.clickLocator(InventoryPageLocators.filterZA);
        LoggerUtility.infoTest("The user click sorting ZA");
    }

    public void filterLOHI() {
        elementHelper.clickLocator(InventoryPageLocators.filterButton);
        elementHelper.clickLocator(InventoryPageLocators.filterLOHI);
        LoggerUtility.infoTest("The user click sorting LOHI");
    }

    public void filterHILO() {
        elementHelper.clickLocator(InventoryPageLocators.filterButton);
        elementHelper.clickLocator(InventoryPageLocators.filterHILO);
        LoggerUtility.infoTest("The user click sorting HILO");
    }

    public void verifySortingAscending(By locator) {
        elementHelper.waitForElementVisible(locator);
        List<WebElement> elementList = driver.findElements(locator);
        List<String> actualList = new ArrayList<>();

        for (int index = 0; index < elementList.size(); index++) {
            actualList.add(elementList.get(index).getText().trim());
        }

        for (int index = 0; index < actualList.size() - 1; index++) {
            Assert.assertTrue(actualList.get(index).compareTo(actualList.get(index + 1)) <= 0);
        }

        LoggerUtility.infoTest("Sorting was verified");
    }

    public void verifySortingDescending(By locator) {
        elementHelper.waitForElementVisible(locator);
        List<WebElement> elementList = driver.findElements(locator);
        List<String> actualList = new ArrayList<>();

        for (int index = 0; index < elementList.size(); index++) {
            actualList.add(elementList.get(index).getText().trim());
        }

        for (int index = 0; index < actualList.size() - 1; index++) {
            Assert.assertTrue(actualList.get(index).compareTo(actualList.get(index + 1)) >= 0);
        }

        LoggerUtility.infoTest("Sorting was verified");
    }

    public void verifyPriceSortingAscending(By locator) {
        elementHelper.waitForElementVisible(locator);
        List<WebElement> priceElements = driver.findElements(locator);
        List<Double> actualPrices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "").trim();
            actualPrices.add(Double.parseDouble(priceText));
        }

        for (int index = 0; index < actualPrices.size() - 1; index++) {
            Assert.assertTrue(actualPrices.get(index) <= actualPrices.get(index + 1));
        }

        LoggerUtility.infoTest("Sorting was verified");
    }

    public void verifyPriceSortingDescending(By locator) {
        elementHelper.waitForElementVisible(locator);
        List<WebElement> priceElements = driver.findElements(locator);
        List<Double> actualPrices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "").trim();
            actualPrices.add(Double.parseDouble(priceText));
        }

        for (int index = 0; index < actualPrices.size() - 1; index++) {
            Assert.assertTrue(actualPrices.get(index) >= actualPrices.get(index + 1));
        }

        LoggerUtility.infoTest("Sorting was verified");
    }

    public void aboutButtonClick() {
        elementHelper.clickLocator(InventoryPageLocators.aboutPage);
        LoggerUtility.infoTest("The user clicks the About button");
    }

    public void allItemsPageClick() {
        elementHelper.clickLocator(InventoryPageLocators.allItemsPage);
        LoggerUtility.infoTest("The user clicks All items button");
    }

    public void resetAppStateButtonClick() {
        elementHelper.clickLocator(InventoryPageLocators.resetAppStateButton);
        LoggerUtility.infoTest("The user clicks Reset app state button");
    }

    public void verifyUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URLs does not match!");
    }

    public void cartItemPageClick() {
        elementHelper.waitForElementVisible(InventoryPageLocators.cartButton);
        elementHelper.clickLocator(InventoryPageLocators.cartButton);
        LoggerUtility.infoTest("The user clicks Cart item button");
    }

    public void clickAddToCartByIndex(By locator, List<Integer> wantedProducts) {
        elementHelper.waitForElementVisible(locator);
        List<WebElement> addToCartButtons = driver.findElements(locator);

        for (Integer index : wantedProducts) {
            if (index >= 0 && index < addToCartButtons.size()) {
                elementHelper.clickLocator(addToCartButtons.get(index));
                System.out.println("Added to cart product with index: " + index);
            } else {
                System.out.println("Invalid index: " + index + ". The site has only " + addToCartButtons.size() + " products");
            }
        }

        LoggerUtility.infoTest("The user added products");
    }


    public void deleteFromCartByIndex(By locator, List<Integer> deletedProducts) {
        elementHelper.waitForElementVisible(locator);
        for (Integer index : deletedProducts) {
            List<WebElement> removeFromCartButtons = driver.findElements(locator);

            if (index >= 0 && index < removeFromCartButtons.size()) {
                removeFromCartButtons.get(index).click();
                System.out.println("Product with index " + index + " was deleted from cart");
            } else {
                System.out.println("Invalid index: " + index + ". Cart has only " + removeFromCartButtons.size() + " products");
            }
        }

        LoggerUtility.infoTest("The user deleted products");
    }

    public void closeBurgerMenuPage(){
        elementHelper.clickLocator(InventoryPageLocators.closeBurgerMenuButton);
        LoggerUtility.infoTest("The user clicks close burger menu button");
    }
}

