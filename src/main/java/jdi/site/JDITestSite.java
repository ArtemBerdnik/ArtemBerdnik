package jdi.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import io.qameta.allure.Step;
import jdi.entities.User;
import jdi.enums.MenuEnum;
import jdi.site.forms.LoginForm;
import jdi.site.pages.HomePage;
import jdi.site.pages.MetalsAndColors;
import jdi.site.sections.Header;

import static org.testng.Assert.assertEquals;

@JSite("https://epam.github.io/JDI/")
public class JDITestSite extends WebSite {
    public static HomePage homePage;
    public static Header header;
    public static LoginForm loginForm;
    public static MetalsAndColors metalsAndColors;

    @Step
    public static void login(User user) {
        homePage.profilePhoto.click();
        loginForm.loginAs(user);
    }

    @Step
    public static void openPageUnderServiceDropdown(MenuEnum page) {
        header.pagesUnderServiceDropdown.select(page.menuButton);
    }

    @Step
    public static void checkLoggedUser(User user) {
        assertEquals(header.profilePhoto.getText(), user.getUserName());
    }
}
