package testsFunctions;

import helpMethods.AlertHelper;
import helpMethods.SharedData;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pagesLocators.InventoryPageLocators;

public class TC5 extends SharedData {

    @Test
    public void functions() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logIn();

        inventoryPage.aboutButtonClick();
        inventoryPage.verifyUrl("https://saucelabs.com/");
    }
}
