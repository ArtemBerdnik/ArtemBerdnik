package hw7;

import base.JDITestsInit;
import org.testng.annotations.Test;

import static JDI.site.JDITestSite.*;

public class SubmitMetalsAndColorsForm  extends JDITestsInit {

    @Test
    public void loginTest() {
        //1. Login on JDI site as User
        homePage.open();
        login();
        homePage.checkOpened();

        //2. Open Metals & Colors page by Header menu
        openMetalsAndColorsPage();
        metalsAndColors.checkOpened();
    }
}
