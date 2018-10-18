package hw3.ex1;

import base.TestNGBaseHW3;
import org.testng.annotations.Test;

public class IndexPageContentTest extends TestNGBaseHW3 {

    @Test
    public void verifyingIndexHtmlPage() {
        //2. Assert Browser title
        indexPage.checkTitle();

        //3. Perform login
        indexPage.login("epam", "1234");

        //4. Assert displayed username
        indexPage.checkDisplayedUserName();

        //5. Assert Browser title
        indexPage.checkTitle();

        //6. Assert buttons and dropdowns in the page header
        indexPage.checkTextForHomeButtonInPageHeader();
        indexPage.checkTextForContactButtonInPageHeader();
        indexPage.checkTextForServiceDropdownInPageHeader();
        indexPage.checkTextForMetalsAndColorsButtonInPageHeader();

        //7. Assert icons are being displayed in the page
        indexPage.checkPracticeIconIsDisplayed();
        indexPage.checkCustomIconIsDisplayed();
        indexPage.checkMultiplatformIconIsDisplayed();
        indexPage.checkBaseIconIsDisplayed();

        //8. Assert text is being displayed below icons
        indexPage.checkTextBelowPracticeIcon();
        indexPage.checkTextBelowCustomIcon();
        indexPage.checkTextBelowMultiplatformIcon();
        indexPage.checkTextBelowBaseIcon();

        //9. Assert the text of the main header
        indexPage.checkTitleInCenterOfPage();
        indexPage.checkJdiTextInCenterOfPage();

        //10. Assert that the iframe in the center of page is being displayed
        indexPage.checkIframeIsDisplayed();

        //11. Switching to the iframe and verifying that the EPAM logo is being displayed in the iframe
        indexPage.switchToIframe("iframe");
        indexPage.checkEpamLogoIsDisplayed();

        //12. Switching to the original window back
        indexPage.switchToOriginalWindow();

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
