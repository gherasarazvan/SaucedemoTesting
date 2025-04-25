package pagesLocators;

import org.openqa.selenium.By;

public class InventoryPageLocators {
    public static final By burgerMenuButton = By.id("react-burger-menu-btn");
    public static final By logOutButton = By.id("logout_sidebar_link");
    public static final By filterButton = By.xpath("//select[@class='product_sort_container']");
    public static final By filterAZ = By.xpath("//option[@value='az']");
    public static final By filterZA = By.xpath("//option[@value='za']");
    public static final By filterLOHI = By.xpath("//option[@value='lohi']");
    public static final By filterHILO = By.xpath("//option[@value='hilo']");
    public static final By itemIdElement = By.xpath("//div[contains(@class, 'inventory_item_name')]");
    public static final By itemPriceElement = By.xpath("//div[contains(@class, 'inventory_item_price')]");
    public static final By allItemsPage = By.id("inventory_sidebar_link");
    public static final By aboutPage = By.id("about_sidebar_link");
    public static final By resetAppStateButton = By.id("reset_sidebar_link");
    public static final By cartButton = By.xpath("//a[@class='shopping_cart_link']");
    public static final By removeButton = By.xpath("//button[contains(text(), 'Remove')]");
    public static final By addToCartButtons = By.xpath("//button[contains(text(),'Add to cart')]");
    public static final By closeBurgerMenuButton = By.id("react-burger-cross-btn");
}
