package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;

    @Parameters({"platformName"})
    @BeforeMethod
    public void setUp(@Optional("android") String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,
                platformName.equalsIgnoreCase("android") ? "UiAutomator2" : "XCUITest");
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        caps.setCapability("noReset", true);
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        URL url = new URL("http://127.0.0.1:4723");

        if (platformName.equalsIgnoreCase("android")) {
            driver = new AndroidDriver(url, caps);
        } else {
            driver = new IOSDriver(url, caps);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
