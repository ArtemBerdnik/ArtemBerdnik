package hw1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckingEpamGitHubIOJdiPage extends TestNGBase {


    @Test
    public void verifyingIndexHtmlPage() {
        //1. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.xpath("//input[@id=\"Name\"]")).sendKeys("epam");
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        //2. Assert displayed username
        assertEquals(driver.findElement(By.xpath("//span[@ui=\"label\"][@class!=\"hidden\"]")).getText(), "PITER CHAILOVSKII");

        //3. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //4. Assert buttons and dropdowns in the page header
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"index.html\"])[1]")).getText(), "HOME");
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"contacts.html\"])[1]")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"][@data-toggle=\"dropdown\"])[1]")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"metals-colors.html\"])[1]")).getText(), "METALS & COLORS");

        //5. Assert icons are being displayed in the page
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-practise\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-custom\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-multi\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-base\"])[1]")).isDisplayed());

        //6. Assert text is being displayed below icons
        assertEquals(driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[1]")).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[2]")).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[3]")).getText(), "To be multiplatform");
        assertEquals(driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[4]")).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //7. Assert the text of the main header
        assertEquals(driver.findElement(By.xpath("//h3[@name=\"main-title\"]")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.xpath("//p[@name=\"jdi-text\"]")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET" +
                " DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
                " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //8. Assert that the iframe in the center of page is being displayed
        assertTrue(driver.findElement(By.xpath("(//iframe[@id=\"iframe\"])[1]")).isDisplayed());

        //Switching to the iframe
        driver.switchTo().frame("iframe");

        //9. Assert that EPAM logo is being displayed in the iframe
        assertTrue(driver.findElement(By.xpath("//img[@src=\"images/Logo_Epam_Color.svg\"]")).isDisplayed());

        //Switching to the original window back
        driver.switchTo().defaultContent();

        //10. Assert the text of the sub header
        assertEquals(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/JDI\"]")).getText(), "JDI GITHUB");

        //11. Assert the link of the sub header
        assertEquals(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/JDI\"]")).getAttribute("href"), "https://github.com/epam/JDI");
        assertTrue(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/JDI\"]")).isEnabled());

        //12. Assert that left pane is being displayed
        assertTrue(driver.findElement(By.xpath("//div[@name=\"navigation-sidebar\"]")).isDisplayed());

        //13. Assert that footer is being displayed
        assertTrue(driver.findElement(By.xpath("//div[@class=\"footer-content overflow\"]")).isDisplayed());
    }
}
