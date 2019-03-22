package Homeworks.hw10;

import static org.hamcrest.Matchers.lessThan;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Random;

//todo в этом классе оставь только запросы/формирование запросов к апи. например getSpellChecker()
public class YandexSpellerCheckTextsApi {



    //todo https://speller.yandex.net/ это тоже кончстанта. может быть в файле с кончитантами или вообще в test.properties, что правильнее--done
    public HashMap<String, Object> params = new HashMap<>();


    //todo перенеси в другой класс, в котором будут вормироваться параметры.
    public static ApiBuilder with() {
        YandexSpellerCheckTextsApi api = new YandexSpellerCheckTextsApi();
        return new ApiBuilder(api);
    }

    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectHeader("Connection", "keep-alive")
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static RequestSpecification baseRequestConfiguration() {
        return new RequestSpecBuilder()
                .setAccept(ContentType.XML)
                .setRelaxedHTTPSValidation()
                .addHeader("custom header2", "header2.value")
                .addQueryParam("requestID", new Random().nextLong())
                .setBaseUri(PropertyGetter.getYandexSpellerURL())
                .build();
    }
}


