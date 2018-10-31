package jdi.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;

public class Header extends Section {

    @Css(".profile-photo")
    private static Button profilePhoto;

    @Css(".logout button")
    private static Button logoutButton;

    public static void logout() {
        profilePhoto.click();
        logoutButton.click();
    }
}
