package com.salesforce.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.pages.LoginPage;

public class InvalidLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/?locale=in");
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void invalidLoginShouldShowErrorMessage() {
        loginPage.login("invalid.user@example.com", "WrongPassword123!");

        Assert.assertTrue(wait.until(driver -> loginPage.isInvalidCredentialsErrorDisplayed()),
                "Expected an error message for an invalid login attempt.");
        Assert.assertTrue(driver.getCurrentUrl().contains("login.salesforce.com"),
                "Expected the user to remain on the login page after a failed login.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
