package hw1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestNGBase {

    static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //Open a verifying page
        driver  = new ChromeDriver();
        driver.get("https://epam.github.io/JDI/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
