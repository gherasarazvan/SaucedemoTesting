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

        indexPage.fillUser(userNameValue);
        indexPage.fillPassword(passwordValue);
    }
}
