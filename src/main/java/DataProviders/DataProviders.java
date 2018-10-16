package DataProviders;

import Base.TestNGBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class DataProviders extends TestNGBase {

    @DataProvider
    public Object[][] simpleDataProvider(){
        return new Object[][] {
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }

    @DataProvider
    public Object[][] dataProviderToGetTextBelowPicturesOnIndexPage() {
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
}
