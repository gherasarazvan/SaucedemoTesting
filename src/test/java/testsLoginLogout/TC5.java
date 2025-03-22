package testsLoginLogout;

import helpMethods.ElementHelper;
import helpMethods.SharedData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.IndexPage;

public class TC5 extends SharedData {

    @Test
    public void loginLogout() {
        IndexPage indexPage = new IndexPage(driver);
        String userNameValue = "";
        String passwordValue = "secret_sauce";
        String expectedMessage = "Epic sadface: Username is required";

        indexPage.fillUser(userNameValue);
        indexPage.fillPassword(passwordValue);
        indexPage.logInClick();
        indexPage.verifyErrorMessage(expectedMessage);
    }
}
