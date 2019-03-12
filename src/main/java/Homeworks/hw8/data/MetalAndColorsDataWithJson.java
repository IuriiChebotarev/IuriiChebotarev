package Homeworks.hw8.data;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;
public class MetalAndColorsDataWithJson {

    @DataProvider
    public static Object[][] jsonDataProvider() throws FileNotFoundException {

        final String PATH_TO_DATA_FILES="src/main/resources/JDI_ex8_metalsColorsDataSet.json";

        Gson gson = new Gson();
        JsonObject jsonDataSet = new JsonParser().parse(new FileReader(PATH_TO_DATA_FILES)).getAsJsonObject();
        Type token = new TypeToken<Map<String, MetalAndColorsData>>() {}.getType();
        Map<String, MetalAndColorsData> dataSets = gson.fromJson(jsonDataSet, token);

        Object[][] objects = new Object[dataSets.size()][1];
        int i = 0;
        for (String key : dataSets.keySet()) {
            objects[i++][0] = dataSets.get(key);
        }
        return objects;
    }
}

