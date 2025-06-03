package base;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverManager;
import utils.PlatformType;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        String platformName = System.getProperty("platform", "ANDROID");
        PlatformType platform = PlatformType.valueOf(platformName.toUpperCase());
        driver = DriverManager.initializeDriver(platform);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
