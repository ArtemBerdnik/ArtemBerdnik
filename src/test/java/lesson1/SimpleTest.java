package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void simpleTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://epam.github.io/JDI/index.html");
    }
}
