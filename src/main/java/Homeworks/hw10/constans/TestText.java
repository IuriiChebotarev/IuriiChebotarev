package Homeworks.hw10.constans;

public enum TestText {
        MONTH_RU("месяц", "месац"),
        MONTH_UK("місяць", "місяц"),
        MONTH_EN("month", "manth"),
        MONTH_WITH_EXTRA_RU("месяц", "месяцц"),
        MONTH_WITH_EXTRA_UK("місяць", "місяцць"),
        MONTH_WITH_EXTRA_EN("month", "montth"),
        MONTH_WITH_MISSED_RU("месяц", "мсяц"),
        MONTH_WITH_MISSED_UK("місяць", "мсяць"),
        MONTH_WITH_MISSED_EN("month", "monh"),
        MONTH_WITH_DIF_REG_RU("месяц", "мЕсЯц"),
        MONTH_WITH_DIF_REG_UK("місяць", "міСЯць"),
        MONTH_WITH_DIF_REG_EN("month", "monTh"),
        MONTH_WITH_REP_WORDS_RU("месяц", "Июль это теплый месяц месяц"),
        MONTH_WITH_REP_WORDS_UK("місяць", "Липень це теплий місяць місяць"),
        MONTH_WITH_REP_WORDS_EN("month", "July is a warm month month"),
        MONTH_WITH_DIGITS_RU("месяц123", "Июль это теплый месяц123"),
        MONTH_WITH_DIGITS_UK("123місяць", "Липень це теплий 123місяць"),
        MONTH_WITH_DIGITS_EN("warm123", "July is a warm123 month"),
        CAPITAL_RU("санкт-петербург","санкт-Петербург"),
        CAPITAL_UK("київ","київ"),
        CAPITAL_EN("london","london"),
        URL_TEXT("This text contains URL http://yandex.ru","This text contains URL http://yandex.ru);");

        private String corrVer;
        private String wrongVer;

        public String corrVer(){
            return corrVer;}

            public String wrongVer(){
            return wrongVer;}

        private TestText(String corrVer, String wrongVer){
            this.corrVer = corrVer;
            this.wrongVer = wrongVer;
        }
    }