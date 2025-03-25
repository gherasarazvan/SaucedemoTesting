package testsLoginLogout;

import helpMethods.SharedData;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.InventoryPage;

public class TC1 extends SharedData {

    @Test
    public void loginLogout() {
        IndexPage indexPage = new IndexPage(driver);
        String userNameValue = "problem_user";
        String passwordValue = "secret_sauce";
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        indexPage.fillUser(userNameValue);
        indexPage.fillPassword(passwordValue);

        indexPage.validateTestData(userNameValue, passwordValue);

        indexPage.logInClick();

        indexPage.verifyUrl(expectedUrl);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logOutClick();
    }
}
