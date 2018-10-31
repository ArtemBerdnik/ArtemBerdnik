package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static java.lang.System.setProperty;

public class TestNGBaseHW2 {

    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        driver = new ChromeDriver();
        driver.get("https://epam.github.io/jdi/");
        driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        driver.close();
    }
}