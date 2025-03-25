package testsFunctions;

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

        inventoryPage.verifySortingAscending(InventoryPageLocators.itemPriceElement);

        inventoryPage.logOut();
    }
}
