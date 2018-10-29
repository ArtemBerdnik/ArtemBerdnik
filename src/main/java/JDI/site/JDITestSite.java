package JDI.site;

import JDI.entities.User;
import JDI.site.pages.HomePage;
import JDI.site.pages.MetalsAndColors;
import JDI.site.sections.LoginForm;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import io.qameta.allure.Step;

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
