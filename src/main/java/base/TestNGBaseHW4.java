package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageObjects.DatesPageSelenide;
import pageObjects.DifferentElementsSelenide;
import pageObjects.IndexPageSelenide;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Urls.INDEX_PAGE;

public class TestNGBaseHW4 {

    protected IndexPageSelenide indexPage;
    protected DifferentElementsSelenide differentElementsSelenide;
    protected DatesPageSelenide datesPageSelenide;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        indexPage = page(IndexPageSelenide.class);
        differentElementsSelenide = page(DifferentElementsSelenide.class);
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        open(INDEX_PAGE.getUrl);
        getWebDriver().manage().window().maximize();
    }
}
