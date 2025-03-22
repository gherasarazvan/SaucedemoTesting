package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import pagesLocators.InventoryPageLocators;

public class InventoryPage {
    private WebDriver driver;
    private ElementHelper elementHelper;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void burgerMenuClick(){
        elementHelper.clickLocator(InventoryPageLocators.burgerMenuButton);
    }

    public void logOutClick(){
        burgerMenuClick();
        elementHelper.clickLocator(InventoryPageLocators.logOutButton);
    }
}
