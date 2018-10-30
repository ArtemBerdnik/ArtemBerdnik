package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class TestNGBaseHW4 {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }
}
