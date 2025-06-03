package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverManager {

    public static AppiumDriver initializeDriver(PlatformType platform) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        if (platform == PlatformType.ANDROID) {
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/app-debug.apk");
            return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        } else if (platform == PlatformType.IOS) {
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 15");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "17.0");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/MyApp.app");
            return new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }

        throw new IllegalArgumentException("Unsupported platform: " + platform);
    }
}
