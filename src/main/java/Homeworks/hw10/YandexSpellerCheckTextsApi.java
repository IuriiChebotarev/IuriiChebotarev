package Homeworks.hw10;

import static Homeworks.hw10.constans.YandexSpellerConstants.PARAM_LANGS;
import static Homeworks.hw10.constans.YandexSpellerConstants.PARAM_OPTIONS;
import static Homeworks.hw10.constans.YandexSpellerConstants.PARAM_TEXT;
import static org.hamcrest.Matchers.lessThan;

import Homeworks.hw10.constans.YandexSpellerConstants;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//todo в этом классе оставь только запросы/формирование запросов к апи. например getSpellChecker()
public class YandexSpellerCheckTextsApi {

    private YandexSpellerCheckTextsApi() {
    }

    //todo https://speller.yandex.net/ это тоже кончстанта. может быть в файле с кончитантами или вообще в test.properties, что правильнее
    public static final String YANDEX_SPELLER_API_URI =
            "https://speller.yandex.net/services/spellservice.json/checkTexts";

    private HashMap<String, Object> params = new HashMap<>();


    //todo перенеси в другой класс, в котором будут вормироваться параметры.
    public static class ApiBuilder {
        YandexSpellerCheckTextsApi spellerApi;

        private ApiBuilder(YandexSpellerCheckTextsApi gcApi) {

            spellerApi = gcApi;
        }

        public ApiBuilder texts(String... texts) {
            List<String> textsList = Arrays.asList(texts);
            spellerApi.params.put(PARAM_TEXT, textsList);
            return this;
        }

        public ApiBuilder options(int options) {
            spellerApi.params.put(PARAM_OPTIONS, options);
            return this;
        }

        public ApiBuilder languages(YandexSpellerConstants.Languages... languages) {
            List<String> languagesList = new ArrayList<>();
            for (YandexSpellerConstants.Languages language : languages) {
                languagesList.add(language.getLang());
            }
            String newLanguageList = String.join(", ", languagesList);
            spellerApi.params.put(PARAM_LANGS, newLanguageList);
            return this;
        }

        public Response callApi() {
            return RestAssured.with()
                    .queryParams(spellerApi.params)
                    .log().all()
                    .get(YANDEX_SPELLER_API_URI).prettyPeek();
        }
    }


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
                .setBaseUri(YANDEX_SPELLER_API_URI)
                .build();
    }
}


