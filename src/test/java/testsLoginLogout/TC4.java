package testsLoginLogout;

import helpMethods.ElementHelper;
import helpMethods.SharedData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;

public class TC4 extends SharedData {

    @Test
    public void loginLogout() {
        IndexPage indexPage = new IndexPage(driver);
        String userNameValue = "problem_user";
        String passwordValue = "";
        String expectedMessage = "Epic sadface: Password is required";

        indexPage.fillUser(userNameValue);
        indexPage.fillPassword(passwordValue);
        indexPage.validateTestData(userNameValue, passwordValue);
        indexPage.logInClick();
        indexPage.verifyErrorMessage(expectedMessage);
    }
}
