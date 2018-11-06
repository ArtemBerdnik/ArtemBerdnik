package mobile.hw1;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {

    protected AndroidDriver driver;

    void prepareNative() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory capabilities
        capabilities.setCapability("deviceName", "e7a1c342");
        capabilities.setCapability("platformName", "Android");

        File app = new File("src\\main\\resources\\ContactManager.apk");

        capabilities.setCapability("app", app.getAbsolutePath());

        // Driver initialization with desired capabilities
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    void prepareAndroidWeb() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("deviceName", "e7a1c342");
        capabilities.setCapability("platformName", "Android");

        // specific web capabilities
        capabilities.setCapability("browserName", "Chrome");

        // Driver initialization with desired capabilities
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
