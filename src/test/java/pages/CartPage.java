package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCartTotalProducts(int expectedProductsNumber) {
        int totalProducts = 0; // Mutat aici sus!

        if (driver.findElements(By.className("shopping_cart_badge")).size() > 0) {
            WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
            String numberText = cartBadge.getText();
            totalProducts = Integer.parseInt(numberText);
            System.out.println("Total produse în coș: " + totalProducts);
        } else {
            System.out.println("Niciun produs în coș.");
        }

        Assert.assertEquals(totalProducts, expectedProductsNumber, "Numărul așteptat de produse nu corespunde!");
    }


}
