package lesson4;

import base.SelenideTestBase;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide_old;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Users.PITER_CHAILOVSKII;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenidePageObject extends SelenideTestBase {

    private HomePageSelenide_old homePageSelenideOld;

    @BeforeClass
    public void beforeClass(){
        homePageSelenideOld = page(HomePageSelenide_old.class);
    }

    @Test
    public void simpleTest() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //navigate
        homePageSelenideOld.openPage();

        //assert title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //login
        homePageSelenideOld.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);
//        $(".profile-photo").click();
//        $("[id='Name']").sendKeys("epam");
//        $("[id='Password']").sendKeys("1234");
//        $("[type='fillData']").click();
//        $(By.xpath(""));
//        $$(By.xpath(""));

        //check main title
        SelenideElement mainTitle = $("h3.main-title");
//        Assert.assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));
        mainTitle.shouldBe(visible);

        //check 4
//        $$(By.xpath("")).shouldHaveSize(4);
//        $$(By.xpath("")).shouldBe(CollectionCondition.sizeLessThan(5));
    }
}
