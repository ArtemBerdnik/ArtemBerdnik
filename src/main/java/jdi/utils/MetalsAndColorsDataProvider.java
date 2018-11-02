package jdi.utils;

import base.JDITestsInit;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jdi.entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;

import static jdi.utils.Reader.parseJson;

public class MetalsAndColorsDataProvider extends JDITestsInit {

    @DataProvider
    public static Object[][] simpleDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        // TODO Code convention !
        JsonObject METALS_AND_COLORS_JSON = parseJson("src\\main\\resources\\JDI_ex8_metalsColorsDataSet.json");
        Object[][] result = new Object[METALS_AND_COLORS_JSON.size()][1];

        for (int i = 1; i <= METALS_AND_COLORS_JSON.size(); i++) {
            result[i - 1][0] = gson.fromJson(METALS_AND_COLORS_JSON.get("data_" + i), MetalsAndColorsData.class);
        }
        return result;
    }
}
