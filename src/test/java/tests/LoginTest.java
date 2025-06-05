package tests;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validateLoginButtonPresent() {
        WebElement loginButton = (WebElement)
                driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button should be visible");
    }
}
