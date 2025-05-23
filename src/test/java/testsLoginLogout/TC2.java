package testsLoginLogout;

import helpMethods.ElementHelper;
import helpMethods.SharedData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;

import static pagesLocators.IndexLocators.errorMessageElement;
import static pagesLocators.IndexLocators.userNameElement;

public class TC2 extends SharedData {

    @Test
    public void loginLogout() {
        IndexPage indexPage = new IndexPage(driver);
        String userNameValue = "problem_user";
        String passwordValue = "secret___1234";
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";

        indexPage.fillUser(userNameValue);
        indexPage.fillPassword(passwordValue);
        indexPage.validateTestData(userNameValue, passwordValue);
        indexPage.logInClick();
        indexPage.verifyErrorMessage(expectedMessage);
    }
}
