package testsFunctions;

import helpMethods.AlertHelper;
import helpMethods.SharedData;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pagesLocators.InventoryPageLocators;

public class TC3 extends SharedData {
    @Test
    public void functions() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logIn();

        inventoryPage.filterButtonClick();
        inventoryPage.filterLOHI();
        inventoryPage.verifyPriceSortingAscending(InventoryPageLocators.itemPriceElement);

        inventoryPage.logOut();
        inventoryPage.verifyUrl("https://www.saucedemo.com/");
    }
}
