package hw3.pageObject.enums;

public enum TextsOfHeaders {
    MAIN_HEADER_TITLE("EPAM FRAMEWORK WISHES…"),
    MAIN_HEADER_TEXT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
            "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT " +
            "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM " +
            "DOLORE EU FUGIAT NULLA PARIATUR."),
    SUB_HEADER_TEXT("JDI GITHUB");

    private final String value;

    TextsOfHeaders(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
    }
