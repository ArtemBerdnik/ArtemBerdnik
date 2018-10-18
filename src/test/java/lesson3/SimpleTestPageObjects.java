package lesson3;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

public class SimpleTestPageObjects extends TestBase {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void simpleTest() {
        driver.get("https://epam.github.io/JDI/index.html");
        Assert.assertEquals(driver.getTitle(), "Home Page");

        homePage.login("epam", "1234");

    }
}