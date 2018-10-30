package hw4;

import base.TestNGBaseHW4;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.CoordinatesForRange2Slider.*;
import static enums.Urls.INDEX_PAGE;
import static enums.Users.PITER_CHAILOVSKII;

public class DataPageSliderCheck extends TestNGBaseHW4 {

    private HomePageSelenide homePage;
    private DatesPageSelenide datesPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide.class);
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        //Configuration.startMaximized = true;
        //getWebDriver().manage().window().maximize();
    }

    @Test
    public void checkSlidersOnDataPage() {
        //1. Open test site by URL
        open(INDEX_PAGE.getUrl);

        //2. Assert Browser title
        homePage.checkTitle();

        //3. Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePage.checkDisplayedUserName();

        //5. Open through the header menu Service -> Dates Page
        homePage.openDatesPage();

        //6. Using drag-and-drop set Range sliders. (0-100)
//        datesPageSelenide.moveSlider(ZERO, HUNDRED);
        datesPageSelenide.setSliders(0,100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
//        datesPageSelenide.checkInfoInLogAboutSliders(ZERO, HUNDRED);
        datesPageSelenide.checkInfoInLogAboutSliders(0, 100);

        //8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
//        datesPageSelenide.moveSlider(ZERO, ZERO);
        datesPageSelenide.setSliders(0, 0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkInfoInLogAboutSliders(0, 0);

        //10. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
//        datesPageSelenide.moveSlider(HUNDRED, HUNDRED);
        datesPageSelenide.setSliders(100, 100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkInfoInLogAboutSliders(100, 100);

        //12. Using drag-and-drop set Range sliders. (30-70)
//        datesPageSelenide.moveSlider(THIRTY, SEVENTY);
        datesPageSelenide.setSliders(30, 70);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkInfoInLogAboutSliders(30, 70);

        // FIXME: 21.10.2018 : the bug in the latest step is that when right and left slider controls are in the same position, moving left slider will always logged as value for right one.
    }
}
