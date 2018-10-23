package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.CoordinatesForRange2Slider;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPageSelenide {

    @FindBy(xpath = "//div[@class='ui-slider-range ui-widget-header ui-corner-all']/preceding-sibling::a")
    private SelenideElement leftSliderInRange2;

    @FindBy(css = "div[class*='ui-slider-range'] + a")
    private SelenideElement rightSliderInRange2;

    @FindBy(css = "[class='panel-body-list logs'] li")
    private List<SelenideElement> logs;


    //===============================methods========================================

    public void moveSlider(CoordinatesForRange2Slider leftSlider, CoordinatesForRange2Slider rightSlider) {
        Actions builder = new Actions(getWebDriver());
        if (leftSliderInRange2.getLocation().x == rightSliderInRange2.getLocation().x && rightSliderInRange2.getLocation().x > 1000) {
            builder.clickAndHold(leftSliderInRange2).moveByOffset(leftSlider.xAxisCoordinate - leftSliderInRange2.getLocation().x, 0).release().perform();
            builder.clickAndHold(rightSliderInRange2).moveByOffset(rightSlider.xAxisCoordinate - rightSliderInRange2.getLocation().x, 0).release().perform();
        } else {
            builder.clickAndHold(rightSliderInRange2).moveByOffset(rightSlider.xAxisCoordinate - rightSliderInRange2.getLocation().x, 0).release().perform();
            builder.clickAndHold(leftSliderInRange2).moveByOffset(leftSlider.xAxisCoordinate - leftSliderInRange2.getLocation().x, 0).release().perform();
        }
    }

    //===============================checks==========================================

    public void checkInfoInLogAboutSliders(CoordinatesForRange2Slider from, CoordinatesForRange2Slider to) {
        $$(logs).findBy(text("(From):" + (String.valueOf(from.value)))).shouldHave(text("Range 2(From):" + String.valueOf(from.value) + " link clicked"));
        $$(logs).findBy(text("(To):" + (String.valueOf(to.value)))).shouldHave(text("Range 2(To):" + String.valueOf(to.value) + " link clicked"));
    }

}
