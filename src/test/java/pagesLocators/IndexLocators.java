package pagesLocators;

import org.openqa.selenium.By;

public class IndexLocators {

    public static final By logInButton = By.name("login-button");
    public static final By userNameElement = By.id("user-name");
    public static final By passwordElement = By.id("password");
    public static final By errorMessageElement = By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service' or " +
            "text()='Epic sadface: Username is required' or " +
            "text()='Epic sadface: Password is required']");


}
