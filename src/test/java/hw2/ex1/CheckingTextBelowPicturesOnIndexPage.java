package hw2.ex1;

import Base.TestNGBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckingTextBelowPicturesOnIndexPage extends TestNGBase {

    @DataProvider
    public Object[][] textBelowPictures() {
        return new Object[][]{
                {
                        1, driver.findElement(By.xpath("(//span[@class=\"benefit-txt\"])[1]")).getText()
                },
                {
                        2, driver.findElement(By.xpath("(//span[@class=\"benefit-txt\"])[2]")).getText()
                },
                {
                        3, driver.findElement(By.xpath("(//span[@class=\"benefit-txt\"])[3]")).getText()
                },
                {
                        4, driver.findElement(By.xpath("(//span[@class=\"benefit-txt\"])[4]")).getText()
                }
        };
    }

    @Test(dataProvider = "textBelowPictures")
    public void verifyTextBelowPictures(int textNumber, String text) {
        switch (textNumber) {
            case 1:
                assertEquals(text, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");
                break;

            case 2:
                assertEquals(text, "To be flexible and\n" +
                        "customizable");
                break;

            case 3:
                assertEquals(text, "To be multiplatform");
                break;

            case 4:
                assertEquals(text, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");
                break;
        }
    }
}
