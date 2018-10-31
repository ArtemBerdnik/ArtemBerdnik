package lesson2;

import base.TestBase;
import dataProviders.DataProviders;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleTestDataProvider extends TestBase {

    @Test(dataProvider = "simpleDataProvider", dataProviderClass = DataProviders.class)
    public void simpleTest(String s, int i) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.get("https://epam.github.io/jdi/index.html");

        Assert.assertEquals(driver.getTitle(), "Home Page");

        driver.close();

        System.out.println("String: " + s + " Integer: " + i);
    }
}
