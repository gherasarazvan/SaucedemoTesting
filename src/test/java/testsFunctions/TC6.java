package testsFunctions;

import helpMethods.SharedData;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pagesLocators.InventoryPageLocators;

import java.util.Arrays;
import java.util.List;

public class TC6 extends SharedData {

    @Test
    public void functions() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logIn();
        inventoryPage.resetAppStateButtonClick();


        List<Integer> productsToAdd = Arrays.asList(0, 1, 4, 6);
        inventoryPage.clickAddToCartByIndex(InventoryPageLocators.addToCartButtons, productsToAdd);

        List<Integer> productsToDelete = Arrays.asList(0, 1, 5);
        inventoryPage.deleteFromCartByIndex(InventoryPageLocators.removeButton, productsToDelete);

        inventoryPage.cartItemPageClick();
        inventoryPage.verifyUrl("https://www.saucedemo.com/cart.html");


        inventoryPage.allItemsPageClick();
        inventoryPage.verifyUrl("https://www.saucedemo.com/inventory.html");

        inventoryPage.logOut();
    }
}
