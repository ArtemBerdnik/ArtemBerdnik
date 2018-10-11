package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SimpleTest2 {
    @Test
    public void simpleTest2() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://epam.github.io/JDI/index.html");

        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.id("Name")).sendKeys("epam");
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        assertEquals("PITER CHAILOVSKII", driver.findElement(By.xpath("//span[@ui=\"label\"][@class!=\"hidden\"]")).getText());

        driver.close();
    }

}
