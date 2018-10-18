package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageObjects.IndexPageSelenide;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static enums.Urls.INDEX_PAGE;

public class TestNGBaseHW4 {

    protected IndexPageSelenide indexPage;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        indexPage = page(IndexPageSelenide.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        open(INDEX_PAGE.getUrl);
    }
}
