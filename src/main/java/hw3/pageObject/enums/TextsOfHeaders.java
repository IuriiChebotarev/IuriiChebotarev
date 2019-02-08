package hw3.pageObject.enums;

public enum TextsOfHeaders {
    // TODO Why you set into one value?
    TEXTS_OF_HEADERS("EPAM FRAMEWORK WISHES…",
            "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.",
            "JDI GITHUB");

    public final String firstText;
    public final String secondText;
    public final String thirdText;

    TextsOfHeaders(String firstText, String secondText, String thirdText) {
        this.firstText = firstText;
        this.secondText = secondText;
        this.thirdText = thirdText;
    }
}
