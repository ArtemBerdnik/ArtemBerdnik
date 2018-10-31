package jdi.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import io.qameta.allure.Step;
import jdi.entities.User;
import jdi.site.forms.LoginForm;
import jdi.site.pages.HomePage;
import jdi.site.pages.MetalsAndColors;

@JSite("https://epam.github.io/JDI/")
public class JDITestSite extends WebSite {
    public static HomePage homePage;

    public static LoginForm loginForm;
    public static MetalsAndColors metalsAndColors;

    @Step
    public static void login() {
        homePage.profilePhoto.click();
        loginForm.loginAs(new User());
    }

    @Step
    public static void openMetalsAndColorsPage() {
        homePage.MetalsAndColors.click();
    }
}
