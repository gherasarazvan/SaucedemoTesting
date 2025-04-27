package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagesLocators.CheckOutPageLocators;

public class CheckOutPage {
    private WebDriver driver;
    private ElementHelper elementHelper;


    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void cancelButtonClick() {
        elementHelper.clickLocator(CheckOutPageLocators.cancelButton);
        LoggerUtility.infoTest("The user clicks cancel button");
    }

    public void continueButtonClick() {
        elementHelper.clickLocator(CheckOutPageLocators.continueButton);
        LoggerUtility.infoTest("The user clicks continue button");
    }

    public void fillCheckOutValues() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        String firstNameValue = "Razvan";
        String lastNameValue = "Gherasa";
        String postalCodeValue = "335700";

        elementHelper.fillLocator(CheckOutPageLocators.firstNameElemet, firstNameValue);
        elementHelper.fillLocator(CheckOutPageLocators.lastNameElement, lastNameValue);
        elementHelper.fillLocator(CheckOutPageLocators.postalCodeElement, postalCodeValue);

        LoggerUtility.infoTest("The user filled checkout data");
    }

    public void finishShopping() {
        elementHelper.clickLocator(CheckOutPageLocators.finishButton);
        LoggerUtility.infoTest("The user clicks Finish button");
    }

    public void validateOrderText() {
        WebElement confirmationElement = driver.findElement(CheckOutPageLocators.confirmationMessage);
        String actualText = confirmationElement.getText();

        if (actualText.equals("Thank you for your order!")) {
            System.out.println("The order has been placed successfully");
            LoggerUtility.infoTest("Confirmation message was verified");
        } else {

            System.out.println("The confirmation message is not what was expected. Text found: " + actualText);
        }

    }


    public void fillCheckOutOnlyFirstName() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        String firstNameValue = "Razvan";

        elementHelper.fillLocator(CheckOutPageLocators.firstNameElemet, firstNameValue);

        LoggerUtility.infoTest("The user filled first name data");
    }

    public void fillCheckOutOnlyLastName() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        String lastNameValue = "Razvan";

        elementHelper.fillLocator(CheckOutPageLocators.lastNameElement, lastNameValue);

        LoggerUtility.infoTest("The user filled last name data");
    }

    public void fillCheckOutValuesFirstNameAndLastName() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        String lastNameValue = "Gherasa";
        String firstNameValue = "Razvan";

        elementHelper.fillLocator(CheckOutPageLocators.lastNameElement, lastNameValue);
        elementHelper.fillLocator(CheckOutPageLocators.firstNameElemet, firstNameValue);

        LoggerUtility.infoTest("The user filled last name data");
        LoggerUtility.infoTest("The user filled first name data");
    }


    public void validateErrorMessageFirstName() {
        WebElement errorElement = driver.findElement(CheckOutPageLocators.errorMessage);
        String actualText = errorElement.getText();

        if (actualText.equals("Error: First Name is required")) {
            LoggerUtility.infoTest("Error message was verified");
        } else {

            System.out.println("The error message is not what was expected. Text found: " + actualText);
        }

    }

    public void validateErrorMessageLastName() {
        WebElement errorElement = driver.findElement(CheckOutPageLocators.errorMessage);
        String actualText = errorElement.getText();

        if (actualText.equals("Error: Last Name is required")) {
            LoggerUtility.infoTest("Error message was verified");
        } else {

            System.out.println("The error message is not what was expected. Text found: " + actualText);
        }

    }

    public void validateErrorMessagePostalCode() {
        WebElement errorElement = driver.findElement(CheckOutPageLocators.errorMessage);
        String actualText = errorElement.getText();

        if (actualText.equals("Error: Postal Code is required")) {
            LoggerUtility.infoTest("Error message was verified");
        } else {

            System.out.println("The error message is not what was expected. Text found: " + actualText);
        }

    }
}
