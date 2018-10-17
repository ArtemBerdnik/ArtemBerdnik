package hw2.ex1;

import base.TestNGBase;
import dataProviders.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckingTextBelowPicturesOnIndexPage extends TestNGBase {

    @Test(dataProvider = "dataProviderToGetTextBelowPicturesOnIndexPage", dataProviderClass = DataProviders.class)
    public void verifyTextBelowPictures(int textNumber, String text) {
        switch (textNumber) {
            case 0:
                assertEquals(text, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");
                break;

            case 1:
                assertEquals(text, "To be flexible and\n" +
                        "customizable");
                break;

            case 2:
                assertEquals(text, "To be multiplatform");
                break;

            case 3:
                assertEquals(text, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");
                break;
        }
    }
}
