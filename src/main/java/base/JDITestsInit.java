package base;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import jdi.site.JDITestSite;
import jdi.site.sections.Header;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static jdi.site.JDITestSite.metalsAndColors;
import static jdi.site.sections.Header.logout;

public class JDITestsInit extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JDITestSite.class);
        logger.info("Run Tests");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
//        logout();
        metalsAndColors.clearCache();
    }
}
