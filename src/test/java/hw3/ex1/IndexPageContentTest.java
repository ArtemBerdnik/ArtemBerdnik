package hw3.ex1;

import base.TestNGBaseHW3;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.IndexPage;

import static enums.IFrames.IFRAME;
import static enums.Users.PITER_CHAILOVSKII;

public class IndexPageContentTest extends TestNGBaseHW3 {

    private IndexPage indexPage;

    @BeforeMethod
    public void beforeMethod() {
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @Test
    public void verifyingIndexHtmlPage() {
        //2. Assert Browser title
        indexPage.checkTitle(driver);

        //3. Perform login
        indexPage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4. Assert displayed username
        indexPage.checkDisplayedUserName();

        //5. Assert Browser title
        indexPage.checkTitle(driver);

        //6. Assert buttons and dropdowns in the page header
        indexPage.checkTextForControlsInHeader();

        //7. Assert icons are being displayed in the page
        indexPage.checkIconsAreDisplayed();

        //8. Assert text is being displayed below icons
        indexPage.checkTextBelowIcons();

        //9. Assert the text of the main header
        indexPage.checkTitleInCenterOfPage();
        indexPage.checkJdiTextInCenterOfPage();

        //10. Assert that the iframe in the center of page is being displayed
        indexPage.checkIframeIsDisplayed();

        //11. Switching to the iframe and verifying that the EPAM logo is being displayed in the iframe
        indexPage.switchToIframe(driver, IFRAME.frameName);
        indexPage.checkEpamLogoIsDisplayed();

        //12. Switching to the original window back
        indexPage.switchToOriginalWindow(driver);

        //13. Assert the text of the sub header
        indexPage.checkSubheaderText();

        //14. Assert the link of the sub header
        indexPage.checkLinkOfSubheader();

        //15. Assert that left pane is being displayed
        indexPage.checkLeftPanelIsDisplayed();

        //16. Assert that footer is being displayed
        indexPage.checkFooterIsDisplayed();
    }
}
