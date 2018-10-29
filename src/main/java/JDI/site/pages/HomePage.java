package JDI.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/index.html", title = "Home Page")
public class HomePage extends WebPage {

    @FindBy(css = ".profile-photo")
    public Label profilePhoto;

    @FindBy(css = "[class = 'uui-navigation nav navbar-nav m-l8'] [href='metals-colors.html']")
    public Link MetalsAndColors;
}
