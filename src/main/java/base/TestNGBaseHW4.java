package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class TestNGBaseHW4 {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }
}
