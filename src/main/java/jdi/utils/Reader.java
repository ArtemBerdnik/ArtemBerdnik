package jdi.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

class Reader {

    static JsonObject parseJson(String fileName) throws FileNotFoundException {
        return new JsonParser().parse(new FileReader(fileName)).getAsJsonObject();
    }
}
