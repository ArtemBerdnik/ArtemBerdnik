package hw3.ex1;

import base.TestNGBaseHW3;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import static enums.IFrames.IFRAME;
import static enums.Users.PITER_CHAILOVSKII;

public class HomePageContentTest extends TestNGBaseHW3 {

    private HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void verifyingIndexHtmlPage() {
        //2. Assert Browser title
        homePage.checkTitle(driver);

        //3. Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4. Assert displayed username
        homePage.checkDisplayedUserName();

        //5. Assert Browser title
        homePage.checkTitle(driver);

        //6. Assert buttons and dropdowns in the page header
        homePage.checkTextForControlsInHeader();

        //7. Assert icons are being displayed in the page
        homePage.checkIconsAreDisplayed();

        //8. Assert text is being displayed below icons
        homePage.checkTextBelowIcons();

        //9. Assert the text of the main header
        homePage.checkTitleInCenterOfPage();
        homePage.checkJdiTextInCenterOfPage();

        //10. Assert that the iframe in the center of page is being displayed
        homePage.checkIframeIsDisplayed();

        //11. Switching to the iframe and verifying that the EPAM logo is being displayed in the iframe
        homePage.switchToIframe(driver, IFRAME.frameName);
        homePage.checkEpamLogoIsDisplayed();

        //12. Switching to the original window back
        homePage.switchToOriginalWindow(driver);

        //13. Assert the text of the sub header
        homePage.checkSubheaderText();

        //14. Assert the link of the sub header
        homePage.checkLinkOfSubheader();

        //15. Assert that left pane is being displayed
        homePage.checkLeftPanelIsDisplayed();

        //16. Assert that footer is being displayed
        homePage.checkFooterIsDisplayed();
    }
}
