package testsLoginLogout;

import helpMethods.SharedData;
import org.testng.annotations.Test;
import pages.IndexPage;

public class TC3 extends SharedData {

    @Test
    public void loginLogout() {
        IndexPage indexPage = new IndexPage(driver);
        String userNameValue = "proble_user";
        String passwordValue = "secret_sauce";
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";

        indexPage.fillUser(userNameValue);
        indexPage.fillPassword(passwordValue);
        indexPage.logInClick();
        indexPage.verifyErrorMessage(expectedMessage);
    }
}
