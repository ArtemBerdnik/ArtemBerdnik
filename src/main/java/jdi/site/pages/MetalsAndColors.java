package jdi.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import jdi.entities.MetalsAndColorsData;
import jdi.site.forms.MetalColorForm;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/metals-colors.html")
public class MetalsAndColors extends WebPage {

    private MetalColorForm metalColorForm;

    @Step
    public void fillNewDataToMetalColorForm(MetalsAndColorsData newData) {
        metalColorForm.submit(newData);
    }
}
