package hw1;

import base.TestNGBaseHW2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class CheckingEpamGitHubIOJdiPageUsingSoftAsserts extends TestNGBaseHW2 {

    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyingIndexHtmlPageUsingSoftAlerts() {
        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.xpath("//input[@id=\"Name\"]")).sendKeys("epam");
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        //4. Assert displayed username
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@ui=\"label\"][@class!=\"hidden\"]")).getText(), "PITER CHAILOVSKII");

        //5. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6. Assert buttons and dropdowns in the page header
        softAssert.assertEquals(driver.findElement(By.xpath("(//a[@href=\"index.html\"])[1]")).getText(), "HOME");
        softAssert.assertEquals(driver.findElement(By.xpath("(//a[@href=\"contacts.html\"])[1]")).getText(), "CONTACT FORM");
        softAssert.assertEquals(driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"][@data-toggle=\"dropdown\"])[1]")).getText(), "SERVICE");
        softAssert.assertEquals(driver.findElement(By.xpath("(//a[@href=\"metals-colors.html\"])[1]")).getText(), "METALS & COLORS");


        //7. Assert icons are being displayed in the page
        softAssert.assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-practise\"])[1]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-custom\"])[1]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-multi\"])[1]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("(//div[@class=\"benefit-icon\"]//span[@class=\"icons-benefit icon-base\"])[1]")).isDisplayed());

        //8. Assert text is being displayed below icons
        softAssert.assertEquals(driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[1]")).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        softAssert.assertEquals(driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[2]")).getText(), "To be flexible and\n" +
                "customizable");
        softAssert.assertEquals(driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[3]")).getText(), "To be multiplatform");
        softAssert.assertEquals(driver.findElement(By.xpath("(//div[@class=\"benefit\"]//span[@class=\"benefit-txt\"])[4]")).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9. Assert the text of the main header
        softAssert.assertEquals(driver.findElement(By.xpath("//h3[@name=\"main-title\"]")).getText(), "EPAM FRAMEWORK WISHES…");
        softAssert.assertEquals(driver.findElement(By.xpath("//p[@name=\"jdi-text\"]")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET" +
                " DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
                " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10. Assert that the iframe in the center of page is being displayed
        softAssert.assertTrue(driver.findElement(By.xpath("(//iframe[@id=\"iframe\"])[1]")).isDisplayed());

        //11. Switching to the iframe and verifying that the EPAM logo is being displayed in the iframe
        driver.switchTo().frame("iframe");
        softAssert.assertTrue(driver.findElement(By.xpath("//img[@src=\"images/Logo_Epam_Color.svg\"]")).isDisplayed());

        //12. Switching to the original window back
        driver.switchTo().defaultContent();

        //13. Assert the text of the sub header
        softAssert.assertEquals(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/JDI\"]")).getText(), "JDI GITHUB");

        //14. Assert the link of the sub header
        softAssert.assertEquals(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/JDI\"]")).getAttribute("href"), "https://github.com/epam/JDI");
        softAssert.assertTrue(driver.findElement(By.xpath("//a[@href=\"https://github.com/epam/JDI\"]")).isEnabled());

        //15. Assert that left pane is being displayed
        assertTrue(driver.findElement(By.xpath("//div[@name=\"navigation-sidebar\"]")).isDisplayed());

        //16. Assert that footer is being displayed
        softAssert.assertTrue(driver.findElement(By.xpath("//div[@class=\"footer-content overflow\"]")).isDisplayed());

        //Perform assertAll
        softAssert.assertAll();
    }
}
