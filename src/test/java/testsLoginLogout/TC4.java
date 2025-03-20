package testsLoginLogout;

import helpMethods.ElementHelper;
import helpMethods.SharedData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC4 extends SharedData {

    @Test
    public void loginLogout() {
        ElementHelper elementHelper = new ElementHelper(driver);

        By userNameElement = By.id("user-name");
        String userNameValue = "proble_user";
        elementHelper.fillLocator(userNameElement, userNameValue);

        By passwordElement = By.id("password");
        String passwordValue = "";
        elementHelper.fillLocator(passwordElement, passwordValue);

        By loginButton = By.name("login-button");
        elementHelper.clickLocator(loginButton);
    }
}
