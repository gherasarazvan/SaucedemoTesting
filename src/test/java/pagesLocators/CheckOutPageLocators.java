package pagesLocators;

import org.openqa.selenium.By;

public class CheckOutPageLocators {
    public static final By firstNameElemet = By.id("first-name");
    public static final By lastNameElement = By.id("last-name");
    public static final By postalCodeElement = By.id("postal-code");
    public static final By cancelButton = By.id("cancel");
    public static final By continueButton = By.id("continue");
    public static final By finishButton = By.id("finish");
    public static final By confirmationMessage = By.xpath("//h2[@class='complete-header']");
    public static final By errorMessage = By.xpath("//h3[@data-test='error']");
}
