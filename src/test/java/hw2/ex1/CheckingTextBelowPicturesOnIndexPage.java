package hw2.ex1;

import base.TestNGBase;
import dataProviders.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CheckingTextBelowPicturesOnIndexPage extends TestNGBase {

    @Test(dataProvider = "dataProviderToGetTextBelowPicturesOnIndexPage", dataProviderClass = DataProviders.class)
    public void verifyTextBelowPictures(String text, int testNumber) {

        List<WebElement> textsBelowPictures = driver.findElements(By.cssSelector("div[class='row clerafix benefits'] span[class='benefit-txt']"));
        assertEquals(textsBelowPictures.get(testNumber).getText(), text);
    }
}
