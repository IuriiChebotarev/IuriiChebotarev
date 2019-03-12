package Homeworks.hw4.enums;

public enum HomePageData {

    HOME_PAGE_DATA("https://epam.github.io/JDI/", "Home Page");

    public String url;
    public String title;

    HomePageData(String url, String title) {
        this.url = url;
        this.title = title;
    }
}
