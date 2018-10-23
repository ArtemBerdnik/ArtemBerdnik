package dataProviders;

import base.TestNGBase;
import org.testng.annotations.DataProvider;

import static enums.TextsBelowPictures.*;

public class DataProviders extends TestNGBase {

    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] dataProviderToGetTextBelowPicturesOnIndexPage() {
        return new Object[][]{
                {GOOD_PRACTICES.text, 0},
                {FLEXIBLE.text, 1},
                {MULTIPLATFORM.text, 2},
                {GOOD_BASE.text, 3},
        };
    }
}
