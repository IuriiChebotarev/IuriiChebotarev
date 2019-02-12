package hw4.enums;

public enum ServiceDropDown {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLES_WITH_PAGE("Tables With Pages"),
    DIFFERENT_ELEMENTS("Different Elements");

    public String text;

    ServiceDropDown(String text) {
        this.text = text;
    }
}
