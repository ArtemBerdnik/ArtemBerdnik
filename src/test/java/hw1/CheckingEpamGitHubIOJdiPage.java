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

        //7. Assert the text of the main header
        assertEquals("EPAM FRAMEWORK WISHES…", driver.findElement(By.xpath("//h3[@name=\"main-title\"]")).getText());
        assertEquals("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET" +
                " DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
                " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.", driver.findElement(By.xpath("//p[@name=\"jdi-text\"]")).getText());

        //8. Assert that the iframe in the center of page is being displayed
        assertTrue(driver.findElement(By.xpath("(//iframe[@id=\"iframe\"])[1]")).isDisplayed());

        //Switching to the iframe
        driver.switchTo().frame("iframe");

        //9. Assert that EPAM logo is being displayed in the iframe
        assertTrue(driver.findElement(By.xpath("//img[@src=\"images/Logo_Epam_Color.svg\"]")).isDisplayed());

        //Switching to the original window back
        driver.switchTo().defaultContent();

        //10. Assert the text of the sub header
        assertEquals("JDI GITHUB", driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/JDI\"]")).getText());

        //11. Assert the link of the sub header
        assertEquals("https://github.com/epam/JDI", driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/JDI\"]")).getAttribute("href"));
        assertTrue(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/JDI\"]")).isEnabled());

        //12. Assert that left pane is being displayed
        assertTrue(driver.findElement(By.xpath("//div[@name=\"navigation-sidebar\"]")).isDisplayed());

        //13. Assert that footer is being displayed
        assertTrue(driver.findElement(By.xpath("//div[@class=\"footer-content overflow\"]")).isDisplayed());
    }
}
