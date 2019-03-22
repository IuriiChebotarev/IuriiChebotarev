package Homeworks.hw10;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyGetter {

    public static String getYandexSpellerURL() {
        String yandex_speller_url = "";
        InputStream inputStream = null;
        String FileName = "test.properties";
        try {
            try {
                Properties pro = new Properties();
                inputStream = PropertyAccessor.class.getClassLoader().getResourceAsStream(FileName);

                if (inputStream != null) {
                    pro.load(inputStream);
                } else {
                    throw new FileNotFoundException();
                }
                yandex_speller_url = pro.getProperty("yandex_speller_url");
            } finally {
                if (inputStream != null) inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return yandex_speller_url;
    }
}
