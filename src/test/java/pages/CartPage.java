package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pagesLocators.CartPageLocators;

public class CartPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void verifyCartTotalProducts(int expectedProductsNumber) {
        int totalProducts = 0; // Mutat aici sus!

        if (driver.findElements(By.className("shopping_cart_badge")).size() > 0) {
            WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
            String numberText = cartBadge.getText();
            totalProducts = Integer.parseInt(numberText);
            System.out.println("Total products in cart: " + totalProducts);
        } else {
            System.out.println("No products added to cart");
        }

        Assert.assertEquals(totalProducts, expectedProductsNumber, "The expected number of products does not match");

        LoggerUtility.infoTest("Products number was verified");
    }

    public void checkOutClick(){
        elementHelper.clickLocator(CartPageLocators.checkOutButton);
        LoggerUtility.infoTest("The user clicks Checkout button");
    }

}
