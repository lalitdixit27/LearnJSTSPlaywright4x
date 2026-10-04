package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private static final By USERNAME_FIELD = By.xpath("//input[@id='username' or @name='username']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@id='password' or @name='password']");
    private static final By LOGIN_BUTTON = By.xpath("//input[@id='Login' or @name='Login']");
    private static final By REMEMBER_ME_CHECKBOX = By.xpath("//input[@type='checkbox' and @id='rememberUn']");
    private static final By INVALID_CREDENTIALS_ERROR = By.xpath("//div[contains(@class,'error') or contains(@id,'error')][contains(.,'Please check your username and password')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        WebElement usernameElement = waitForVisible(USERNAME_FIELD);
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = waitForVisible(PASSWORD_FIELD);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        waitForClickable(LOGIN_BUTTON).click();
    }

    public void selectRememberMe() {
        waitForClickable(REMEMBER_ME_CHECKBOX).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        clickLogin();
        if (passwordFieldExists()) {
            enterPassword(password);
            clickLogin();
        }
    }

    public boolean passwordFieldExists() {
        return isVisible(PASSWORD_FIELD);
    }

    public boolean isInvalidCredentialsErrorDisplayed() {
        return isVisible(INVALID_CREDENTIALS_ERROR);
    }

    public boolean isLoginFormVisible() {
        return isVisible(USERNAME_FIELD);
    }
}
