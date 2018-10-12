package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckingEpamGitHubIOJdiPage {

    private WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void beforeClass() {
        //Open a verifying page
        driver.get("https://epam.github.io/JDI/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test
    public void checkBrowserTitle() {
        //1. Assert Browser title
        assertEquals("Home Page", driver.getTitle());

        //Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.xpath("//input[@id=\"Name\"]")).sendKeys("epam");
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        //2. Assert displayed username
        assertEquals("PITER CHAILOVSKII", driver.findElement(By.xpath("//span[@ui=\"label\"][@class!=\"hidden\"]")).getText());

        //3. Assert Browser title
        assertEquals("Home Page", driver.getTitle());

        //4. Assert buttons and dropdowns in the page header
        assertEquals("HOME", driver.findElement(By.xpath("(//a[@href=\"index.html\"])[1]")).getText());
        assertEquals("CONTACT FORM", driver.findElement(By.xpath("(//a[@href=\"contacts.html\"])[1]")).getText());
        assertEquals("SERVICE", driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"][@data-toggle=\"dropdown\"])[1]")).getText());
        assertEquals("METALS & COLORS", driver.findElement(By.xpath("(//a[@href=\"metals-colors.html\"])[1]")).getText());

        //5. Assert icons are being displayed in the page
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-practise\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-custom\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-multi\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-base\"])[1]")).isDisplayed());

        //6. Assert text is being displayed below icons
        assertEquals("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project", driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[1]")).getText());
        assertEquals("To be flexible and\n" +
                "customizable", driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[2]")).getText());
        assertEquals("To be multiplatform", driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[3]")).getText());
        assertEquals("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…", driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[4]")).getText());
    }
}
