package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Urls.HOME_PAGE;

@CucumberOptions(features = "src/test/java/hw6", glue = "pageObjects")
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }


    @BeforeClass
    public void beforeClass() {
        open(HOME_PAGE.getUrl);
    }

    @AfterMethod
    public void afterMethod() {
        getWebDriver().manage().deleteAllCookies();
        close();
    }
}
