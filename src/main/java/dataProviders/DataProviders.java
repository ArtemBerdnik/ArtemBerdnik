package dataProviders;

import base.TestNGBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviders extends TestNGBase {

    @DataProvider
    public Object[][] simpleDataProvider(){
        return new Object[][] {
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }
//This is the 1st version of DataProvider for HW2
//    @DataProvider
//    public Object[][] dataProviderToGetTextBelowPicturesOnIndexPage() {
//        return new Object[][]{
//                {
//                        1, driver.findElement(By.xpath("(//span[@class=\"benefit-txt\"])[1]")).getText()
//                },
//                {
//                        2, driver.findElement(By.xpath("(//span[@class=\"benefit-txt\"])[2]")).getText()
//                },
//                {
//                        3, driver.findElement(By.xpath("(//span[@class=\"benefit-txt\"])[3]")).getText()
//                },
//                {
//                        4, driver.findElement(By.xpath("(//span[@class=\"benefit-txt\"])[4]")).getText()
//                }
//        };
//    }
    @DataProvider(parallel = true)
    public Object[][] dataProviderToGetTextBelowPicturesOnIndexPage() {
        List<WebElement> a = driver.findElements(By.cssSelector("div[class='row clerafix benefits'] span[class='benefit-txt']"));

        return new Object[][]{
                {0, a.get(0).getText()},
                {1, a.get(1).getText()},
                {2, a.get(2).getText()},
                {3, a.get(3).getText()},
        };
    }
}
