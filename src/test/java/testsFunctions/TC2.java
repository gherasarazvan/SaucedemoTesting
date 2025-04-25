package testsFunctions;

import helpMethods.AlertHelper;
import helpMethods.SharedData;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pagesLocators.InventoryPageLocators;

public class TC2 extends SharedData {
    @Test
    public void functions() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logIn();

        inventoryPage.filterButtonClick();
        inventoryPage.filterZA();
        inventoryPage.verifySortingDescending(InventoryPageLocators.itemIdElement);

        inventoryPage.logOut();
        inventoryPage.verifyUrl("https://www.saucedemo.com/");
    }
}
