package hw8;

import base.JDITestsInit;
import jdi.entities.MetalsAndColorsData;
import jdi.utils.MetalsAndColorsDataProvider;
import org.testng.annotations.Test;

import static jdi.site.JDITestSite.*;

public class SubmitMetalsAndColorsForm extends JDITestsInit {

    @Test(dataProvider = "simpleDataProvider", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void loginTest(MetalsAndColorsData newData) {
        //1. Login on jdi site as User
        homePage.open();
        //TODO shold be parametrised
        login();
        homePage.checkOpened();

        //2. Open Metals & Colors page by Header menu
        // TODO this will be better with parameter in order to 
        // avoid lots of almost the same methods
        openMetalsAndColorsPage();
        metalsAndColors.checkOpened();
        // !TODO

        //3. Fill form Metals & Colors by data below:
        // TODO Quite strange method's name.
        // Is this possible to fill OLD data or smth like this ?
        metalsAndColors.fillNewDataToMetalColorForm(newData);

        //4. Submit form Metals & Colors
        metalsAndColors.clickSubmitButton();

        //5. Result sections should contains data below:
        metalsAndColors.checkResultSection(newData);
    }
}
