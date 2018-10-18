package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageObjects.IndexPage;

public class TestNGBaseHW3 {
    protected static WebDriver driver;
    protected IndexPage indexPage;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
        driver.get("https://epam.github.io/JDI/");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }
}
