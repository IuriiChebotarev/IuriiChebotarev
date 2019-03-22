package Homeworks.hw10;

import Homeworks.hw10.beans.YandexSpellerAnswer;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class YandexSpellerChecks {

    public static void checkAnswerSize(List<YandexSpellerAnswer> answer, int size) {
        assertThat("Size is incorrect.", answer.size(), equalTo(size));
    }

    public static void checkAnswerIsCorrect(List<YandexSpellerAnswer> answer, int answerNumber, String corrVer) {
        assertThat("Incorrect answer", answer.get(answerNumber).s, hasItem(corrVer));
    }
}
