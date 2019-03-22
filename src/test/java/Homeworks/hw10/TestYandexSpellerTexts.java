package Homeworks.hw10;

import Homeworks.hw10.beans.GetAnswers;
import Homeworks.hw10.beans.YandexSpellerAnswer;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import java.util.List;
import static Homeworks.hw10.YandexSpellerCheckTextsApi.*;
import static Homeworks.hw10.YandexSpellerChecks.*;
import static Homeworks.hw10.constans.TestText.*;
import static Homeworks.hw10.constans.YandexSpellerConstants.Languages.*;
import static Homeworks.hw10.constans.YandexSpellerConstants.Options.*;

public class TestYandexSpellerTexts {

    @Test
    public void checkStatusCode() {
        RestAssured
                .given(baseRequestConfiguration())
                .get()
                .then().specification(successResponse());
    }

    @Test
    public void checkWordWithMistakeForRussianOnly() {
        List<YandexSpellerAnswer> answers =
                GetAnswers.getYandexSpellerAnswers(with()
                        .languages(RU)
                        .texts(MONTH_RU.wrongVer())
                        .callApi());
        checkAnswerSize(answers, 1);
        checkAnswerIsCorrect(answers, 0, MONTH_RU.corrVer());
    }

    @Test
    public void checkWordsWithMistakeForAllLanguages() {
        List<YandexSpellerAnswer> answers =
                GetAnswers.getYandexSpellerAnswers(with()
                        .languages(UK, EN, RU)
                        .texts(MONTH_RU.wrongVer(), MONTH_UK.wrongVer(), MONTH_EN.wrongVer())
                        .callApi());
        checkAnswerSize(answers, 3);
        checkAnswerIsCorrect(answers, 0, MONTH_RU.corrVer());
        checkAnswerIsCorrect(answers, 1, MONTH_UK.corrVer());
        checkAnswerIsCorrect(answers, 2, MONTH_EN.corrVer());
    }

    @Test
    public void checkWordsWithExtraSymbols() {
        List<YandexSpellerAnswer> answers =
                GetAnswers.getYandexSpellerAnswers(with()
                        .languages(UK, EN, RU)
                        .texts(MONTH_WITH_EXTRA_UK.wrongVer(), MONTH_WITH_EXTRA_RU.wrongVer(), MONTH_WITH_EXTRA_EN.wrongVer())
                        .callApi());
        checkAnswerSize(answers, 3);
        checkAnswerIsCorrect(answers, 0, MONTH_WITH_EXTRA_UK.corrVer());
        checkAnswerIsCorrect(answers, 1, MONTH_WITH_EXTRA_RU.corrVer());
        checkAnswerIsCorrect(answers, 2, MONTH_WITH_EXTRA_EN.corrVer());
    }

    @Test
    public void checkWordsWithMissedSymbols() {
        List<YandexSpellerAnswer> answers =
                GetAnswers.getYandexSpellerAnswers(with()
                        .languages(UK, EN, RU)
                        .texts(MONTH_WITH_MISSED_UK.wrongVer(), MONTH_WITH_MISSED_RU.wrongVer(), MONTH_WITH_MISSED_EN.wrongVer())
                        .callApi());
        checkAnswerSize(answers, 3);
        checkAnswerIsCorrect(answers, 0, MONTH_WITH_MISSED_UK.corrVer());
        checkAnswerIsCorrect(answers, 1, MONTH_WITH_MISSED_RU.corrVer());
        checkAnswerIsCorrect(answers, 2, MONTH_WITH_MISSED_EN.corrVer());
    }
    //Failed test, empty response returned
    @Test
    public void checkWordsWithDifferentRegister() {
        List<YandexSpellerAnswer> answers =
                GetAnswers.getYandexSpellerAnswers(with()
                        .languages(UK, EN, RU)
                        .texts(MONTH_WITH_DIF_REG_UK.wrongVer(), MONTH_WITH_DIF_REG_RU.wrongVer(), MONTH_WITH_DIF_REG_EN.wrongVer())
                        .callApi());
        checkAnswerSize(answers, 3);
        checkAnswerIsCorrect(answers, 0, MONTH_WITH_DIF_REG_UK.corrVer());
        checkAnswerIsCorrect(answers, 1, MONTH_WITH_DIF_REG_RU.corrVer());
        checkAnswerIsCorrect(answers, 2, MONTH_WITH_DIF_REG_EN.corrVer());
    }
    //Failed test, empty response returned
    @Test
    public void checkOptionFindRepeatedWord() {
        List<YandexSpellerAnswer> answers =
                GetAnswers.getYandexSpellerAnswers(with()
                        .options(FIND_REPEAT_WORDS.getOption())
                        .languages(UK, EN, RU)
                        .texts(MONTH_WITH_REP_WORDS_UK.wrongVer(), MONTH_WITH_REP_WORDS_RU.wrongVer(), MONTH_WITH_REP_WORDS_EN.wrongVer())
                        .callApi());
        checkAnswerSize(answers, 3);
        checkAnswerIsCorrect(answers, 0, MONTH_WITH_REP_WORDS_UK.corrVer());
        checkAnswerIsCorrect(answers, 1, MONTH_WITH_REP_WORDS_RU.corrVer());
        checkAnswerIsCorrect(answers, 2, MONTH_WITH_REP_WORDS_EN.corrVer());
    }
    //Failed test, empty response returned
    @Test
    public void checkOptionIgnoreDigits() {
        List<YandexSpellerAnswer> answers =
                GetAnswers.getYandexSpellerAnswers(with()
                        .options(IGNORE_DIGITS.getOption())
                        .languages(UK, EN, RU)
                        .texts(MONTH_WITH_DIGITS_UK.wrongVer(), MONTH_WITH_DIGITS_RU.wrongVer(), MONTH_WITH_DIGITS_EN.wrongVer())
                        .callApi());
        checkAnswerSize(answers, 3);
        checkAnswerIsCorrect(answers, 0, MONTH_WITH_DIGITS_UK.corrVer());
        checkAnswerIsCorrect(answers, 1, MONTH_WITH_DIGITS_RU.corrVer());
        checkAnswerIsCorrect(answers, 2, MONTH_WITH_DIGITS_EN.corrVer());
    }
    //Failed test, empty response returned
    @Test
    public void checkOptionIgnoreCapitalization() {
        List<YandexSpellerAnswer> answers =
                GetAnswers.getYandexSpellerAnswers(with()
                        .options(IGNORE_CAPITALIZATION.getOption())
                        .languages(UK, EN, RU)
                        .texts(CAPITAL_UK.wrongVer(), CAPITAL_RU.wrongVer(), CAPITAL_EN.wrongVer())
                        .callApi());
        checkAnswerSize(answers, 3);
        checkAnswerIsCorrect(answers, 0, CAPITAL_UK.corrVer());
        checkAnswerIsCorrect(answers, 1, CAPITAL_RU.corrVer());
        checkAnswerIsCorrect(answers, 2, CAPITAL_EN.corrVer());


    }
    //Failed test, empty response returned
    @Test
    public void checkOptionIgnoreURLs() {
        List<YandexSpellerAnswer> answers =
                GetAnswers.getYandexSpellerAnswers(with()
                        .options(IGNORE_URLS.getOption())
                        .languages(EN)
                        .texts(URL_TEXT.wrongVer())
                        .callApi());
        checkAnswerSize(answers, 1);
        checkAnswerIsCorrect(answers, 0, URL_TEXT.wrongVer());

    }
}








