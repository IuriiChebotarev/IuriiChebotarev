package hw3.pageObject.enums;

public enum HomePageData {
    INDEX_HTML_URL("https://epam.github.io/JDI/"),
    HOME_PAGE_TITLE("Home Page");

    public final String value;

    HomePageData(String value){

        this.value = value;
    }
@Override
    public String toString(){

        return value;
}
}