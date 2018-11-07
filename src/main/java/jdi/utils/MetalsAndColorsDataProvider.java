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
        // TODO it is not really good idea to work with json in this way,
        // 'cause the name of the data might be different and without numbers.
        // Take a look on TypeToken
        Gson gson = new Gson();
        JsonObject metalsAndColorsJson = parseJson("src\\main\\resources\\JDI_ex8_metalsColorsDataSet.json");
        Object[][] result = new Object[metalsAndColorsJson.size()][1];

        for (int i = 1; i <= metalsAndColorsJson.size(); i++) {
            result[i - 1][0] = gson.fromJson(metalsAndColorsJson.get("data_" + i), MetalsAndColorsData.class);
        }
        return result;
    }
}
