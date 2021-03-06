package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestNGBaseHW3 {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
        driver.get("https://epam.github.io/jdi/");
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }
}
