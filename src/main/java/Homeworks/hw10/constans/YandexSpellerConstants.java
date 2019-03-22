package Homeworks.hw10.constans;

public class YandexSpellerConstants {

    public static final String YANDEX_SPELLER_API_URI ="src/test/resources/test.properties/yandex_speller_url";

    public static final String PARAM_TEXT = "text";
    public static final String PARAM_OPTIONS = "options";
    public static final String PARAM_LANGS = "languages";

    public enum Languages {
        RU("ru"),
        UK("uk"),
        EN("en");

        public String languageCode;

        private Languages(String lang) {

            this.languageCode = lang;
        }

        public String getLang() {
            return languageCode;
        }
    }

    public enum ErrorCodes {
        ERROR_UNKNOWN_WORD("1"),
        ERROR_REPEAT_WORD("2"),
        ERROR_CAPITALIZATION("3"),
        ERROR_TOO_MANY_ERRORS("4");

        private String code;

        public String getCode() {
            return code;}

        private ErrorCodes(String code) {
            this.code = code;
        }

    }
    public enum Options {
        IGNORE_DIGITS(2),
        IGNORE_URLS(4),
        FIND_REPEAT_WORDS(8),
        IGNORE_CAPITALIZATION(512);

        private int option;

        public int getOption() {
            return option;
        }

        private Options(int option) {
            this.option = option;


        }
    }
}
