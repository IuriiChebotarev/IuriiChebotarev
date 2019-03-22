package Homeworks.hw10;

import Homeworks.hw10.constans.YandexSpellerConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Homeworks.hw10.constans.YandexSpellerConstants.*;

public class ApiBuilder {

    YandexSpellerCheckTextsApi spellerApi;

    ApiBuilder(YandexSpellerCheckTextsApi gcApi) {

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
                .get(PropertyGetter.getYandexSpellerURL()).prettyPeek();
    }
}
