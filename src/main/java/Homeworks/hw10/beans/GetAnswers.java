package Homeworks.hw10.beans;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;

public class GetAnswers {

    public static List<YandexSpellerAnswer> getYandexSpellerAnswers(Response response) {
        List<List<YandexSpellerAnswer>> answersList = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<List<List<YandexSpellerAnswer>>>() {
                }.getType());
        List<YandexSpellerAnswer> totalAnswersList = new ArrayList<>();
        for (List<YandexSpellerAnswer> answer : answersList) {
            if (answer.size() < 1) {
                return totalAnswersList;
            }
            totalAnswersList.add(answer.get(0));
        }
        return totalAnswersList;
    }

}
