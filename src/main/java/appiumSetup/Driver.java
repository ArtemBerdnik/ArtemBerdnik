package appiumSetup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;


public class Driver extends TestProperties {
    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    private DesiredCapabilities capabilities;

    // Properties
    private static String AUT; //  app under testing
    protected static String SUT; // site under testing
    private static String TEST_PLATFORM;
    private static String DRIVER;
    private static String DEVICE_NAME;

    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        //log current property
        System.out.println("Properties: " + currentPropertyFile);
        String resourcePath = "./src/main/resources/";
        String mobileAppName = getProp("aut");
        AUT = mobileAppName == null ? null : resourcePath + mobileAppName;
        //log Current AUT to console
        System.out.println("aut=" + AUT);
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "http://" + t_sut;
        //log Current SUT to console
        System.out.println("sut=" + SUT);
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp("devicename");

        //Check type of test platform to set proper browserName capability
        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        //find the corresponding capabilities for WEB/NATIVE test in the config
        //If both SUT and AUT are not null - we pick NATIVE test up
        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            //otherwise we pick WEB test up
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }
        // driver initialization with new AndroidDriver object
        if (driverSingle == null) driverSingle = new AndroidDriver(new URL(DRIVER), capabilities);

        // Set an object to handle timeouts
        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);

    }

    //access singleton
    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }
}
