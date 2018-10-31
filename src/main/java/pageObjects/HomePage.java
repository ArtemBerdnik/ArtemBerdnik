package pageObjects;

import base.TestNGBaseHW3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage extends TestNGBaseHW3 {

    @FindBy(css = "#user-icon")
    private WebElement userIcon;

    @FindBy(css = "#Name")
    private WebElement login;

    @FindBy(css = "#Password")
    private WebElement password;

    @FindBy(css = "[type = 'submit']")
    private WebElement submitButton;

    @FindBy(css = "[class=\"profile-photo\"] > [ui = \"label\"]")
    private WebElement userName;

    @FindBy(css = "[class=\"uui-navigation nav navbar-nav m-l8\"] > li > [href=\"index.html\"]")
    private WebElement homeButtonInPageHeader;

    @FindBy(css = "[class=\"uui-navigation nav navbar-nav m-l8\"] > li > [href=\"contacts.html\"]")
    private WebElement contactButtonInPageHeader;

    @FindBy(css = "[class=\"uui-navigation nav navbar-nav m-l8\"] > [class=\"dropdown\"]")
    private WebElement serviceDropdownInPageHeader;

    @FindBy(css = "[class=\"uui-navigation nav navbar-nav m-l8\"] > li > [href=\"metals-colors.html\"]")
    private WebElement metalsAndColorsButtonInPageHeader;

    @FindBy(css = "[class=\"icons-benefit icon-practise\"]")
    private WebElement practiceIcon;

    @FindBy(css = "[class=\"icons-benefit icon-custom\"]")
    private WebElement customIcon;

    @FindBy(css = "[class=\"icons-benefit icon-multi\"]")
    private WebElement multiplatformIcon;

    @FindBy(css = "[class=\"icons-benefit icon-base\"]")
    private WebElement baseIcon;

    @FindBy(xpath = "//*[contains(text(), 'good practices')]")
    private WebElement textBelowPracticeIcon;

    @FindBy(xpath = "//*[contains(text(), 'To be flexible')]")
    private WebElement textBelowCustomIcon;

    @FindBy(xpath = "//*[contains(text(), 'multiplatform')]")
    private WebElement textBelowMultiplatformIcon;

    @FindBy(xpath = "//*[contains(text(), 'good base')]")
    private WebElement textBelowBaseIcon;

    @FindBy(css = "[name = \"main-title\"]")
    private WebElement titleInCenterOfPage;

    @FindBy(css = "[name = \"jdi-text\"]")
    private WebElement jdiTextInCenterOfPage;

    @FindBy(css = "#iframe")
    private WebElement iFrameInCenterOfPage;

    @FindBy(css = "#epam_logo")
    private WebElement epamLogo;

    @FindBy(css = "[class=\"text-center\"] > a")
    private WebElement jdiSubHeader;

    @FindBy(css = "[name = \"navigation-sidebar\"]")
    private WebElement leftPanel;

    @FindBy(css = "[class=\"footer-content overflow\"]")
    private WebElement footer;

    //===============================methods========================================

    public void login(String name, String pass) {
        userIcon.click();
        login.sendKeys(name);
        password.sendKeys(pass);
        submitButton.click();
    }

    public void switchToIframe(WebDriver driver, String iFrameName) {
        driver.switchTo().frame(iFrameName);
    }

    public void switchToOriginalWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //===============================checks==========================================
    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkDisplayedUserName() {
        assertEquals(userName.getText(), "PITER CHAILOVSKII");
    }

    public void checkTextForControlsInHeader() {
        assertEquals(homeButtonInPageHeader.getText(), "HOME");
        assertEquals(contactButtonInPageHeader.getText(), "CONTACT FORM");
        assertEquals(serviceDropdownInPageHeader.getText(), "SERVICE");
        assertEquals(metalsAndColorsButtonInPageHeader.getText(), "METALS & COLORS");
    }

    public void checkIconsAreDisplayed() {
        assertTrue(practiceIcon.isDisplayed());
        assertTrue(customIcon.isDisplayed());
        assertTrue(multiplatformIcon.isDisplayed());
        assertTrue(baseIcon.isDisplayed());
    }

    public void checkTextBelowIcons() {
        assertEquals(textBelowPracticeIcon.getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(textBelowCustomIcon.getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(textBelowMultiplatformIcon.getText(), "To be multiplatform");
        assertEquals(textBelowBaseIcon.getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
    }

    public void checkJdiTextInCenterOfPage() {
        assertEquals(jdiTextInCenterOfPage.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR " +
                "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT " +
                "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    public void checkTitleInCenterOfPage() {
        assertEquals(titleInCenterOfPage.getText(), "EPAM FRAMEWORK WISHES…");
    }

    public void checkIframeIsDisplayed() {
        assertTrue(iFrameInCenterOfPage.isDisplayed());
    }

    public void checkEpamLogoIsDisplayed() {
        assertTrue(epamLogo.isDisplayed());
    }

    public void checkSubheaderText() {
        assertEquals(jdiSubHeader.getText(), "jdi GITHUB");
    }

    public void checkLinkOfSubheader() {
        assertEquals(jdiSubHeader.getAttribute("href"), "https://github.com/epam/jdi");
        assertTrue(jdiSubHeader.isDisplayed());
        assertTrue(jdiSubHeader.isEnabled());
    }

    public void checkLeftPanelIsDisplayed() {
        leftPanel.isDisplayed();
    }

    public void checkFooterIsDisplayed() {
        footer.isDisplayed();
    }
}
