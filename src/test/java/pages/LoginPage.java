package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void tapLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapLoginButton();
    }
}
