package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static java.lang.System.setProperty;

public class TestNGBaseHW2 {

    protected static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        driver = new ChromeDriver();
    }
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        driver.close();
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        System.out.println(System.currentTimeMillis());
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        System.out.println(driver.getTitle());
    }
}