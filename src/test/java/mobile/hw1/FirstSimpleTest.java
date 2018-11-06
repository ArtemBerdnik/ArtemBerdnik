package mobile.hw1;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSimpleTest extends DriverSetup {

    @BeforeClass
    public void setUp() throws Exception {
        prepareNative();
        //uncomment the line below to configure tests for web
        //prepareAndroidWeb();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(description = "Click the \"Add Contact\" button")
    public void SimplestTest() {
        By add_btn_id = By.id("com.example.android.contactmanager:id/addContactButton");

        //various locators
        By add_btn_xpath = By.xpath("//android.widget.Button[@content-desc='Add Contact']");
        By add_btn_class_name = By.className("android.widget.Button");

        driver.findElement(add_btn_xpath).click();
        System.out.println("1st Appium test completed");
    }

    @Test(description = "Open a site")
    public void webTest() {
        driver.get("http://iana.org");
        System.out.println("Site successfully opened");
    }

    //TODO: ANSWER THE QUESTIONS FROM EX2.DOCX
    //1.	Setup project that has been discussed in the class. Make sure you can run both tests (native and web) successfully.
    // DONE.

    //2.	For existing native mobile autotest try to use another locator (xpath, classname, ?). Define these locators using Appium Inspector. Are there any difference with id version?
    // DONE.
    // Added 2 new locators: xpath and classname. Differences are in locator's syntaxis and how appium does search for them

    //3.	Modify existing tests to run on a real device. What should be changed?
    // DONE.
    // "deviceName" capability should be changed to the one from the real device (e7a1c342 in my case)

    //4.	Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?
    // DONE.
    // The developer mode on the mobile phone needs to be turned on
    // USB-debugging needs to be turned on
    // Other configuration does not differ from configuration of virtual device

    //5.	What should be improved/changed in existing test code? Why, for what?
    // DONE.
    //  If we create a test we need asserts being added, otherwise it's not a test
    //  Absolute paths shouldn't be used
    //  Thread.sleep() mustn't be used in the real code
    //  Add more descriptive comments to the steps
    //  We can move urls, capabilities and other stuff from hardcoded values to a separate .properties file
    //  Test data shouldn't be in the same file with test logic
}


