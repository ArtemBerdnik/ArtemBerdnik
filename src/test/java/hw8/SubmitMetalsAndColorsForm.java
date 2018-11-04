package hw8;

import base.JDITestsInit;
import jdi.entities.MetalsAndColorsData;
import jdi.utils.MetalsAndColorsDataProvider;
import org.testng.annotations.Test;

import static jdi.entities.User.PITER_CHAILOVSKI;
import static jdi.enums.MenuEnum.METALS_AND_COLORS;
import static jdi.site.JDITestSite.*;

public class SubmitMetalsAndColorsForm extends JDITestsInit {

    @Test(dataProvider = "simpleDataProvider", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void loginTest(MetalsAndColorsData data) {
        //1. Login on jdi site as User
        homePage.open();
        login(PITER_CHAILOVSKI);
        homePage.checkOpened();

        //2. Open Metals & Colors page by Header menu
        //openMetalsAndColorsPage();
        openPageUnderServiceDropdown(METALS_AND_COLORS);
        metalsAndColors.checkOpened();

        //3. Fill form Metals & Colors by data below:
        metalsAndColors.fillInFormsWithData(data);

        //4. Submit form Metals & Colors
        metalsAndColors.clickSubmitButton();

        //5. Result sections should contains data below:
        metalsAndColors.checkResultSection(data);
    }
}
