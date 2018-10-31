package lesson2;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleTest extends TestBase {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }

    @Test(groups = "Group1")
    public void simpleTest() {
        driver.get("https://epam.github.io/jdi/index.html");
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }
}
