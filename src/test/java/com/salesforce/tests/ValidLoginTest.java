package com.salesforce.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.pages.LoginPage;

public class ValidLoginTest {
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
    public void validLoginShouldRedirectToHomePage() {
        String username = System.getProperty("salesforce.username");
        String password = System.getProperty("salesforce.password");

        if (username == null || password == null || username.isBlank() || password.isBlank()) {
            throw new SkipException("Set -Dsalesforce.username and -Dsalesforce.password to execute the valid login test.");
        }

        loginPage.login(username, password);

        wait.until(driver -> !driver.getCurrentUrl().contains("login.salesforce.com"));
        Assert.assertFalse(driver.getCurrentUrl().contains("login.salesforce.com"),
                "Expected valid login to redirect away from the login page.");
        Assert.assertFalse(loginPage.isLoginFormVisible(),
                "Expected login form to be replaced after successful login.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
