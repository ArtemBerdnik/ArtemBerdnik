package jdi.utils;

import base.JDITestsInit;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import jdi.entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class MetalsAndColorsDataProvider extends JDITestsInit {

    private static Map<String, MetalsAndColorsData> dataMap;
    private static File file = new File("src\\main\\resources\\JDI_ex8_metalsColorsDataSet.json");

    @DataProvider
    public static Object[] simpleDataProvider() {
        try (JsonReader jsonReader = new JsonReader(new FileReader(file))) {
            Type token = new TypeToken<Map<String, MetalsAndColorsData>>() {{
            }}.getType();
            dataMap = new Gson().fromJson(jsonReader, token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap.values().toArray();
    }
}
