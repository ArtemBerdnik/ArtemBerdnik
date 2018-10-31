package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class SimpleTest {

    @Test
    public void simpleTest() {
        setProperty("webdriver.chrome.driver", "C:\\Users\\khzc128\\IdeaProjects\\ArtemBerdnik\\src\\main\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://epam.github.io/jdi/index.html");

        Assert.assertEquals(driver.getTitle(), "Home Page");

        driver.close();
    }
}
