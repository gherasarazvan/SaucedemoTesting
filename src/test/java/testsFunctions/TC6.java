package testsFunctions;

import helpMethods.AlertHelper;
import helpMethods.SharedData;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pagesLocators.CartPageLocators;
import pagesLocators.InventoryPageLocators;

import java.util.Arrays;
import java.util.List;

public class TC6 extends SharedData {

    @Test
    public void functions() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logIn();

        inventoryPage.resetAppStateButtonClick();
        inventoryPage.closeBurgerMenuPage();

        List<Integer> productsToAdd = Arrays.asList(0, 1, 4, 6);
        inventoryPage.clickAddToCartByIndex(InventoryPageLocators.addToCartButtons, productsToAdd);

        List<Integer> productsToDelete = Arrays.asList(0, 1, 5);
        inventoryPage.deleteFromCartByIndex(InventoryPageLocators.removeButton, productsToDelete);

        CartPage cartPage = new CartPage(driver);
        cartPage.verifyCartTotalProducts(1);

        inventoryPage.cartItemPageClick();
        inventoryPage.verifyUrl("https://www.saucedemo.com/cart.html");

        inventoryPage.allItemsPageClick();
        inventoryPage.verifyUrl("https://www.saucedemo.com/inventory.html");

        inventoryPage.logOut();
    }
}
