package testsFunctions;

import helpMethods.SharedData;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.InventoryPage;
import pagesLocators.InventoryPageLocators;

public class TC1 extends SharedData {
    @Test
    public void functions() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logIn();

        inventoryPage.filterButtonClick();
        inventoryPage.filterAZ();

        inventoryPage.verifySorting(InventoryPageLocators.itemIdElement,InventoryPageLocators.filterAZ);

        inventoryPage.logOut();
    }
}
