package testsFunctions;

import helpMethods.SharedData;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.InventoryPage;
import pagesLocators.InventoryPageLocators;

import java.util.Arrays;
import java.util.List;

public class TC8 extends SharedData {

    @Test
    public void functions() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logIn();

        inventoryPage.burgerMenuClick();
        inventoryPage.resetAppStateButtonClick();
        inventoryPage.allItemsPageClick();
        inventoryPage.closeBurgerMenuPage();


        List<Integer> productsToAdd = Arrays.asList(0, 1, 4, 5);
        inventoryPage.clickAddToCartByIndex(InventoryPageLocators.addToCartButtons, productsToAdd);


        inventoryPage.cartItemPageClick();


        CartPage cartPage = new CartPage(driver);
        cartPage.checkOutClick();


        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.cancelButtonClick();


        List<Integer> productsToDelete = Arrays.asList(0, 1);
        inventoryPage.deleteFromCartByIndex(InventoryPageLocators.removeButton, productsToDelete);


        cartPage.verifyCartTotalProducts(2);


        cartPage.checkOutClick();


        checkOutPage.continueButtonClick();
        checkOutPage.fillCheckOutOnlyLastName();


        checkOutPage.continueButtonClick();


        checkOutPage.validateErrorMessageFirstName();

    }
}
