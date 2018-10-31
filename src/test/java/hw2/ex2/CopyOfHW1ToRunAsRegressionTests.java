package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CopyOfHW1ToRunAsRegressionTests {


    @Test(groups = "Regression")
    public void FirstTestForVerifyingIndexHtmlPage() {
        //1. Open site
        WebDriver driver = new ChromeDriver();
        driver.get("https://epam.github.io/jdi/");
        driver.manage().window().maximize();

        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.xpath("//input[@id=\"Name\"]")).sendKeys("epam");
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        //4. Assert displayed username
        assertEquals(driver.findElement(By.xpath("//span[@ui=\"label\"][@class!=\"hidden\"]")).getText(), "PITER CHAILOVSKII");

        //5. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6. Assert buttons and dropdowns in the page header
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"index.html\"])[1]")).getText(), "HOME");
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"contacts.html\"])[1]")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"][@data-toggle=\"dropdown\"])[1]")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"metals-colors.html\"])[1]")).getText(), "METALS & COLORS");

        //7. Assert icons are being displayed in the page
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-practise\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-custom\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-multi\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-base\"])[1]")).isDisplayed());

        //8. Assert text is being displayed below icons
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

        //9. Assert the text of the main header
        assertEquals(driver.findElement(By.xpath("//h3[@name=\"main-title\"]")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.xpath("//p[@name=\"jdi-text\"]")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET" +
                " DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
                " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10. Assert that the iframe in the center of page is being displayed
        assertTrue(driver.findElement(By.xpath("(//iframe[@id=\"iframe\"])[1]")).isDisplayed());


        //11. Switching to the iframe and verifying that the EPAM logo is being displayed in the iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.xpath("//img[@src=\"images/Logo_Epam_Color.svg\"]")).isDisplayed());

        //12. Switching to the original window back
        driver.switchTo().defaultContent();

        //13. Assert the text of the sub header
        assertEquals(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/jdi\"]")).getText(), "jdi GITHUB");

        //14. Assert the link of the sub header
        assertEquals(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/jdi\"]")).getAttribute("href"), "https://github.com/epam/jdi");
        assertTrue(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/jdi\"]")).isEnabled());

        //15. Assert that left pane is being displayed
        assertTrue(driver.findElement(By.xpath("//div[@name=\"navigation-sidebar\"]")).isDisplayed());

        //16. Assert that footer is being displayed
        assertTrue(driver.findElement(By.xpath("//div[@class=\"footer-content overflow\"]")).isDisplayed());

        //17. Close browser
        driver.close();
    }

    @Test(groups = "Regression")
    public void SecondTestForVerifyingIndexHtmlPage() {
        //1. Open site
        WebDriver driver = new ChromeDriver();
        driver.get("https://epam.github.io/jdi/");
        driver.manage().window().maximize();

        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.xpath("//input[@id=\"Name\"]")).sendKeys("epam");
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        //4. Assert displayed username
        assertEquals(driver.findElement(By.xpath("//span[@ui=\"label\"][@class!=\"hidden\"]")).getText(), "PITER CHAILOVSKII");

        //5. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6. Assert buttons and dropdowns in the page header
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"index.html\"])[1]")).getText(), "HOME");
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"contacts.html\"])[1]")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"][@data-toggle=\"dropdown\"])[1]")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"metals-colors.html\"])[1]")).getText(), "METALS & COLORS");

        //7. Assert icons are being displayed in the page
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-practise\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-custom\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-multi\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-base\"])[1]")).isDisplayed());

        //8. Assert text is being displayed below icons
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

        //9. Assert the text of the main header
        assertEquals(driver.findElement(By.xpath("//h3[@name=\"main-title\"]")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.xpath("//p[@name=\"jdi-text\"]")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET" +
                " DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
                " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10. Assert that the iframe in the center of page is being displayed
        assertTrue(driver.findElement(By.xpath("(//iframe[@id=\"iframe\"])[1]")).isDisplayed());


        //11. Switching to the iframe and verifying that the EPAM logo is being displayed in the iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.xpath("//img[@src=\"images/Logo_Epam_Color.svg\"]")).isDisplayed());

        //12. Switching to the original window back
        driver.switchTo().defaultContent();

        //13. Assert the text of the sub header
        assertEquals(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/jdi\"]")).getText(), "jdi GITHUB");

        //14. Assert the link of the sub header
        assertEquals(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/jdi\"]")).getAttribute("href"), "https://github.com/epam/jdi");
        assertTrue(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/jdi\"]")).isEnabled());

        //15. Assert that left pane is being displayed
        assertTrue(driver.findElement(By.xpath("//div[@name=\"navigation-sidebar\"]")).isDisplayed());

        //16. Assert that footer is being displayed
        assertTrue(driver.findElement(By.xpath("//div[@class=\"footer-content overflow\"]")).isDisplayed());

        //17. Close browser
        driver.close();
    }

    @Test(groups = "Regression")
    public void ThirdTestForVerifyingIndexHtmlPage() {
        //1. Open site
        WebDriver driver = new ChromeDriver();
        driver.get("https://epam.github.io/jdi/");
        driver.manage().window().maximize();

        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.xpath("//input[@id=\"Name\"]")).sendKeys("epam");
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        //4. Assert displayed username
        assertEquals(driver.findElement(By.xpath("//span[@ui=\"label\"][@class!=\"hidden\"]")).getText(), "PITER CHAILOVSKII");

        //5. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6. Assert buttons and dropdowns in the page header
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"index.html\"])[1]")).getText(), "HOME");
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"contacts.html\"])[1]")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"][@data-toggle=\"dropdown\"])[1]")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.xpath("(//a[@href=\"metals-colors.html\"])[1]")).getText(), "METALS & COLORS");

        //7. Assert icons are being displayed in the page
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-practise\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-custom\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-multi\"])[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-base\"])[1]")).isDisplayed());

        //8. Assert text is being displayed below icons
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

        //9. Assert the text of the main header
        assertEquals(driver.findElement(By.xpath("//h3[@name=\"main-title\"]")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.xpath("//p[@name=\"jdi-text\"]")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET" +
                " DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
                " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10. Assert that the iframe in the center of page is being displayed
        assertTrue(driver.findElement(By.xpath("(//iframe[@id=\"iframe\"])[1]")).isDisplayed());


        //11. Switching to the iframe and verifying that the EPAM logo is being displayed in the iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.xpath("//img[@src=\"images/Logo_Epam_Color.svg\"]")).isDisplayed());

        //12. Switching to the original window back
        driver.switchTo().defaultContent();

        //13. Assert the text of the sub header
        assertEquals(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/jdi\"]")).getText(), "jdi GITHUB");

        //14. Assert the link of the sub header
        assertEquals(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/jdi\"]")).getAttribute("href"), "https://github.com/epam/jdi");
        assertTrue(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/jdi\"]")).isEnabled());

        //15. Assert that left pane is being displayed
        assertTrue(driver.findElement(By.xpath("//div[@name=\"navigation-sidebar\"]")).isDisplayed());

        //16. Assert that footer is being displayed
        assertTrue(driver.findElement(By.xpath("//div[@class=\"footer-content overflow\"]")).isDisplayed());

        //17. Close browser
        driver.close();
    }
}
