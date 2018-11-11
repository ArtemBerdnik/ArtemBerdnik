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

    // Properties to be read
    private static String AUT; // (mobile) app under testing
    protected static String SUT; // site under testing
    private static String TEST_PLATFORM;
    private static String DRIVER;
    private static String DEVICE_NAME;

    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        System.out.println("Properties: " + currentPropertyFile);//Write current property file name to console

        String resourcePath = "./src/main/resources/";
        String mobileAppName = getProp("aut");
        AUT = mobileAppName == null ? null : resourcePath + mobileAppName;
        System.out.println("aut=" + AUT); //Write Current AUT to console
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "http://" + t_sut;
        System.out.println("sut=" + SUT); //Write Current SUT to console
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

        //Check for test config type to set corresponding capabilities for WEB/NATIVE test
        //If SUT null and AUT is not null - we deal with NATIVE test
        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            //And if opposite - we deal with WEB test
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }
        // Init driver with new AndroidDriver object
        if (driverSingle == null) driverSingle = new AndroidDriver(new URL(DRIVER), capabilities);

        // Set an object to handle timeouts
        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);

    }

    //Method to access singleton
    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }
}
