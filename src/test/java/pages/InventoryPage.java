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
        elementHelper.clickJsLocator(driver.findElement(InventoryPageLocators.burgerMenuButton));
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

        for (int index = 0; index < actualList.size() - 1; index++) {
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

        for (int index = 0; index < actualList.size() - 1; index++) {
            Assert.assertTrue(actualList.get(index).compareTo(actualList.get(index + 1)) >= 0);
        }
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
    }

    public void aboutButtonClick() {
        burgerMenuClick();
        elementHelper.clickLocator(InventoryPageLocators.aboutPage);
    }

    public void allItemsPageClick() {
        burgerMenuClick();
        elementHelper.clickLocator(InventoryPageLocators.allItemsPage);
    }

    public void resetAppStateButtonClick() {
        burgerMenuClick();
        elementHelper.clickLocator(InventoryPageLocators.resetAppStateButton);
    }

    public void verifyUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL-ul curent nu este cel așteptat!");
    }

    public void cartItemPageClick() {
        elementHelper.clickLocator(InventoryPageLocators.cartButton);
    }

    public void clickAddToCartByIndex(By locator, List<Integer> wantedProducts) {
        elementHelper.waitForElementVisible(locator);
        List<WebElement> addToCartButtons = driver.findElements(locator);

        for (Integer index : wantedProducts) {
            if (index >= 0 && index < addToCartButtons.size()) {
                elementHelper.clickLocator(addToCartButtons.get(index));
                System.out.println("Click pe butonul 'Add to cart' pentru produsul cu indexul: " + index);
            } else {
                System.out.println("Index invalid: " + index + ". Pe site sunt doar " + addToCartButtons.size() + " produse.");
            }
        }
    }

    public void deleteFromCartByIndex(By locator, List<Integer> deletedProducts) {
        elementHelper.waitForElementVisible(locator);
        List<WebElement> removeFromCartButtons = driver.findElements(locator);

        for (Integer index : deletedProducts) {
            if (index >= 0 && index < removeFromCartButtons.size()) {
                removeFromCartButtons.get(index).click();
                System.out.println("Produsul cu indexul " + index + " a fost eliminat din coș.");
            } else {
                System.out.println("Index invalid: " + index + ". În coș sunt doar " + removeFromCartButtons.size() + " produse.");
            }
        }
    }
}

