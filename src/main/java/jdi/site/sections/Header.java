package jdi.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import io.qameta.allure.Step;
import jdi.enums.MenuEnum;

public class Header extends Section {

    @Css(".profile-photo")
    public Button profilePhoto;

    @Css("[class='uui-navigation nav navbar-nav m-l8'] a")
    public Menu<MenuEnum> pagesUnderServiceDropdown;
}
