package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.currentTimeMillis;


public class TestBase {

    private long time;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        //setProperty("webdriver.chrome.driver", "C:\\Users\\khzc128\\IdeaProjects\\ArtemBerdnik\\src\\main\\resources\\chromedriver.exe");
        time = currentTimeMillis();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("Test framework worked: " + (currentTimeMillis() - time));
    }
}
