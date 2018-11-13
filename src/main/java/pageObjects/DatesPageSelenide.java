package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPageSelenide {

    @FindBy(xpath = "//div[@class='ui-slider-range ui-widget-header ui-corner-all']/preceding-sibling::a")
    private SelenideElement leftSliderInRange2;

    @FindBy(css = "div[class*='ui-slider-range'] + a")
    private SelenideElement rightSliderInRange2;

    @FindBy(css = "[class='panel-body-list logs'] li")
    private ElementsCollection logs;

    @FindBy(css = ".ui-slider")
    private SelenideElement slider;


    //===============================methods========================================
    @Step
    private double getStep() {
        return (double) slider.getSize().getWidth() / 100;
    }

    @Step
    private void moveHandler(SelenideElement slider, double position) {
        double currentPosition = Double.parseDouble(slider.text());
        double offset = (position - currentPosition > 0) ? (position - currentPosition) * getStep() : (position - currentPosition - 1) * getStep();
        actions().dragAndDropBy(slider.toWebElement(), (int) offset, 0).build().perform();
    }

    @Step
    public void setSliders(double leftSlider, double rightSlider) {
        System.out.println(rightSliderInRange2.getLocation().x);
        if (leftSliderInRange2.getLocation().x == rightSliderInRange2.getLocation().x && rightSliderInRange2.getLocation().x == 1156) {
            moveHandler(leftSliderInRange2, leftSlider);
            moveHandler(rightSliderInRange2, rightSlider);
        } else {
            moveHandler(rightSliderInRange2, rightSlider);
            moveHandler(leftSliderInRange2, leftSlider);
        }
    }

    //===============================checks==========================================

    @Step
    public void checkInfoInLogAboutSliders(int from, int to) {
        logs.findBy(text("(From):" + (String.valueOf(from)))).shouldHave(text("Range 2(From):" + String.valueOf(from) + " link clicked"));
        logs.findBy(text("(To):" + (String.valueOf(to)))).shouldHave(text("Range 2(To):" + String.valueOf(to) + " link clicked"));
    }

}
