package jdi.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import jdi.entities.MetalsAndColorsData;
import jdi.site.forms.MetalColorForm;
import jdi.site.sections.LeftPanel;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/metals-colors.html")
public class MetalsAndColors extends WebPage {

    private MetalColorForm metalColorForm;
    private LeftPanel leftPanel;

    @Step
    public void fillNewDataToMetalColorForm(MetalsAndColorsData newData) {
        metalColorForm.fillData(newData);
    }

    @Step
    public void clickSubmitButton() {
        metalColorForm.submit();
    }

    @Step
    public void checkResultSection(MetalsAndColorsData newData) {
        leftPanel.compareResults(newData);
    }
}
