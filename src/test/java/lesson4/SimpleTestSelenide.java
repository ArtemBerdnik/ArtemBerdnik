package lesson4;

import base.SelenideTestBase;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenide extends SelenideTestBase {

    @Test
    public void simpleTest() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //navigate
        open("https://epam.github.io/JDI/index.html");

        //assert title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //login
        $(".profile-photo").click();
        $("[id='Name']").sendKeys("epam");
        $("[id='Password']").sendKeys("1234");
        $("[type='submit']").click();
//        $(By.xpath(""));
//        $$(By.xpath(""));

        //check main title
        SelenideElement mainTitle = $("h3.main-title");
//        Assert.assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));
        mainTitle.shouldBe(visible);

        //check 4
        $$(By.xpath("")).shouldHaveSize(4);
        $$(By.xpath("")).shouldBe(CollectionCondition.sizeLessThan(5));
    }
}
